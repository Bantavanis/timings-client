package com.kevingann.facade;

import com.kevingann.beans.home.HealthStatus;
import com.kevingann.util.ConfigUtil;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class TimingsFacade {

    private static final Logger LOG = LoggerFactory.getLogger(TimingsFacade.class);

    private static final String HEALTH_PATH = "/home";
    private static final String PATH = "/v2/api/cicd/";

    public TimingsFacade() {
        RestAssured.defaultParser = Parser.JSON;
    }

    public HealthStatus getHealth() {
        // @formatter:off

        return given().
                spec(getRequestSpecification()).
                response().
                statusCode(200).
                when().
                get(ConfigUtil.getUri(HEALTH_PATH)).
                andReturn().
                as(HealthStatus.class);

        // @formatter:on
    }

    private RequestSpecification getRequestSpecification() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addFilter(new ErrorLoggingFilter());
        return requestSpecBuilder.build();
    }
}
