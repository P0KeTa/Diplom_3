import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static ru.poketa.stellar.burgers.data.TestData.URL_PAGE;

public class ConstructorTest extends BaseTest {

    @DisplayName("Переход к разделу «Булки»")
    @Description("Проверка правильности перехода на раздел Булки")
    @Test
    public void checkMoveToDesignerBunsTest() {
        goPage(URL_PAGE);
        mainPage.clickConstructorPartitions("Начинки");
        mainPage.clickConstructorPartitions("Булки");
        assertTrue("Раздел Булки не выбран", mainPage.checkSwitchConstructorPartitions("Булки"));
    }

    @DisplayName("Переход к разделу «Соусы»")
    @Description("Проверка правильности перехода на раздел Соусы")
    @Test
    public void checkMoveToDesignerSousesTest() {
        goPage(URL_PAGE);
        mainPage.clickConstructorPartitions("Соусы");
        assertTrue("Раздел Соусы не выбран", mainPage.checkSwitchConstructorPartitions("Соусы"));
    }

    @DisplayName("Переход к разделу «Начинки»")
    @Description("Проверка правильности перехода на раздел Начинки")
    @Test
    public void checkMoveToDesignerToppingsTest() {
        goPage(URL_PAGE);
        mainPage.clickConstructorPartitions("Начинки");
        assertTrue("Раздел Начинки не выбран", mainPage.checkSwitchConstructorPartitions("Начинки"));
    }
}
