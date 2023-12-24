package com.lolmeida;

import com.lolmeida.api.dto.response.CargoResponse;
import com.lolmeida.api.dto.response.ClientResponse;
import com.lolmeida.api.dto.response.ReceiptResponse;
import com.lolmeida.api.dto.response.RecipientResponse;
import com.lolmeida.api.dto.response.SizeResponse;
import com.lolmeida.api.dto.response.UserResponse;

public final class ApplicationPaths {

    public static final String API_CLIENT = "/client";
    public static final String API_CARGO = "/cargo";
    public static final String API_RECIPIENT = "/recipient";
    public static final String API_RECEIPT = "/receipt";
    public static final String API_SIZE = "/size";
    public static final String API_USER = "/user";

    public static final String API_HELLO = "/hello";
    public static final String API_LOGIN = "/login";
    public static final String API_ROOT = "/";
    public static final String API_HELLO_PATH = "/hello";
    public static final String API_PATH = "/api";
    public static final String API_ID = "/{id}";
    public static final String API_SEARCH = "/search/{field}/{value}";
    public static final String API_KAFKA = "/kafka";
    public static final String API_NOTIFICATION = "/sms";
    public static final String API_SLACK = "/slack";
    public static final String API_TWILIO = "/twilio";

    private ApplicationPaths() {
    }

    public static final class Values {
        private Values() {
        }

        public static final class Schemas {

            public static final String ID = "ID";
            public static final String FIELD = "FIELD";
            public static final String VALUE = "VALUE";
            public static final String CARGO = CargoResponse.class.getSimpleName();
            public static final String CLIENT = ClientResponse.class.getSimpleName();
            private static final String RECEIPT = ReceiptResponse.class.getSimpleName();
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
        }



    }

    public static final class RequestBodies {

        public static final String REQUEST_BODY = "requestBody";
        public static final String CLIENT = "Client";
        public static final String RECEIPT = "Receipt";
        public static final String RECIPTENT = "Recipient";
        public static final String SIZE = "Size";
        public static final String USER = "User";

        private RequestBodies() {
        }
    }

    public static final class Parameters {

        private Parameters() {
        }

        public static final class Refs {

            public static final String FIELD = "field";
            public static final String VALUE = "value";
            public static final String ID = "id";
        }

        public static final class Descriptions {

            public static final String FIELD = "Field to search";
            public static final String VALUE = "Value to search";
            public static final String ID = "Record ID";
        }
    }

    public static final class Headers {

        public static final String FIELD = "field";
        public static final String VALUE = "value";
        public static final String ID = "id";

        private Headers() {
        }
    }

    public static final class MediaTypeExtension {

        public static final String TAR = "application/x-tar";
        public static final String PNG = "image/png";
        public static final String JPEG = "image/jpeg";
        public static final String GIF = "image/gif";
        public static final String MP4 = "video/mp4";
        public static final String MP3 = "audio/mp3";
        public static final String ZIP = "application/zip";
    }

}
