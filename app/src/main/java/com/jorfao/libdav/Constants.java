package com.jorfao.libdav;


public final class Constants {

    //Methods
    public final class Methods{
        public static final String PROPFIND = "PROPFIND";
        public static final String PROPPATCH = "PROPPATCH";
        public static final String MKCOL = "MKCOL";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String POST = "POST";
        public static final String DELETE = "DELETE";
        public static final String PUT = "PUT";
        public static final String COPY = "COPY";
        public static final String MOVE = "MOVE";
        public static final String LOCK = "LOCK";
        public static final String UNLOCK = "UNLOCK";
    }

    //Headers
    public final class Headers{
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String CONTENT_TYPE_XML = CONTENT_TYPE + ": text/xml";
        public static final String DEPTH = "Depth";
        public static final String DESTINATION = "Destination";
    }

    //Defaults
    public final class Default{
        public static final String PROPFIND_DEFAUT_BODY =
                "<d:propfind xmlns:d=\"DAV:\">\n" +
                "    <d:prop>\n" +
                "        <d:displayname/>\n" +
                "        <d:creationdate/>\n" +
                "        <d:getcontentlength/>\n" +
                "        <d:getcontenttype/>\n" +
                "        <d:getetag/>\n" +
                "        <d:getlastmodified/>\n" +
                "        <d:resourcetype/>\n" +
                "        <d:supportedlock/>\n" +
                "        <d:lockdiscovery/>\n" +
                "        <d:checked-in/>\n" +
                "        <d:checked-out/>\n" +
                "        <d:version-name/>\n" +
                "    </d:prop>\n" +
                "</d:propfind>";
        public static final String NAMESPACE = "d";
    }

    //Depth
    public final class Depth {
        public static final String ZERO = "0";
        public static final String ONE = "1";
        public static final String ONE_NOROOT = "1,noroot";
        public static final String INFINITY = "infinity";
        public static final String NOROOT = "noroot";
        public static final String INFINITY_NOROOT = "infinity|noroot";
    }

}
