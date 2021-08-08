package pl.kornijasz.springboot2security.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kornijasz.springboot2security.AppUser;
import pl.kornijasz.springboot2security.AppUserRepo;

@Controller
public class MainController {

    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;

    public MainController(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/signup")
    public ModelAndView signup() {
        return new ModelAndView("registration", "user", new AppUser());
    }

    @RequestMapping("/register")
    public ModelAndView register(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        appUserRepo.save(user);
        return new ModelAndView("redirect:/login");
    }

}
