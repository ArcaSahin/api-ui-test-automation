package api.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;
import java.util.Objects;

import static org.bouncycastle.cms.RecipientId.password;

public class BaseApiService {

    protected final String API_KEY = "dce0bcc9";

    public ValidatableResponse crud(String operation, Map<String, Object> queryParams, Map<String, Object> body, String endPoint) {

        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.setContentType(ContentType.JSON)
                .setBaseUri("https://www.omdbapi.com");

        if (!Objects.isNull(queryParams)) {
            for (Map.Entry<String, Object> eachQueryParam : queryParams.entrySet()) {
                builder.addQueryParam(eachQueryParam.getKey(), eachQueryParam.getValue());
            }
        }

        if (!Objects.isNull(body)) {
            builder.setBody(body);
        }

        RequestSpecification request = RestAssured.given().spec(builder.build());

        return switch (operation.toLowerCase()) {
            case "get" -> request.get(endPoint).then();
            case "post" -> request.post(endPoint).then();
            case "put" -> request.put(endPoint).then();
            case "delete" -> request.delete(endPoint).then();
            default -> throw new RuntimeException("Please check your operation. It comes as: " + operation + "!");
        };
    }
}

