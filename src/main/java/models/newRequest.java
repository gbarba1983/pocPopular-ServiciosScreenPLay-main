package models;

import models.body.AuthorizationBody;

public class newRequest {

    String url;
    AuthorizationBody authorizationBody;
    String code;

    public newRequest(String url, AuthorizationBody authorizationBody, String code) {
        this.url = url;
        this.authorizationBody = authorizationBody;
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AuthorizationBody getAuthorizationBody() {
        return authorizationBody;
    }

    public void setAuthorizationBody(AuthorizationBody authorizationBody) {
        this.authorizationBody = authorizationBody;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
