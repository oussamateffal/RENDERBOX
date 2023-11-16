package com.renderbox.renderboxporoject.service;

import org.springframework.stereotype.Service;

@Service
public class ThemeService {
    private String currentTheme = "dark";

    public String getCurrentTheme() {
        return currentTheme;
    }

    public void toggleTheme(String theme) {
        if(theme.equals("light")) {
            currentTheme = "light";
        } else if (theme.equals("dark")) {
            currentTheme = "dark";
        }
    }
}
