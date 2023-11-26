package com.renderbox.renderboxporoject.utils;

import jakarta.servlet.http.HttpServletRequest;

public class Utility {

    public static String getAppUrl(HttpServletRequest request) {
        String siteUrl = request.getRequestURL().toString();
        return siteUrl.replace(request.getServletPath(), "");
    }
}
