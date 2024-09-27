package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RequestSteps {
    @Given("user wants to call {string} end point")
    public void user_wants_to_call_end_point(String endPoint) {
        if(endPoint.contains("@id")){
            String userId = ConfigReader.getConfigValue("user.id");
            endPoint = endPoint.replace("@id", userId);
        }
        RestAssuredUtils.setEndPoint(endPoint);
        
    }

    @Given("set header type {string} to {string}")
    public void set_header_to(String key, String value) {
        if(value.contains("Bearer")){
            value=ConfigReader.getConfigValue(value);
        }
        RestAssuredUtils.setHeader(key, value);
    }

    @When("user perform get call")
    public void user_perform_get_call() {
        RestAssuredUtils.get();
    }

    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode,RestAssuredUtils.getStatusCode());
    }

    @And("set request body from the file {string}")
    public void setRequestBodyFromTheFile(String fileName) {
        RestAssuredUtils.setBody(fileName);
    }

    @When("user perform post call")
    public void userPerformPostCall() {
        RestAssuredUtils.post();
    }

    @When("user perform put call")
    public void userPerformPutCall() {
        RestAssuredUtils.put();
    }

    @When("user perform delete call")
    public void userPerformDeleteCall() {
        RestAssuredUtils.delete();
    }
}
