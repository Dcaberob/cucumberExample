package api.client;
public class ResponseApi {
    private String responseBody;
    private String responseMessage;
    private int responseCode;

    public ResponseApi(){}

    public ResponseApi(String responseBody, int responseCode){
        this.responseBody=responseBody;
        this.responseCode=responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
