package api.config;

import io.restassured.RestAssured;

public class BaseApiConfig {
    private final ApiConfig apiConfig;
    public BaseApiConfig(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    public void setConfig() {
        RestAssured.baseURI = apiConfig.baseUri();
    }
}