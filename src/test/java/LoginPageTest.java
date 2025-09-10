import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static ru.p0keta.stellarBurgers.data.TestData.*;
import static ru.p0keta.stellarBurgers.steps.UserSteps.createUser;

public class LoginPageTest extends BaseTest {

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Test
    public void loginToLoginButton() {
        goPage(URL_PAGE);
        response = createUser(userForCreate);
        mainPage.clickLoginButtonOnMainPage();
        loginPage.setDataAndClickLoginButtonOnLoginPage(EMAIL, PASSWORD);
        assertTrue("Кнопка Оформить Заказ не появилась" ,loginPage.checkIsDisplayedPlaceOrderButton());
    }

    @DisplayName("Вход через кнопку «Личный кабинет")
    @Test
    public void loginToAccountButton() {
        goPage(URL_PAGE);
        response = createUser(userForCreate);
        mainPage.clickPersonalAccountButton();
        loginPage.setDataAndClickLoginButtonOnLoginPage(EMAIL, PASSWORD);
        assertTrue("Кнопка Оформить Заказ не появилась" ,loginPage.checkIsDisplayedPlaceOrderButton());
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Test
    public void loginToBottonFromRegisterPage() {
        goPage(URL_PAGE);
        response = createUser(userForCreate);
        mainPage.clickLoginButtonOnMainPage();
        registerPage.clickRegisterButton();
        registerPage.clickLoginButtonOnRegisterPage();
        loginPage.setDataAndClickLoginButtonOnLoginPage(EMAIL, PASSWORD);
        assertTrue("Кнопка Оформить Заказ не появилась" ,loginPage.checkIsDisplayedPlaceOrderButton());
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Test
    public void logonToButtonFromRecoveryPasswordPage() {
        goPage(URL_PAGE);
        response = createUser(userForCreate);
        mainPage.clickLoginButtonOnMainPage();
        loginPage.clickRecoverButtonOnLoginPage();
        loginPage.clickLoginButtonOnRecoverPage();
        loginPage.setDataAndClickLoginButtonOnLoginPage(EMAIL, PASSWORD);
        assertTrue("Кнопка Оформить Заказ не появилась" ,loginPage.checkIsDisplayedPlaceOrderButton());
    }
}
