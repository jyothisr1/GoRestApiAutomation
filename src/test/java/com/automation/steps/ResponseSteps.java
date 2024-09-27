package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class ResponseSteps {
    @And("verify user id is not empty")
    public void verifyBookingIdIsNotEmpty() {
        String userId=RestAssuredUtils.getResponse().jsonPath().getString("id");
        Assert.assertFalse(userId.isEmpty());
    }

    @And("user stores created user id into {string};")
    public void userStoresCreatedBookingIdInto(String key) {
        ConfigReader.setConfig(key,RestAssuredUtils.getResponse().jsonPath().getString("id"));
    }
}
