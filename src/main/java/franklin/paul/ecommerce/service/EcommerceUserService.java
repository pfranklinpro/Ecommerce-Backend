package franklin.paul.ecommerce.service;

import org.springframework.stereotype.Service;

import franklin.paul.ecommerce.dao.EcommerceUserDAOInterface;
import franklin.paul.ecommerce.dtos.requests.NewLoginRequest;
import franklin.paul.ecommerce.dtos.requests.NewUserRequest;
import franklin.paul.ecommerce.model.EcommerceUser;

import java.util.Optional;
import java.util.UUID;

@Service
public class EcommerceUserService {
    private final EcommerceUserDAOInterface userRepository;

    public EcommerceUserService(EcommerceUserDAOInterface userRepository) {
        this.userRepository = userRepository;
    }

    public void newUser(NewUserRequest req) {
        EcommerceUser user = new EcommerceUser(UUID.randomUUID().toString(), req.getUsername(), req.getPassword(), req.getCountry());
        try {
            userRepository.save(user);
        } catch (Exception exception) {
            throw new RuntimeException("Database issue");
        }
    }

    public EcommerceUser findUser(String username) {
        return this.userRepository.findByUsername(username);
    }
}
