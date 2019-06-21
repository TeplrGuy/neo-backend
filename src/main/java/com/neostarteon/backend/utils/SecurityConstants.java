package com.neostarteon.backend.utils;

public class SecurityConstants {
    public static final String SECRET = "93~kD?_R:Tz0R!A2m_b~kRIYVhBiZUd,&W9F2)Jt/~'" +
            "|r9WfW35k*UU2\\A*Pvdw\n3CC514F22FCECF80391D2B51A620E12B23" +
            "866F6DFB58AF416837C8ECDB349A87";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/signUp";
    public static final String H2_CONSOLE_URL = "/h2-console/**";
    public static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };
}