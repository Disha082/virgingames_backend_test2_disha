package com.virgingames.gamesinfo;

import com.virgingames.constants.EndPoints;
import com.virgingames.constants.Path;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class BingoSteps {

    @Step("Getting all the Data from bingo")
    public ValidatableResponse getBingoLobbyFeed() {
        return SerenityRest.given().log().all()
                .basePath(Path.BINGO)
                .when()
                .get(EndPoints.GET_ALL_Data)
                .then()
                .statusCode(200);

    }


}
