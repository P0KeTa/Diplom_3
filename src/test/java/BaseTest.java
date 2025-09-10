
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.p0keta.stellarBurgers.models.User;
import ru.p0keta.stellarBurgers.pages.LoginPage;
import ru.p0keta.stellarBurgers.pages.MainPage;
import ru.p0keta.stellarBurgers.pages.RegisterPage;

import java.time.Duration;

import static ru.p0keta.stellarBurgers.data.TestData.*;
import static ru.p0keta.stellarBurgers.steps.UserSteps.deleteUser;


public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    Response response;
    User userForCreate;
    User userForLogin;

    @DisplayName("Установка стартовой ссылки в API и запуск WebDriver")
    @Before
    public void initBrowser() {
        String browser = System.getProperty("browser", "chrome"); // по умолчанию chrome
        ChromeOptions options = new ChromeOptions();
        if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "/Users/davidtaziasvili/WebDriver/bin/yandexdriver");
            options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        } else {
            WebDriverManager.chromedriver().setup();
        }
        driver = new ChromeDriver(options);
        RestAssured.baseURI = URL_PAGE;

        userForCreate = new User(EMAIL, PASSWORD, NAME);
        userForLogin = new User(EMAIL, PASSWORD);

        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void goPage(String urlPage) {
        driver.get(urlPage);
    }

    @DisplayName("Удаление пользователя и закрытие браузера")
    @After
    public void tearDownAndDeleteUser() {
        try {
            if (response != null) {
                String accessToken = response.jsonPath().getString("accessToken");
                if (accessToken != null) {
                    deleteUser(accessToken);
                } else {
                    System.out.println("accessToken не найден, пользователь не удалён");
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при удалении пользователя: " + e.getMessage());
        }

        driver.quit();
    }
}