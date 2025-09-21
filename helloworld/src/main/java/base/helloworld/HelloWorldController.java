package base.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/")
	public String print() {
		return "hello world";
	}

	@GetMapping("/h2")
	public String in() {
		return "xin chao";
	}
}
