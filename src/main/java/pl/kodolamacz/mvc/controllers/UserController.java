package pl.kodolamacz.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kodolamacz.spring.dao.repository.UserDao;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("accounts")
public class UserController {

  @Autowired
  private UserDao userDao;

  @RequestMapping(name = "/", method = GET)
  public String get(Model model) {
    model.addAttribute("users", userDao.findAll());
    return "accounts";
  }
}
