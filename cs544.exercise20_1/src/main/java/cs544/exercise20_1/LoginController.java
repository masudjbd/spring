package cs544.exercise20_1;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class LoginController {
 
	@RequestMapping(value="/masudLogin", method = RequestMethod.GET)
	public String customLogin(ModelMap map) {
 		return "login";
 	}
	@RequestMapping(value="/loginFailed", method = RequestMethod.GET)
	public String customLoginFailed(ModelMap map) {
 		return "login";
 	}
	@RequestMapping(value="/loginSuccess", method = RequestMethod.GET)
	public String success(ModelMap map) {
		map.addAttribute("msg", "Successfully logged in");
		return "success";
 
	}
	
	 
}