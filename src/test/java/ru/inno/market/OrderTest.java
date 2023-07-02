package ru.inno.market;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import ru.inno.market.core.Catalog;
import ru.inno.market.model.Client;
import ru.inno.market.model.Order;

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

    @Test
    public void ShouldGetId() {
        assertEquals(testOrderId, order.getId());
    }
}