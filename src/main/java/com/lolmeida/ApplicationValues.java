package com.lolmeida;

public class ApplicationValues {

    public static final String API_DESCRIPTION = "NC Cargo API";
    public static final String API_TITLE = "NC Cargas";
    public static final String API_VERSION = "1.0.0";
    public static final String API_CONTACT_NAME = "Lourenço Almeida";
    public static final String API_CONTACT_EMAIL = "lolmeida@gmail.com";
    public static final String API_CONTACT_URL = "lolmeida.com";
    public static final String API_NAME = "Api";


    public static final class Repositories {

        public static final class Queries {

            public static final String QUERY = "LOWER( %s ) like ?1";
            public static final String QUERY_INPUT = "%%%s%%";
            public static final String FIND_BY_CLIENT_ID = "Client like ?1";
            public static final String FIND_BY_ID = "id like ?1";
        }
    }

    public static final class Resources {

        public static final String NOT_FOUND_ERROR = "No data found";


    }

}
