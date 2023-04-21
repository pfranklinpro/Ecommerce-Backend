package franklin.paul.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import franklin.paul.ecommerce.model.EcommerceProduct;

import java.util.ArrayList;

@Repository
public interface EcommerceProductDAOInterface extends CrudRepository<EcommerceProduct, String> {
    ArrayList<EcommerceProduct> findAll();
}
