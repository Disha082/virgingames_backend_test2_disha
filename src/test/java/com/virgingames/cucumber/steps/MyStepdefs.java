package com.virgingames.cucumber.steps;

import com.virgingames.gamesinfo.BingoSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class MyStepdefs {
    static ValidatableResponse response;
    String streamName;
    @Steps
    BingoSteps bingoSteps;

    @When("^I send Get request to the Lobby feed endpoint$")
    public void iSendGetRequestToTheLobbyFeedEndpoint() {
        response = bingoSteps.getBingoLobbyFeed();
        streamName = response.extract().jsonPath().get("bingoLobbyInfoResource.streams[0].streamName");
    }

    @And("^I get Valid Status code \"([^\"]*)\"$")
    public void iGetValidStatusCode(int code) {
        response.statusCode(code);
    }


    @Then("^I verify streamName is Adventure$")
    public void iVerifyStreamNameIsAdventure() {
        String  name = "Adventure";
        Assert.assertEquals("streamName not found", name, streamName);

    }
}
