package ru.inno.market;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.inno.market.core.Catalog;
import ru.inno.market.model.Client;
import ru.inno.market.model.Item;
import ru.inno.market.model.Order;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    Order order;
    int testOrderId = 1;
    Client client;
    int testItemId = 2;
    Catalog catalog = new Catalog();

    @BeforeEach
    public void setUp() {
        client = new Client(1, "Artur");
        order = new Order(testOrderId, client);
    }


    @DisplayName("Корректная очистка корзины при новом заказе")
    @Test
    public void ShouldHaveEmptyCartForTheNewOrders() {
        Map<Item, Integer> expectedMap = new HashMap<>();
        var actualMap = order.getCart();

        assertEquals(expectedMap, actualMap);
    }

    @DisplayName("Корректный возврат id заказа")
    @Test
    public void ShouldGetId()
    {
        assertEquals(testOrderId, order.getId());
    }

    @DisplayName("Корректный возврат id клиента")
    @Test
    public void shouldGetClient() {
        assertEquals(client, order.getClient());
    }
}
