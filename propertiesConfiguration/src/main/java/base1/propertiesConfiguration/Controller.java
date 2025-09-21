package base1.propertiesConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/")
	public String index() {
		return "alex";
	}

	@Value("${information.name}")
	public String ten;
	@Value("${information.age}")
	public String tuoi;

	@GetMapping("/info")
	public String info() {
		return ten + " " + tuoi;
	}

}
