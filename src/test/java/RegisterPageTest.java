import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static ru.p0keta.stellarBurgers.data.TestData.*;
import static ru.p0keta.stellarBurgers.steps.UserSteps.loginUser;

public class RegisterPageTest extends BaseTest {

    @DisplayName("Успешная регистрация")
    @Test
    public void registerWithValidData() {
        goPage(URL_PAGE);
        mainPage.clickLoginButtonOnMainPage();
        registerPage.clickRegisterButton();
        registerPage.setDataAndClickRegisterButton(NAME, EMAIL, PASSWORD);
        //Проверка, что пользователь действительно создан
        response = loginUser(userForLogin);
        response.then()
                .log().all()
                .statusCode(HTTP_OK)
                .assertThat().body("success", equalTo(true))
                .assertThat().body("user.email", equalTo(EMAIL))
                .assertThat().body("user.name", equalTo(NAME))
                .assertThat().body("accessToken", allOf(not(emptyString()), not(nullValue())))
                .assertThat().body("refreshToken", allOf(not(emptyString()), not(nullValue())));
    }

    @DisplayName("Ошибка для некорректного пароля")
    @Description("Минимальный пароль — шесть символов. Ввод 5-ти символов")
    @Test
    public void registerWithInvalidPassword() {
        goPage(URL_PAGE);
        mainPage.clickLoginButtonOnMainPage();
        registerPage.clickRegisterButton();
        registerPage.setDataAndClickRegisterButton(NAME, EMAIL, "12345");
        assertTrue("Сообщение об ошибке не появилось", registerPage.errorIsDisplayed());
    }

}
