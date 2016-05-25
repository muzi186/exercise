package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by gavin on 16-5-25.
 */
@Controller
@RequestMapping("/gs-web")
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = false, defaultValue="World") String name,
                           Model model){
        model.addAttribute("name", "gs-web-"+name);
        return "greeting";
    }
}