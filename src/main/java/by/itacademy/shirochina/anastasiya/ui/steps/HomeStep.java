package by.itacademy.shirochina.anastasiya.ui.steps;

import by.itacademy.shirochina.anastasiya.ui.pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeStep {
    HomePage page;
    public HomeStep (HomePage page){
        this.page = page;
    }
    public void fillFormAndSubmitWithIncorrectData(String email, String password) {
        page.openBaseURL();
        page.closePopUp();
        page.clickLoginButton();
        page.choseAuthorizationMethodByLoginForm();
        page.fillEmail(email);
        page.fillPassword(password);
        page.submitLoginForm();
    }
    public void fillFormAndSubmitWithCorrectData(String email, String password) {
        page.openBaseURL();
        page.closePopUp();
        page.clickLoginButton();
        page.choseAuthorizationMethodByLoginForm();
        page.fillEmail(email);
        page.fillPassword(password);
        page.submitLoginForm();
        page.clickProfileButton();
    }
}
