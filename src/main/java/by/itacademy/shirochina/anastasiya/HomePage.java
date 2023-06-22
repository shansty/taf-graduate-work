package by.itacademy.shirochina.anastasiya;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private ChromeDriver driver;
    private WebDriverWait wait;

    private String baseURL = "https://markformelle.by/";
    private String clickLoginButtonLocator = "//a[@class = 'header-profile js-popup-modal-input']";
    private String submitLoginFormLocator = "//input[@name = 'Login']";
    private String inputPasswordLocator = "//input[@placeholder = 'Пароль']";
    private String inputEmailLocator = "//input[@placeholder = 'Email или логин ']";
    private String errorMessageLocator = "//div[text()='Неверный Email или пароль.']";
    private String closePopUpLocator = "//div[@class = 'popmechanic-close']";
    protected String expectedErrorMessage = "Неверный Email или пароль.";

    HomePage(ChromeDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void openBaseURL() {
        driver.get(baseURL);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath(clickLoginButtonLocator)).click();
    }

    public void fieldEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputPasswordLocator)));
        WebElement inputEmail = driver.findElement(By.xpath(inputEmailLocator));
        inputEmail.sendKeys(email);
    }

    public void fieldPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputPasswordLocator)));
        WebElement inputPassword = driver.findElement(By.xpath(inputPasswordLocator));
        inputPassword.sendKeys(password);
    }

    public void submitLoginForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submitLoginFormLocator)));
        driver.findElement(By.xpath(submitLoginFormLocator)).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(errorMessageLocator)));
        List<WebElement> errorMessages = driver.findElements(By.xpath(errorMessageLocator));
        String actualErrorMessage = errorMessages.get(1).getText();
        return actualErrorMessage;
    }
    public void closePopUp(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closePopUpLocator)));
            driver.findElement(By.xpath(closePopUpLocator)).click();
        } catch (TimeoutException e) {

        }
    }
}
