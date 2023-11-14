package com.renderbox.renderboxporoject.web.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboardController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("activePage", "Dashboard");
        return "/home";
    }
}
