package franklin.paul.ecommerce.service;

import org.springframework.stereotype.Service;
import franklin.paul.ecommerce.dao.EcommerceOrderDAOInterface;
import franklin.paul.ecommerce.dtos.requests.NewOrderRequest;
import franklin.paul.ecommerce.model.EcommerceOrder;
import franklin.paul.ecommerce.model.EcommerceUser;

import java.util.UUID;

@Service
public class EcommerceOrderService {
    private final EcommerceOrderDAOInterface orderRepository;

    public EcommerceOrderService(EcommerceOrderDAOInterface orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(NewOrderRequest req, EcommerceUser user) {
        EcommerceOrder order = new EcommerceOrder(UUID.randomUUID().toString(), user, req.getTotalPrice());
        orderRepository.save(order);
    }
}
