package com.renderbox.renderboxporoject.web;

import com.renderbox.renderboxporoject.service.ThemeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThemeController {

    @Autowired
    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/dashboard/toggle-theme")
    public String toggleTheme(HttpServletRequest request, @RequestParam("themeName") String theme) {
        themeService.toggleTheme(theme);
        // Get the current URL
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}
