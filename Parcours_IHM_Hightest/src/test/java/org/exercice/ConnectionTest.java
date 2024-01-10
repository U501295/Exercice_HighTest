package org.exercice;

import org.exercice.hightest.HomePage;
import org.exercice.hightest.ToolBoxPage;
import org.exercice.utils.AutomTools;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;


class ConnectionTest {

    @BeforeAll
    public static void init() {
        AutomTools.makeDriverChrome();
        AutomTools.driverImplicitWaitConfig(Duration.ofSeconds(3));
    }

    @Test
    void shouldGetToHomePage() {
        HomePage homePage = new HomePage("https://hightest.nc/");
        homePage.getToHomePage();
        ToolBoxPage toolBoxPage = homePage.clickToolBoxButton();
        toolBoxPage.clickISTQBFoundationFrenchButton();

    }
}
