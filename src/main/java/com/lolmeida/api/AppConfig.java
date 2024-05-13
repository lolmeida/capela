package com.lolmeida.api;

public final class AppConfig {

    public static final String ROOT = "/";
    public static final String SEARCH = "/search/{field}/{value}";
    public static final String FIND_BY = "/{id}";

    public static final class MediaTypeExtension {

        public static final String JSON = "application/json";
        public static final String XML = "application/xml";
        public static final String TAR = "application/x-tar";
        public static final String ZIP = "application/zip";
        public static final String PNG = "image/png";
        public static final String JPEG = "image/jpeg";
        public static final String GIF = "image/gif";
        public static final String SVG = "image/svg+xml";
        public static final String PDF = "application/pdf";
        public static final String DOC = "application/msword";
    }

    public static final class Schema {

        public static final String DB = "sql7509759";

        public static final class Table {

            public static final class Agent {

                public static final String TABLE = "tAgente";
                public static final String Name = "Nome";
                public static final String Email = "Email";
                public static final String Contact = "Contacto";
            }

            public static final class Announce {

                public static final String TABLE = "tAnuncios";
            }

            public static final class Cargo {

                public static final String TABLE = "tCargos";
                public static final String OrderByColumns = "date, cargoNumber";
                public static final String SearchId = "cargoNumber";
            }

            public static final class Client {

                public static final String TABLE = "tClientes";
            }

            public static final class App {

                public static final String TABLE = "tApps";
            }

            public static final class User {

                public static final String TABLE = "tUtilizadores";
            }

            public static final class List {

                String TABLE = "tListas";
            }

            public static final class PostalCode {

                String TABLE = "tCodigoPostal";
            }

            public static final class Receipt {

                String TABLE = "tRecebimentos";
            }

            public static final class Configuration {

                String TABLE = "tConfiguracoes";
            }

            public static final class Size {

                String TABLE = "tDimensoes";
            }

            public static final class Status {

                String TABLE = "tStatus";
            }

            public static final class Warehouse {

                String TABLE = "tArmazem";
            }
        }


    }

    public static final class Query {

        public static final String FIND_BY_ID = "id like ?1";
        public static final String SEARCH = "LOWER( %s ) like ?1";
        public static final String SEARCH_INPUT = "%%%s%%";
    }

}
