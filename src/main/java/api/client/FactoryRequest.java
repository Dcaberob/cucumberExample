package api.client;

public class FactoryRequest {
    public static ApiClient make(String method) {
        return switch (method.toUpperCase()) {
            case "GET" -> new GetRequest();
            case "POST" -> new PostRequest();
            case "PUT" -> new PutRequest();
            case "DELETE" -> new DeleteRequest();
            default -> throw new IllegalArgumentException("Invalid method");
        };
    }
}