package franklin.paul.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import franklin.paul.ecommerce.model.EcommerceUser;

@Repository
public interface EcommerceUserDAOInterface extends CrudRepository<EcommerceUser, String> {
    EcommerceUser findByUsername(String username);
}
