package com.renderbox.renderboxporoject.web.dashboard;

import com.renderbox.renderboxporoject.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboardController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("activePage", "Dashboard");
        model.addAttribute("theme", themeService.getCurrentTheme());
        return "/home";
    }
}
