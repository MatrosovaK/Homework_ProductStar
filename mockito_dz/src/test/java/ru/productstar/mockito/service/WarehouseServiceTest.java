package ru.productstar.mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.productstar.mockito.model.Product;
import ru.productstar.mockito.model.Stock;
import ru.productstar.mockito.model.Warehouse;
import ru.productstar.mockito.repository.InitRepository;
import ru.productstar.mockito.repository.WarehouseRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WarehouseServiceTest {


    @Mock
    private WarehouseRepository warehouseRepository;

    @InjectMocks
    private WarehouseService warehouseService;


    /**
     * Покрыть тестами методы findWarehouse и findClosestWarehouse.
     * Вызывать реальные методы зависимых сервисов и репозиториев нельзя.
     * Поиск должен осуществляться как минимум на трех складах.
     *
     * Должны быть проверены следующие сценарии:
     * + поиск несуществующего товара
     * + поиск существующего товара с достаточным количеством
     * + поиск существующего товара с недостаточным количеством
     *
     * Проверки:
     * + товар находится на нужном складе, учитывается количество и расстояние до него
     * + корректная работа для несуществующего товара
     * + порядок и количество вызовов зависимых сервисов
     */

    private List<Warehouse> createWarehouses() {
        Product phone = new Product("phone");

        Warehouse warehouse1 = new Warehouse("Warehouse1", 30);
        warehouse1.addStock(new Stock(phone, 400, 5));

        Warehouse warehouse2 = new Warehouse("Warehouse2", 20);
        warehouse2.addStock(new Stock(phone, 380, 2));

        Warehouse warehouse3 = new Warehouse("Warehouse3", 5);
        warehouse3.addStock(new Stock(phone, 450, 3));

        return Arrays.asList(warehouse1, warehouse2, warehouse3);
    }

    @Test
    void shouldFindWarehouseWithEnoughStock() {
        // данные для репозитория
        when(warehouseRepository.all()).thenReturn(createWarehouses());

        // Ищем склад, на котором есть минимум 4 телефона
        Warehouse result = warehouseService.findWarehouse("phone", 4);

        // найден правильный склад
        assertEquals("Warehouse1", result.getName());

        // Проверяем, что репозиторий вызвали ровно один раз
        verify(warehouseRepository, times(1)).all();
    }

    @Test
    void shouldReturnNullWhenProductNotFound() {
        // Настраиваем мок: возвращаем три склада
        when(warehouseRepository.all()).thenReturn(createWarehouses());

        // Ищем товар, которого нет на складах
        Warehouse result = warehouseService.findWarehouse("tablet", 1);

        // Проверяем, что склад не найден
        assertNull(result);

        // Проверяем, что репозиторий вызвали один раз
        verify(warehouseRepository, times(1)).all();
    }

    @Test
    void shouldReturnNullWhenStockIsNotEnough() {
        // Настраиваем мок репозитория
        when(warehouseRepository.all()).thenReturn(createWarehouses());

        // Ищем 6 телефонов, но ни на одном складе столько нет
        Warehouse result = warehouseService.findWarehouse("phone", 6);

        // Проверяем, что склад не найден
        assertNull(result);

        // Проверяем количество обращений к репозиторию
        verify(warehouseRepository, times(1)).all();
    }

    @Test
    void shouldFindClosestWarehouse() {
        // Настраиваем мок репозитория
        when(warehouseRepository.all()).thenReturn(createWarehouses());

        // Ищем ближайший склад, где есть минимум 3 телефона
        Warehouse result = warehouseService.findClosestWarehouse("phone", 3);

        // Проверяем, что выбран ближайший подходящий склад
        assertEquals("Warehouse3", result.getName());

        // Проверяем, что репозиторий вызвали один раз
        verify(warehouseRepository, times(1)).all();
    }

    @Test
    void shouldReturnNullWhenNoWarehouseHasEnoughStock() {
        // Настраиваем мок репозитория
        when(warehouseRepository.all()).thenReturn(createWarehouses());

        // Ищем ближайший склад, где есть минимум 6 телефонов
        Warehouse result = warehouseService.findClosestWarehouse("phone", 6);

        // Ни один склад не располагает таким количеством
        assertNull(result);

        // Проверяем, что репозиторий вызвали один раз
        verify(warehouseRepository, times(1)).all();
    }

}
