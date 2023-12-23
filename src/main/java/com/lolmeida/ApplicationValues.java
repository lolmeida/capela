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

    public static final class Examples {

        public static final String NAME = "John Doe";
        public static final String PHONE_NUMBER = "+351912345678";
        public static final String ADDRESS = "Rua do Ouro, 123";
        public static final String EMAIL = "anthony@gmail.com";
        public static final String ENTITY_ID = "UwG0WGAAcNrY";
        public static final String DOUBLE_VALUES = "23.99";
        public static final String NUMBERS = "123";
        public static final String CARGO_STATUS = "PENDING";
        public static final String ID_LIST = "[UwG0WGAAcNrY, sdZfg3H8fDs2]";


    }

    public static final class Descriptions {

        public static final String NAME = "A valid name";
        public static final String PHONE_NUMBER = "A valid phone number";
        public static final String ADDRESS = "A valid address";
        public static final String EMAIL = "A valid email address";
        public static final String ENTITY_ID = "A valid entity id";
        public static final String DOUBLE_VALUES = "A valid double value";
        public static final String NUMBERS = "A valid number";
        public static final String CARGO_STATUS = "A valid cargo status";
        public static final String ID_LIST = "A valid list of size_ids";


    }

    public static final class Regex {

        public static final String NAME = "^[a-zA-Z][a-zA-Z\\s]{0,20}[a-zA-Z]$";
        public static final String PHONE_NUMBER = "^\\+351\\d{9}$";
        public static final String PHONE_NUMBER_ERROR_MSG = "Invalid phone number. Try something different.";
        public static final String ADDRESS = "  ^(\\d{1,5})([-\\s])?(\\d{1,5})([-\\s])?(\\d{1,5})([-\\s])?(\\d{1,5})$\n";
        public static final String EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        public static final String EMAIL_ERROR_MSG = "Invalid email address. Try something different.";

    }

}
