package franklin.paul.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import franklin.paul.ecommerce.model.EcommerceOrder;

@Repository
public interface EcommerceOrderDAOInterface extends CrudRepository<EcommerceOrder, String> {
}
