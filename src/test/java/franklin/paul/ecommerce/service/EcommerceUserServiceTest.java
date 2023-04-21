package franklin.paul.ecommerce.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import franklin.paul.ecommerce.dao.EcommerceUserDAOInterface;
import franklin.paul.ecommerce.service.EcommerceUserService;

public class EcommerceUserServiceTest {
    private EcommerceUserService sut;
    private final EcommerceUserDAOInterface mockUserRepo = Mockito.mock(EcommerceUserDAOInterface.class);

    @Before
    public void init() {
        sut = new EcommerceUserService(mockUserRepo);
    }

    @Test
    public void test_newUser_givenNewUserRequest() {
        // Arrange

        // Act

        // Assert
    }

    @Test
    public void test_findUser_givenUsername() {
        // Arrange
        String username = "fwqeojfwe";

        // Act
        sut.findUser(username);

        // Assert
        Mockito.verify(mockUserRepo, Mockito.times(1)).findByUsername(username);
    }
}
