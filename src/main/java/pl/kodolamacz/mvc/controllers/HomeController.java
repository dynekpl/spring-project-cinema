package pl.kodolamacz.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

  @RequestMapping(name = "/", method = GET)
  public String get(Model model) {
    return "home";
  }
}
