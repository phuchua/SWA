package service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/publicinfo")
	public String getPublicInfo() {
		return "This is public info";
	}
	
	@GetMapping("/userinfo")
	public String getUserInfo() {
		return "This info is for users";
	}

	@GetMapping("/managerinfo")
	public String getManagerInfo() {
		return "This info is for managers";
	}
}
