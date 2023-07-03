package ru.inno.market;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.inno.market.core.MarketService;
import ru.inno.market.model.Client;
import ru.inno.market.model.Item;
import ru.inno.market.model.Order;
import ru.inno.market.model.PromoCodes;

import static org.junit.jupiter.api.Assertions.*;


public class MarketServiceTest {
    MarketService service;
    Client client = new Client(1, "Dima");

    @BeforeEach
    public void setUp() {
        service = new MarketService();
    }


    @DisplayName("Корректное создание заказа")
    @Test
    public void shouldCreateOrder() {
        int orderId = service.createOrderFor(client);
        Order order = service.getOrderInfo(orderId);
        assertEquals(orderId, order.getId());
        assertEquals(client, order.getClient());
    }

    @DisplayName("Корректная обработка промокодов")
    @Test
    public void shouldUseDiscountForOrder() {
        Item item = new Item;
        int orderId = service.createOrderFor(client);
        service.addItemToOrder(item, orderId);
        double total = service.getOrderInfo(orderId).getTotalPrice();
        assertEquals(total * (1 - PromoCodes.FIRST_ORDER.getDiscount()),
                service.applyDiscountForOrder(orderId, PromoCodes.FIRST_ORDER));
    }

    @DisplayName("Невозможность получения двойной скидки")
    @ParameterizedTest
    @EnumSource(PromoCodes.class)
    public void shouldNotDoubleDiscountsForOrder(PromoCodes promo) {
        int orderId = service.createOrderFor(client);
        service.addItemToOrder(1, orderId);
        double total = service.applyDiscountForOrder(orderId, PromoCodes.FIRST_ORDER);
        assertEquals(total, service.applyDiscountForOrder(orderId, promo));
    }
}
