package com.lolmeida.api.openapi;

public final class Values {

    public static final String API_VERSION = "1.0.0";
    public static final String API_TITLE = "API";
    public static final String API_DESCRIPTION = "API";
    public static final String API_TERMS_OF_SERVICE = "https://www.example.com/terms";
    public static final String API_CONTACT_NAME = "API Support";
    public static final String API_CONTACT_EMAIL = "lolmeida@gmail.com";

    public static final String SECURITY_SCHEME = "bearer";

    private Values() {
        throw new IllegalStateException("Utility class");
    }

    public static final class Paths {
        public static final String POSTAL_CODE = "/postal-code";
        public static final String AGENT = "/agent";
        public static final String AGENT_NEW = "/agent-new";
        public static final String CARGO = "/cargo";
        public static final String CONFIG = "/config";
        public static final String ANNOUNCE = "/announce";
        public static final String APP = "/app";
        public static final String WAREHOUSE = "/warehouse";
        public static final String CUSTOMER = "/customer";
        public static final String USER = "/user";
        public static final String GREETING = "/greeting";
        public static final String LIST = "/list";
        public static final String RECEIPT = "/receipt";
        public static final String SIZE = "/size";
        public static final String STATUS = "/status";

        public static final String SWAGGER = "/q/swagger-ui";
        public static final String HEALTH = "/health";
        public static final String AUTH = "/auth";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";


        private Paths() {
            throw new IllegalStateException("Utility class");
        }
    }

    public static final class Codes {
        public static final String OK = "200";
        public static final String CREATED = "201";
        public static final String NO_CONTENT = "204";
        public static final String BAD_REQUEST = "400";
        public static final String UNAUTHORIZED = "401";
        public static final String FORBIDDEN = "403";
        public static final String NOT_FOUND = "404";
        public static final String CONFLICT = "409";
        public static final String UNPROCESSABLE_ENTITY = "422";
        public static final String INTERNAL_SERVER_ERROR = "500";
        public static final String BAD_GATEWAY_ERROR = "502";
        public static final String SERVICE_UNAVAILABLE = "503";

        private Codes() {
            throw new IllegalStateException("Utility class");
        }
    }
}
