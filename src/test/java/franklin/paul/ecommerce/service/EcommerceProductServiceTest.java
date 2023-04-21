package franklin.paul.ecommerce.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import franklin.paul.ecommerce.dao.EcommerceProductDAOInterface;
import franklin.paul.ecommerce.model.EcommerceProduct;
import franklin.paul.ecommerce.service.EcommerceProductService;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class EcommerceProductServiceTest {
    private EcommerceProductService sut;
    private final EcommerceProductDAOInterface mockProductRepo = Mockito.mock(EcommerceProductDAOInterface.class);

    @Before
    public void init() {
        sut = new EcommerceProductService(mockProductRepo);
    }

    @Test
    public void test_findAllProducts_givenNothing() {
        // Arrange
        ArrayList<EcommerceProduct> products = new ArrayList<>();
        ArrayList<EcommerceProduct> products2 = new ArrayList<>();
        products2.add(new EcommerceProduct(UUID.randomUUID().toString(), "First Product", "First Product Description", 1.00));
        products2.add(new EcommerceProduct(UUID.randomUUID().toString(), "Second Product", "Second Product Description", 1.01));

        Mockito.doReturn(products).when(mockProductRepo).findAll();

        // Act
        ArrayList<EcommerceProduct> result = sut.findAllProducts();

        // Assert
        assertEquals(products2.size(), result.size());
        assertEquals(products2.get(0).getProductName(), result.get(0).getProductName());
        assertEquals(products2.get(1).getProductName(), result.get(1).getProductName());
    }
}
