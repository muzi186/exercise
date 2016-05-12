package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {
	private static final String TEMPLATE = "Greeting to you - <%s>!";
	private static final AtomicLong count = new AtomicLong();

	@CrossOrigin(origins="http://localhost:9000")
	@RequestMapping("/greeting")
	public @ResponseBody Greeting greeting(
			@RequestParam(value = "name", required = false, defaultValue = "CORS") String name) {
		System.out.println("======   greeting()    =======");
		String content = String.format(TEMPLATE, name);
		Greeting greeting = new Greeting(count.incrementAndGet(), content);

		return greeting;
	}
	
	@RequestMapping("/hi")
    public @ResponseBody Greeting hi(@RequestParam(required=false, defaultValue="World") String name) {
        System.out.println("==== in hi ====");
        return new Greeting(count.incrementAndGet(), String.format("Hi, <%s>", name));
    }
}