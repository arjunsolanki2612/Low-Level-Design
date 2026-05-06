package CreationalDesignPattern.builder.pattern;

import java.util.HashMap;
import java.util.Map;

public class HTTPRequest {
    // Final fields → immutable object
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;
    private final boolean cachingEnabled;

    //Private constructor so object can not be instantiated

    private HTTPRequest(Builder builder){
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
        this.timeout = builder.timeout;
        this.cachingEnabled = builder.cachingEnabled;
    }

    // Display request info
    public void printRequest() {

        System.out.println("======= HTTP REQUEST =======");

        System.out.println("URL: " + url);
        System.out.println("Method: " + method);
        System.out.println("Headers: " + headers);
        System.out.println("Body: " + body);
        System.out.println("Timeout: " + timeout);
        System.out.println("Caching Enabled: " + cachingEnabled);
    }

    public static class Builder{
        // Mandatory fields
        private String url;
        private String method;

        // Optional fields
        private Map<String, String> headers = new HashMap<>();
        private String body;
        private int timeout = 3000; // default timeout
        private boolean cachingEnabled = false;

        //  Mandatory fields
        public Builder withUrl(String url){
            this.url = url;
            return this;
        }

        public Builder withMethod(String method){
            this.method = method;
            return this;
        }

        // Optional configurations
        public Builder withHeader(String key, String value) {
            headers.put(key, value);
            return this;
        }

        public Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public Builder withTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder withEnableCaching() {
            this.cachingEnabled = true;
            return this;
        }

        public HTTPRequest build(){
            // Validation
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("URL cannot be empty");
            }

            if (method == null || method.isEmpty()) {
                throw new IllegalArgumentException("HTTP Method required");
            }

            return new HTTPRequest(this);
        }
    }

}
