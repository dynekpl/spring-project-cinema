package pl.kodolamacz.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kodolamacz.mvc.controllers.forms.AddUserForm;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("accounts")
public class UserController {

  public static final String BASE_URL = "accounts";

  @Autowired
  private UserDao userDao;

  @RequestMapping(name = "/", method = GET)
  public String get(Model model) {
    model.addAttribute("users", userDao.findAll());
    return BASE_URL;
  }

  @RequestMapping(value = "/add", method = GET)
  public String addNewUser(Model model) {
    model.addAttribute("userForm", new AddUserForm());
    return "addNewUser";
  }

  @RequestMapping(value = "/save", method = POST)
  public String saveNewUser(AddUserForm userForm) {
    userDao.save(new User(userForm.getEmail(), userForm.getPassword()));
    return "redirect:/" + BASE_URL;
  }
}
