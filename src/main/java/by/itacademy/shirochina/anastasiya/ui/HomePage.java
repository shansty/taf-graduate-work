package by.itacademy.shirochina.anastasiya.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage {
    private ChromeDriver driver;
    private WebDriverWait wait;

    private String baseURL = "https://markformelle.by/";
    private String closePopUpLocator = "//div[@class = 'popmechanic-close']";
    private String clickLoginButtonLocator = "//a[@class = 'header-profile js-popup-modal-input']";
    private String clickProfileButtonLocator = "//a[@class = 'header-profile']";
    private String submitLoginFormLocator = "//button[@name = 'Login']";
    private String inputPasswordLocator = "//input[@name='USER_PASSWORD']";
    private String inputEmailLocator = "//input[@name='USER_LOGIN']";
    private String errorMessageLocator = "//div[@id='error_email_reg'][text()='Неверный Email или пароль.']";
    private String successfulUserNameLocator = "//p[@class='us-ac-name']";
    private String enterByLoginForm = "//span[text() = 'Войти по почте / логину']";
    public String expectedErrorMessage = "Неверный Email или пароль.";
    public String expectedUserName = "Анастасия Широчина";

    public HomePage(ChromeDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void openBaseURL() {
        driver.get(baseURL);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickLoginButtonLocator)));
        driver.findElement(By.xpath(clickLoginButtonLocator)).click();
    }
    public void clickProfileButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(clickProfileButtonLocator)));
        driver.findElement(By.xpath(clickProfileButtonLocator)).click();
    }
    public void choseAuthorizationMethodByLoginForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(enterByLoginForm)));
        driver.findElements(By.xpath(enterByLoginForm)).get(0).click();
    }

    public void fillEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputPasswordLocator)));
        WebElement inputEmail = driver.findElement(By.xpath(inputEmailLocator));
        inputEmail.sendKeys(email);
    }

    public void fillPassword(String password) {
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
        String actualErrorMessage = driver.findElement(By.xpath(errorMessageLocator)).getText();
        return actualErrorMessage;
    }
    public String getSuccessfulUserName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(successfulUserNameLocator)));
        String actualSuccessfulUserName = driver.findElement(By.xpath(successfulUserNameLocator)).getText();
        return actualSuccessfulUserName;
    }
    public void closePopUp(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closePopUpLocator)));
            driver.findElement(By.xpath(closePopUpLocator)).click();
        } catch (TimeoutException e) {
        }
    }
}
