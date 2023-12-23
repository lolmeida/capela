package com.lolmeida.api.openapi;

import com.lolmeida.api.dto.response.CargoResponse;
import com.lolmeida.api.dto.response.ClientResponse;
import com.lolmeida.api.dto.response.ReceiptResponse;
import com.lolmeida.api.dto.response.RecipientResponse;
import com.lolmeida.api.dto.response.SizeResponse;
import com.lolmeida.api.dto.response.UserResponse;

public final class Values {

    public static final class Schemas {

        public static final String ID = "ID";
        public static final String FIELD = "FIELD";
        public static final String VALUE = "VALUE";
        public static final String CARGO = CargoResponse.class.getSimpleName();
        public static final String CLIENT = ClientResponse.class.getSimpleName();
        private static final String RECEIPT  = ReceiptResponse.class.getSimpleName();
        private static final String RECIPIENT = RecipientResponse.class.getSimpleName();
        private static final String SIZE = SizeResponse.class.getSimpleName();
        private static final String USER = UserResponse.class.getSimpleName();

    }

    public static final class Responses {

        public static final String CARGO = "CargoResponse";
        public static final String CLIENT = "ClientResponse";
        public static final String RECEIPT = "ReceiptResponse";
        public static final String SIZE = "SizeResponse";
        public static final String USER = "UserResponse";

        public static final class Descriptions {

            public static final String LIST = "Get All Records sorted descending by date and ...";
            public static final String ADD = "Add new record to database";
            public static final String SEARCH = "Search records by field and value";
            public static final String FIND = "Find record by ID";
            public static final String CARGO = "Lista de Cargas";

            private Descriptions() {
            }
        }

        public static final class Summary {

            public static final String LIST = "Get All Records";
            public static final String ADD = "Add new record";
            public static final String SEARCH = "Search records";
            public static final String FIND = "Find by ID";

            private Summary() {
            }
        }

        public static final class Error {

            public static final String UNAUTHORIZED = "Unauthorized";
            public static final String FORBIDDEN = "Forbidden";
            public static final String NOT_FOUND = "Not Found";
            public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
            public static final String BAD_GATEWAY = "Bad Gateway";

            private Error() {
            }
        }

        private Responses() {
        }
    }

    public static final class Codes {

        public static final String OK = "200";
        public static final String CREATED = "201";
        public static final String ACCEPTED = "202";
        public static final String NO_CONTENT = "204";

        public static final String UNAUTHORIZED = "401";
        public static final String FORBIDDEN = "403";
        public static final String NOT_FOUND = "404";
        public static final String INTERNAL_SERVER_ERROR = "500";
        public static final String BAD_GATEWAY = "502";

        private Codes() {
            throw new IllegalStateException("Codes is a utility class and should not be instantiated");
        }

    }

    private Values() {
    }

}
