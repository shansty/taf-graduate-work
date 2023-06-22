package by.itacademy.shirochina.anastasiya;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeStep {
    HomePage page;
    public HomeStep (ChromeDriver driver, WebDriverWait wait){
        page = new HomePage(driver, wait);
    }
    public void fillFormAndSubmit(String email, String password) {
        page.openBaseURL();
        page.closePopUp();
        page.clickLoginButton();
        page.fieldEmail(email);
        page.fieldPassword(password);
        page.submitLoginForm();
    }
}
