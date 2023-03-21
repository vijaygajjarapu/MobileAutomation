package com.iehp.commonStepDefinitios;

import com.iehp.utilities.BaseElementMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ApiSteps {

    @Given("Post upload app to browser stack")
    public void post_upload_app_to_browser_stack() {
        BaseElementMethods.getResponseBody();
    }
    @Then("Get Validate the response")
    public void get_validate_the_response() {
        BaseElementMethods.getResponseStatus();
    }
}
