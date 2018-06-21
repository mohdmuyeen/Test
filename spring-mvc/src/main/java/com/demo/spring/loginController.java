package com.demo.spring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.usertype.UserCollectionType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.entity.User;

@Controller
public class loginController {

	@PersistenceContext
	EntityManager em;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView processLogin(@RequestParam("username") String un, @RequestParam("password") String pw) {
		ModelAndView mv = new ModelAndView();
		User user = em.find(User.class, un);

		if (user != null) {
			if (user.getPassword().equals(pw)) {
				mv.setViewName("success");
				mv.addObject("user", un);
			} else {
				mv.setViewName("failure");
			}

		} else {
			mv.setViewName("login");
		}

		return mv;
	}
}
