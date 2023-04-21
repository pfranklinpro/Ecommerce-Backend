package franklin.paul.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import franklin.paul.ecommerce.dtos.requests.NewOrderRequest;
import franklin.paul.ecommerce.dtos.responses.Principal;
import franklin.paul.ecommerce.model.EcommerceUser;
import franklin.paul.ecommerce.service.EcommerceOrderService;
import franklin.paul.ecommerce.service.EcommerceTokenService;
import franklin.paul.ecommerce.service.EcommerceUserService;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class EcommerceOrderController {
    private final EcommerceTokenService tokenService;
    private final EcommerceUserService userService;
    private final EcommerceOrderService orderService;

    public EcommerceOrderController(EcommerceTokenService tokenService, EcommerceUserService userService, EcommerceOrderService orderService) {
        this.tokenService = tokenService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody NewOrderRequest req, HttpServletRequest servletReq) {
        String token = servletReq.getHeader("authorization");
        if (token == null || token.isEmpty()) throw new RuntimeException("Missing token");

        if (req.getTotalPrice() == null) {
            throw new RuntimeException("Missing total price");
        }

        Principal principal = tokenService.retrievePrincipalFromToken(token);
        EcommerceUser user = userService.findUser(principal.getUsername());

        orderService.createOrder(req, user);
    }
}
