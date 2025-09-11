package ru.poketa.stellar.burgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage extends MainPage {
    //Кнопка «Зарегистрироваться» на странице авторизации
    private final By registerButtonLoginPage = By.xpath(
            ".//a[text()='Зарегистрироваться']");
    //Поля и кнопка «Зарегистрироваться» на странице регистрации
    private final By nameField = By.xpath(
            ".//label[text() = 'Имя']/following-sibling::input");
    private final By emailField = By.xpath(
            ".//label[text() = 'Email']/following-sibling::input");
    private final By passwordField = By.xpath(
            ".//label[text() = 'Пароль']/following-sibling::input");
    private final By registerButtonRegisterPage = By.xpath(
            ".//button[text()='Зарегистрироваться']");
    private final By textErrorPasswordField = By.xpath(
            ".//p [text() = 'Некорректный пароль']");
    private final By loginButtonOnRegisterPage = By.xpath(
            ".//a [text() = 'Войти']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке Зарегистрироваться на странице авторизации")
    public void clickRegisterButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(registerButtonLoginPage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
        webElement.click();
    }

    @Step("Заполнение полей и клик по кнопке Зарегистрироваться")
    public void setDataAndClickRegisterButton(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registerButtonRegisterPage).click();
    }

    @Step("Проверка появления сообщения об ошибке в поле Пароль")
    public boolean errorIsDisplayed() {
        WebElement webElement = driver.findElement(textErrorPasswordField);
        return webElement.isDisplayed();
    }

    @Step("Клик по кнопке Войти на странице регистрации")
    public void clickLoginButtonOnRegisterPage() {
        driver.findElement(loginButtonOnRegisterPage).click();
    }
}


