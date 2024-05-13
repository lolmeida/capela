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
                public static final String AGENT ="tAgente";
                public static final String ANNOUNCEMENT ="tAnuncios";
                public static final String CARGO ="tCargos";
                public static final String CLIENT ="tClientes";
                public static final String APP ="tApps";
                public static final String USER ="tUtilizadores";
                public static final String LIST ="tListas";
                public static final String POSTAL_CODE ="tCodigoPostal";
                public static final String RECEIPT ="tRecebimentos";
                public static final String CONFIGURATION ="tConfiguracoes";
                public static final String SIZE ="tDimensoes";
                public static final String STATUS ="tStatus";
                public static final String WAREHOUSE ="tArmazem";
            }
    }

    public static final class Query {

        public static final String FIND_BY_ID = "id like ?1";
        public static final String SEARCH = "LOWER( %s ) like ?1";
        public static final String SEARCH_INPUT = "%%%s%%";
    }

}
