package franklin.paul.ecommerce.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@CrossOrigin
@RestController
@RequestMapping("/ecommerce")
public class EcommerceController {
	public EcommerceController() {
		
	}

	@GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String firstMethod() {
		return "first method";
    }
}
