package com.example.demo.config;

public class SecurityConstants {
    public static final String JWT_SECRET = "VerySecretKey";

    public static final long EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static final String SWAGGER_UI_ENDPOINT = "/swagger-ui.html";
    public static final String SWAGGER_RESOURCES = "/swagger-resources/**";
    public static final String SWAGGER_API_DOCS = "/v2/api-docs";
    public static final String SWAGGER_JSON = "/swagger.json";
    public static final String SWAGGER_CONFIGURATION_UI = "/configuration/ui";
    public static final String SWAGGER_CONFIGURATION_SECURITY = "/configuration/security";
    public static final String SWAGGER_UI_HTML = "/swagger-ui.html";
    public static final String WEBJARS = "/webjars/**";

    public static final String[] PUBLIC_URLS = {
            "/h2-console/**",
            "/api/users/signup",
            "/api/users/login",
            "/api/auth/signup",
            "/api/auth/login",
            "/api/jugadores",

    };

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
