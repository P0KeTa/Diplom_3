package ru.poketa.stellar.burgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private final By loginButtonOnMainPage =
            By.xpath(".//button[text() = 'Войти в аккаунт']");
    private final By placeOrderButton = By.xpath(
            ".//button[text() = 'Оформить заказ']");
    private final By personalAccountButton = By.xpath(
            ".//p[text() = 'Личный Кабинет']");
    private final By selectedPartitionBuns = By.xpath(
            ".//div [@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By selectedPartitionSouses = By.xpath(
            ".//div [@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By selectedPartitionToppings = By.xpath(
            ".//div [@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    private final By PartitionBuns = By.xpath(
            ".//div[span[text()='Булки']]");
    private final By PartitionSouses = By.xpath(
            ".//div[span[text()='Соусы']]");
    private final By PartitionToppings = By.xpath(
            ".//div[span[text()='Начинки']]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Войти в аккаунт на главной странице")
    public void clickLoginButtonOnMainPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(loginButtonOnMainPage));
        webElement.click();
    }

    @Step("Проверка наличия на странице кнопки Оформить заказ")
    public boolean checkIsDisplayedPlaceOrderButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        return webElement.isDisplayed();
    }

    @Step("Клик по кнопке Личный Кабинет на главной странице")
    public void clickPersonalAccountButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        webElement.click();
    }

    @Step("Клик по разделу {constructorPartitions}")
    public void clickConstructorPartitions(String constructorPartitions) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementToClick;
        try {
            switch (constructorPartitions) {
                case "Булки":
                    elementToClick = wait.until(ExpectedConditions.elementToBeClickable(PartitionBuns));
                    elementToClick.click();
                    break;
                case "Соусы":
                    elementToClick = wait.until(ExpectedConditions.elementToBeClickable(PartitionSouses));
                    elementToClick.click();
                    break;
                case "Начинки":
                    elementToClick = wait.until(ExpectedConditions.elementToBeClickable(PartitionToppings));
                    elementToClick.click();
                    break;
                default:
                    throw new Exception("Неизвестный раздел: " + constructorPartitions);
            }
        } catch (Exception e) {
            //Пишем ошибку и пробуем клик через JavaScript, если перекрытие
            System.out.println("Ошибка клика: " + e.getMessage());
        }
    }

    @Step("Проверка работы перехода к разделам")
    public boolean checkSwitchConstructorPartitions(String constructorPartitions) {
        switch (constructorPartitions) {
            case "Булки":
                return driver.findElement(selectedPartitionBuns).isEnabled();
            case "Соусы":
                return driver.findElement(selectedPartitionSouses).isEnabled();
            case "Начинки":
                return driver.findElement(selectedPartitionToppings).isEnabled();
        }
        return false;
    }
}
