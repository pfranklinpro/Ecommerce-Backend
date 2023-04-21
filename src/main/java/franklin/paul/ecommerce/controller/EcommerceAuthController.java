package franklin.paul.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import franklin.paul.ecommerce.dtos.requests.NewLoginRequest;
import franklin.paul.ecommerce.dtos.responses.Principal;
import franklin.paul.ecommerce.model.EcommerceUser;
import franklin.paul.ecommerce.service.EcommerceTokenService;
import franklin.paul.ecommerce.service.EcommerceUserService;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class EcommerceAuthController {
    private final EcommerceUserService userService;
    private final EcommerceTokenService tokenService;

    public EcommerceAuthController(EcommerceUserService userService, EcommerceTokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Principal login(@RequestBody NewLoginRequest req) {
        if (req.getUsername() == null || req.getPassword() == null) {
            throw new RuntimeException("Missing username or password");
        }

        EcommerceUser user = null;
        try {
            user = userService.findUser(req.getUsername());

            if (!req.getPassword().equals(user.getPassword())) {
                System.out.println(req.getPassword());
                System.out.println(user.getPassword());
                throw new Exception("Wrong password");
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }

        Principal principal = new Principal(user.getUserId(), user.getUsername(), user.getCountry());
        String token = tokenService.createNewToken(principal);

        return principal;
    }
}
