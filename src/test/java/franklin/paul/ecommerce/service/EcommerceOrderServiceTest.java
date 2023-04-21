package franklin.paul.ecommerce.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import franklin.paul.ecommerce.dao.EcommerceOrderDAOInterface;

public class EcommerceOrderServiceTest {
    private EcommerceOrderService sut;
    private final EcommerceOrderDAOInterface mockOrderRepo = Mockito.mock(EcommerceOrderDAOInterface.class);

    @Before
    public void init() {
        sut = new EcommerceOrderService(mockOrderRepo);
    }

    @Test
    public void test_createOrder_givenNewOrderRequestAndEcommerceUser() {
        // Arrange

        // Act

        // Assert
    }
}
