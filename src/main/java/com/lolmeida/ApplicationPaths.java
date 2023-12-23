package com.lolmeida;

public final class ApplicationPaths {

    public static final String API_PATH = "/api";
    public static final String API_HELLO_PATH = "/hello";
    public static final class RequestBodies {
        public static final String REQUEST_BODY = "requestBody";

        private RequestBodies() {
        }
    }

    public static final class Parameters {

        public static final String FIELD = "field";
        public static final String VALUE = "value";
        public static final String ID = "id";

        private Parameters() {
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

    private ApplicationPaths() {
    }

}
