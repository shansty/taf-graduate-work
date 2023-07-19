package by.itacademy.shirochina.anastasiya.ui;

import by.itacademy.shirochina.anastasiya.utils.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    ChromeDriver driver;
    HomePage homePage;
    HomeStep step;
    Util util;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        homePage = new HomePage(driver, wait);
        step = new HomeStep(driver, wait);
        util = new Util();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
