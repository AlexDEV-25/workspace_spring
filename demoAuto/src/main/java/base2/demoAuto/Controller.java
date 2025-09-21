package base2.demoAuto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/")
	public String index() {
		return "hello hoang duc";
	}

	@GetMapping("/h2")
	public String index2() {
		return "da vao h2";
	}

}
