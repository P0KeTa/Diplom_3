package ru.poketa.stellar.burgers.steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.poketa.stellar.burgers.models.User;

import static io.restassured.RestAssured.given;
import static ru.poketa.stellar.burgers.data.TestData.*;

public class UserSteps {

    @Step ("Создание пользователя")
    public static Response createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(user)
                .post(PATH_USER_REGISTER)
                .then()
                .extract().response();
    }

    @Step("Авторизация пользователя")
    public static Response loginUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(PATH_USER_LOGIN)
                .then()
                .extract().response();
    }

    @Step ("Удаление пользователя")
    public static void deleteUser(String authHeader) {
        given()
                .header("Authorization", authHeader)
                .when()
                .delete(PATH_USER_DELETE)
                .then()
                .extract().response();
    }

}
