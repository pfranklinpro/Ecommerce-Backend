package franklin.paul.ecommerce.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import franklin.paul.ecommerce.dtos.requests.NewUserRequest;
import franklin.paul.ecommerce.dtos.responses.Principal;
import franklin.paul.ecommerce.model.EcommerceUser;
import franklin.paul.ecommerce.service.EcommerceTokenService;
import franklin.paul.ecommerce.service.EcommerceUserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class EcommerceUserController {
    private final EcommerceTokenService tokenService;
    private final EcommerceUserService userService;

    public EcommerceUserController(EcommerceTokenService tokenService, EcommerceUserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Principal newUser(@RequestBody NewUserRequest req) {
        if (req.getUsername() == null || req.getPassword() == null || req.getCountry() == null) {
            throw new RuntimeException("Missing username or password or country");
        }

        try {
            userService.newUser(req);
        } catch (Exception exception) {
        	throw new RuntimeException(exception.getMessage());
        }

        EcommerceUser user = userService.findUser(req.getUsername());
        Principal principal = new Principal(user.getUserId(), user.getUsername(), user.getCountry());
        tokenService.createNewToken(principal);

        return principal;
    }
}
