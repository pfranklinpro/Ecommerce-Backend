package franklin.paul.ecommerce.service;

import org.springframework.stereotype.Service;
import franklin.paul.ecommerce.dao.EcommerceProductDAOInterface;
import franklin.paul.ecommerce.model.EcommerceProduct;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class EcommerceProductService {
    private final EcommerceProductDAOInterface productRepository;

    public EcommerceProductService(EcommerceProductDAOInterface productRepository) {
        this.productRepository = productRepository;
    }

    public ArrayList<EcommerceProduct> findAllProducts() {
        ArrayList<EcommerceProduct> products = productRepository.findAll();
        if (products.size() == 0) {
            products.add(new EcommerceProduct("4d100ac4-cf71-411c-95dc-1edbd64541ba", "First Product", "First Product Description", 1.00));
            products.add(new EcommerceProduct("321b8676-d546-4a5b-bd4f-684bdba39803", "Second Product", "Second Product Description", 1.01));
        }
        return products;
    }
}
