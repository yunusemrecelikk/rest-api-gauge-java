package org.example.implementations;

import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.config.GlobalConfig;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class StepImp {

    private final String url = "https://gorest.co.in/public/v2/";
    private Response response;
    private RequestSpecification requestSpecification;
    private JSONObject jsonObject;
    private GlobalConfig config;

    public StepImp() {
        config = new GlobalConfig();
    }

    private void createBody() {
        requestSpecification.body(jsonObject.toJSONString());
    }

    @Step("Create Json")
    public void createJson() {
        jsonObject = new JSONObject();
    }

    @Step("Add to json <key> : <value>")
    public void addToJson(String key, String value) {
        jsonObject.put(key, value);
    }

    @Step("Send <method> request to <path>")
    public void sendRequest(String method, String path) {
        RestAssured.baseURI = url + path;
        requestSpecification = given();
        requestSpecification.header(config.getAuth(), config.getToken());
        requestSpecification.header(config.getContentType(), config.getContentValue());
        requestSpecification.header(config.getAccept(), config.getAcceptValue());
        switch (method) {
            case "GET":
                response = requestSpecification.get();
                break;
            case "PUT":
                createBody();
                response = requestSpecification.put();
                break;
            case "POST":
                createBody();
                response = requestSpecification.post();
                break;
            case "DELETE":
                response = requestSpecification.delete();
                break;
            default:
                Assertions.fail("Given method is not acceptable");
                return;
        }
    }

    @Step("Check is response status <code>")
    public void checkStatusCode(String code) {
        int statusCode = response.getStatusCode();
        Assertions.assertTrue(statusCode == Integer.valueOf(code),
                "Status code is not " + code + ". Actual status code is " + statusCode);
    }

    @Step("Print out body")
    public void printOutBody() {
        System.out.println(response.getBody().asPrettyString());
    }

    @Step("Clear json")
    public void clearJsonData() {
        jsonObject.clear();
    }


}
