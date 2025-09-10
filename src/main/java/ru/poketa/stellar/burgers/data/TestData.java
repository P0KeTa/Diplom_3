package ru.poketa.stellar.burgers.data;

import net.datafaker.Faker;

public class TestData {
    public static final String URL_PAGE = "https://stellarburgers.nomoreparties.site/";

    //Данные пользователя
    static Faker faker = new Faker();
    public static final String EMAIL = faker.internet().emailAddress();
    public static final String PASSWORD = faker.internet().password();
    public static final String NAME = faker.name().firstName();

    //Данные запросов
    public static final String PATH_USER_REGISTER = "/api/auth/register";
    public static final String PATH_USER_DELETE = "/api/auth/user";
    public static final String PATH_USER_LOGIN = "/api/auth/login";

}
