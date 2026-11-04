package ru.productstar.mockito.service;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InOrder;
import ru.productstar.mockito.model.*;
import ru.productstar.mockito.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.productstar.mockito.ProductNotFoundException;
import ru.productstar.mockito.repository.InitRepository;
import ru.productstar.mockito.repository.ProductRepository;
import ru.productstar.mockito.repository.WarehouseRepository;

import static org.mockito.Mockito.spy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private CustomerService customerService;
    @Mock
    private WarehouseService warehouseService;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ProductRepository productRepository;
    private OrderService orderService;


    @BeforeEach
    void setUp() {
        orderService = new OrderService(
                customerService,
                warehouseService,
                orderRepository,
                productRepository
        );
    }

    /**
     * Покрыть тестами методы create и addProduct.
     * Можно использовать вызовы реальных методов.
     *
     * Должны быть проверены следующие сценарии:
     * + создание ордера для существующего и нового клиента
     * + добавление существующего и несуществующего товара
     * + добавление товара в достаточном и не достаточном количестве
     * + заказ товара с быстрой доставкой
     *
     * Проверки:
     * - общая сумма заказа соответствует ожидаемой
     * - корректная работа для несуществующего товара
     * - порядок и количество вызовов зависимых сервисов
     * - факт выбрасывания ProductNotFoundException
     */


    @Test
    void shouldCreateOrderForExistingCustomer() {
        // подготавливаем покупателя и заказ
        Customer customer = new Customer("Ivan");
        Order order = new Order(customer);

        when(customerService.getOrCreate("Ivan")).thenReturn(customer);
        when(orderRepository.create(customer)).thenReturn(order);

        // создаём заказ
        Order result = orderService.create("Ivan");

        // проверяем результат
        assertEquals(customer, result.getCustomer());

        // Проверяем порядок вызовов
        InOrder inOrder = inOrder(customerService, orderRepository);
        inOrder.verify(customerService, times(1)).getOrCreate("Ivan");
        inOrder.verify(orderRepository, times(1)).create(customer);
    }

    @Test
    void shouldCreateOrderForNewCustomer() {
        // CustomerService возвращает нового покупателя
        Customer customer = new Customer("Oleg");
        Order order = new Order(customer);

        when(customerService.getOrCreate("Oleg")).thenReturn(customer);
        when(orderRepository.create(customer)).thenReturn(order);

        // создаем заказ
        Order result = orderService.create("Oleg");

        // сравниваем результат
        assertEquals("Oleg", result.getCustomer().getName());

        // Проверяем порядок и количество вызовов
        InOrder inOrder = inOrder(customerService, orderRepository);
        inOrder.verify(customerService, times(1)).getOrCreate("Oleg");
        inOrder.verify(orderRepository, times(1)).create(customer);
    }

    @Test
    void shouldAddProductToOrder() throws ProductNotFoundException {
        //создаём заказ и товар
        Customer customer = new Customer("Ivan");
        Order order = new Order(customer);
        order.setId(1);

        Product product = new Product("phone");
        Warehouse warehouse = new Warehouse("Warehouse 1", 10);
        Stock stock = new Stock(product, 100, 10);

        warehouse.addStock(stock);

        // Настраиваем ответы mock-объектов
        when(warehouseService.findWarehouse("phone", 2))
                .thenReturn(warehouse);

        when(productRepository.getByName("phone"))
                .thenReturn(product);

        when(warehouseService.getStock(warehouse, "phone"))
                .thenReturn(stock);

        when(orderRepository.addDelivery(eq(1), any(Delivery.class)))
                .thenAnswer(invocation -> {
                    Delivery delivery = invocation.getArgument(1);
                    order.addDelivery(delivery);
                    return order;
                });

        // добавляем 2 телефона
        Order result = orderService.addProduct(order, "phone", 2, false);

        // проверяем итоговую сумму
        assertEquals(200, result.getTotal());

        // Проверяем количество доставок
        assertEquals(1, result.getDeliveries().size());

        // Проверяем порядок вызовов
        InOrder inOrder = inOrder(warehouseService, productRepository, orderRepository);

        inOrder.verify(warehouseService).findWarehouse("phone", 2);
        inOrder.verify(productRepository).getByName("phone");
        inOrder.verify(warehouseService).getStock(warehouse, "phone");
        inOrder.verify(orderRepository).addDelivery(eq(1), any(Delivery.class));
    }

    @Test
    void shouldThrowExceptionWhenProductIsNotAvailable() {
        // создаём заказ
        Customer customer = new Customer("Ivan");
        Order order = new Order(customer);
        order.setId(1);

        // Настраиваем склад: товара нет в нужном количестве
        when(warehouseService.findWarehouse("phone", 20))
                .thenReturn(null);

        // ожидаем исключение
        assertThrows(
                ProductNotFoundException.class,
                () -> orderService.addProduct(order, "phone", 20, false)
        );

        // Проверяем, что до репозиториев выполнение не дошло
        verify(productRepository, never()).getByName(anyString());
        verify(orderRepository, never()).addDelivery(anyInt(), any(Delivery.class));
    }

    @Test
    void shouldUseClosestWarehouseForFastDelivery() throws ProductNotFoundException {
        // создаем заказ, склад, товар, сток
        Customer customer = new Customer("Ivan");
        Order order = new Order(customer);
        order.setId(1);

        Product product = new Product("phone");
        Warehouse warehouse = new Warehouse("Closest warehouse", 5);
        Stock stock = new Stock(product, 100, 10);

        when(warehouseService.findClosestWarehouse("phone", 2))
                .thenReturn(warehouse);

        when(productRepository.getByName("phone"))
                .thenReturn(product);

        when(warehouseService.getStock(warehouse, "phone"))
                .thenReturn(stock);

        when(orderRepository.addDelivery(eq(1), any(Delivery.class)))
                .thenAnswer(invocation -> {
                    Delivery delivery = invocation.getArgument(1);
                    order.addDelivery(delivery);
                    return order;
                });

        // вызываем метод с ближайшим складом
        Order result = orderService.addProduct(order, "phone", 2, true);

        // сравниваем
        assertEquals(200, result.getTotal());

        // проверяем выбор склада для быстрой доставки, + что обычный поиск склада не вызывался
        verify(warehouseService).findClosestWarehouse("phone", 2);
        verify(warehouseService, never()).findWarehouse(anyString(), anyInt());
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void shouldCalculateTotalForDifferentProductCounts(int count)
            throws ProductNotFoundException {

        Customer customer = new Customer("Ivan");
        Order order = new Order(customer);
        order.setId(1);

        Product product = new Product("phone");
        Warehouse warehouse = new Warehouse("Warehouse 1", 10);
        Stock stock = new Stock(product, 100, 10);

        when(warehouseService.findWarehouse("phone", count))
                .thenReturn(warehouse);

        when(productRepository.getByName("phone"))
                .thenReturn(product);

        when(warehouseService.getStock(warehouse, "phone"))
                .thenReturn(stock);

        when(orderRepository.addDelivery(eq(1), any(Delivery.class)))
                .thenAnswer(invocation -> {
                    Delivery delivery = invocation.getArgument(1);
                    order.addDelivery(delivery);
                    return order;
                });

        Order result = orderService.addProduct(order, "phone", count, false);

        assertEquals(100L * count, result.getTotal());
    }



    @Test
    void shouldUseRealWarehouseServiceWithSpy() throws ProductNotFoundException {
        ProductRepository realProductRepository = new ProductRepository();
        WarehouseRepository realWarehouseRepository =
                new WarehouseRepository(realProductRepository);

        WarehouseService realWarehouseService =
                new WarehouseService(realWarehouseRepository);

        WarehouseService warehouseServiceSpy = spy(realWarehouseService);

        OrderRepository realOrderRepository = new OrderRepository();

        OrderService service = new OrderService(
                customerService,
                warehouseServiceSpy,
                realOrderRepository,
                realProductRepository
        );

        Customer customer = new Customer("Ivan");
        Order order = realOrderRepository.create(customer);

        Order result = service.addProduct(order, "phone", 2, true);

        assertEquals(900, result.getTotal());

        verify(warehouseServiceSpy).findClosestWarehouse("phone", 2);
        verify(warehouseServiceSpy).getStock(
                realWarehouseRepository.getById(2), "phone"
        );
    }

    // Проверяем, что OrderService корректно обрабатывает ошибку склада
    @Test
    void shouldHandleWarehouseServiceException() {
        Customer customer = new Customer("Ivan");
        Order order = new Order(customer);
        order.setId(1);

        when(warehouseService.findWarehouse("phone", 2))
                .thenThrow(new RuntimeException("Warehouse service error"));

        assertThrows(
                RuntimeException.class,
                () -> orderService.addProduct(order, "phone", 2, false)
        );

        verify(productRepository, never()).getByName(anyString());
        verify(orderRepository, never()).addDelivery(anyInt(), any(Delivery.class));
    }


}
