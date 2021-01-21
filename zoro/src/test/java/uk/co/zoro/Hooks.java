package uk.co.zoro;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import uk.co.zoro.drivers.DriverManager;

public class Hooks extends DriverManager {

    @Before
    public void setup() {
        invokeBrowser();
        goToUrl();
        maxBrowser();
        implicitWait();
    }

    @After
    public void tearDown() {
        quitBrowser();
    }
}
