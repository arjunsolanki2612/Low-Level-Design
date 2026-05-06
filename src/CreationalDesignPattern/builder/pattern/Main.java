package CreationalDesignPattern.builder.pattern;

public class Main {
    public static void main(String[] args) {
        HTTPRequest request = new HTTPRequest.Builder()
                .withUrl("/users")
                .withMethod("POST")
                .withHeader("Authorization", "Bearer xyz123")
                .withHeader("Content-Type", "application/json")
                .withBody("{\"name\":\"Arjun\"}")
                .withTimeout(5000)
                .withEnableCaching()
                .build();

        request.printRequest();
    }
}
