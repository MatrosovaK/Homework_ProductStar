package ru.productstar.mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.productstar.mockito.model.Customer;
import ru.productstar.mockito.repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository);
    }

    /**
     *  + Тест 1 - Получение покупателя "Ivan"
     * Проверки:
     * - очередность и точное количество вызовов каждого метода из CustomerRepository
     *
     *  + Тест 2 - Получение покупателя "Oleg"
     * Проверки:
     * - очередность и точное количество вызовов каждого метода из CustomerRepository
     * - в метод getOrCreate была передана строка "Oleg"
     */


    @Test
    void shouldReturnExistingCustomerIvan() {
        // подготавливаем данные
        Customer ivan = new Customer("Ivan");

        when(customerRepository.getByName("Ivan")).thenReturn(ivan);

        // вызываем тестируемый метод
        Customer result = customerService.getOrCreate("Ivan");

        // проверяем результат
        assertEquals("Ivan", result.getName());

        // Проверяем обращения к репозиторию
        InOrder inOrder = inOrder(customerRepository);
        inOrder.verify(customerRepository, times(1)).getByName("Ivan");

        verify(customerRepository, never()).add(any(Customer.class));
    }

    @Test
    void shouldCreateNewCustomerOleg() {
        // покупатель Oleg ещё не существует
        Customer oleg = new Customer("Oleg");

        when(customerRepository.getByName("Oleg")).thenReturn(null);
        when(customerRepository.add(any(Customer.class))).thenReturn(oleg);

        // вызываем метод
        Customer result = customerService.getOrCreate("Oleg");

        // Assert
        assertEquals("Oleg", result.getName());

        // Проверяем порядок вызовов
        InOrder inOrder = inOrder(customerRepository);
        inOrder.verify(customerRepository, times(1)).getByName("Oleg");
        inOrder.verify(customerRepository, times(1)).add(any(Customer.class));

        // Проверяем, какой объект передали в add()
        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).add(captor.capture());

        assertEquals("Oleg", captor.getValue().getName());
    }


    @Test
    void shouldPropagateExceptionWhenRepositoryFails() {
        // Arrange — репозиторий выбрасывает исключение
        when(customerRepository.getByName("Ivan"))
                .thenThrow(new RuntimeException("Database error"));

        // Act & Assert — сервис должен передать исключение дальше
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> customerService.getOrCreate("Ivan")
        );

        assertEquals("Database error", exception.getMessage());

        // При ошибке поиска покупатель не должен создаваться
        verify(customerRepository, never()).add(any(Customer.class));
    }



}
