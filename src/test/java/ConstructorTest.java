import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static ru.p0keta.stellarBurgers.data.TestData.URL_PAGE;

public class ConstructorTest extends BaseTest {

    @DisplayName("Переход к разделу «Булки»")
    @Test
    public void checkMoveToDesignerBuns() {
        goPage(URL_PAGE);
        mainPage.clickConstructorPartitions("Булки");
        assertTrue("Раздел Булки не выбран", mainPage.checkSwitchConstructorPartitions("Булки"));
    }

    @DisplayName("Переход к разделу «Соусы»")
    @Test
    public void checkMoveToDesignerSouses() {
        goPage(URL_PAGE);
        mainPage.clickConstructorPartitions("Соусы");
        assertTrue("Раздел Соусы не выбран", mainPage.checkSwitchConstructorPartitions("Соусы"));
    }

    @DisplayName("Переход к разделу «Начинки»")
    @Test
    public void checkMoveToDesignerToppings() {
        goPage(URL_PAGE);
        mainPage.clickConstructorPartitions("Начинки");
        assertTrue("Раздел Начинки не выбран", mainPage.checkSwitchConstructorPartitions("Начинки"));
    }
}
