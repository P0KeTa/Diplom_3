import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static ru.poketa.stellar.burgers.data.TestData.*;

public class LoginPageTest extends BaseTest {

    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной»")
    @Description("Авторизация через кнопку «Войти в аккаунт»")
    @Test
    public void loginToLoginButtonTest() {
        goPage(URL_PAGE);
        mainPage.clickLoginButtonOnMainPage();
        loginPage.setDataAndClickLoginButtonOnLoginPage(EMAIL, PASSWORD);
        assertTrue("Кнопка Оформить Заказ не появилась" ,loginPage.checkIsDisplayedPlaceOrderButton());
    }

    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Авторизация через кнопку «Личный кабинет»")
    @Test
    public void loginToAccountButtonTest() {
        goPage(URL_PAGE);
        mainPage.clickPersonalAccountButton();
        loginPage.setDataAndClickLoginButtonOnLoginPage(EMAIL, PASSWORD);
        assertTrue("Кнопка Оформить Заказ не появилась" ,loginPage.checkIsDisplayedPlaceOrderButton());
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Авторизация через форму регистрации")
    @Test
    public void loginToBottonFromRegisterPageTest() {
        goPage(URL_PAGE);
        mainPage.clickLoginButtonOnMainPage();
        registerPage.clickRegisterButton();
        registerPage.clickLoginButtonOnRegisterPage();
        loginPage.setDataAndClickLoginButtonOnLoginPage(EMAIL, PASSWORD);
        assertTrue("Кнопка Оформить Заказ не появилась" ,loginPage.checkIsDisplayedPlaceOrderButton());
    }

    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Авторизация через кнопку «Восстановления пароля»")
    @Test
    public void logonToButtonFromRecoveryPasswordPageTest() {
        goPage(URL_PAGE);
        mainPage.clickLoginButtonOnMainPage();
        loginPage.clickRecoverButtonOnLoginPage();
        loginPage.clickLoginButtonOnRecoverPage();
        loginPage.setDataAndClickLoginButtonOnLoginPage(EMAIL, PASSWORD);
        assertTrue("Кнопка Оформить Заказ не появилась" ,loginPage.checkIsDisplayedPlaceOrderButton());
    }
}
