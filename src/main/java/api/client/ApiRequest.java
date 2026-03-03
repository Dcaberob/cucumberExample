package api.client;

import api.config.Configuration;

import java.util.Map;

public abstract class ApiRequest {

    protected String url;
    protected Map<String, String> params;
    protected String body;

    public String getUrl() {
        url = Configuration.HOST;
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}