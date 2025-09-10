package ru.poketa.stellar.burgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends MainPage{

    private final By emailField = By.xpath(
            ".//label[text() = 'Email']/following-sibling::input");
    private final By passwordField = By.xpath(
            ".//label[text() = 'Пароль']/following-sibling::input");
    private final By loginButtonOnLoginPage = By.xpath(
            ".//button [text() = 'Войти']");
    private final By recoverButtonOnLoginPage = By.xpath(
            ".//a [text() = 'Восстановить пароль']");
    private final By loginButtonOnRecoverPage = By.xpath(
            ".//a [text() = 'Войти']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение полей и клик по кнопке Войти")
    public void setDataAndClickLoginButtonOnLoginPage(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButtonOnLoginPage).click();
    }

    @Step("Клик по кнопке Восстановить пароль")
    public void clickRecoverButtonOnLoginPage() {
        driver.findElement(recoverButtonOnLoginPage).click();
    }

    @Step("Клик по кнопке Войти на странице восстановления пароля")
    public void clickLoginButtonOnRecoverPage() {
        driver.findElement(loginButtonOnRecoverPage).click();
    }
}
