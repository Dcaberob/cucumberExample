package api.client;

public class FactoryRequest {
    public static ApiClient make(String type) {
        switch (type.toLowerCase()) {
            case "put":
                return new PutRequest();
            case "post":
                return new PostRequest();
            case "delete":
                return new DeleteRequest();
            default:
                return new GetRequest();
        }
    }
}