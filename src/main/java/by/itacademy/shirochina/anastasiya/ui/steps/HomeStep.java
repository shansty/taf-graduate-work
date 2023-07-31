package by.itacademy.shirochina.anastasiya.ui.steps;

import by.itacademy.shirochina.anastasiya.ui.pages.HomePage;

public class HomeStep {
    HomePage page;
    public HomeStep (HomePage page){
        this.page = page;
    }
    public void fillFormAndSubmitWithIncorrectData(String email, String password) {
        page.openBaseURL();
        System.out.println("openBaseURL");
        page.closePopUp();
        System.out.println("closePopUp");
        page.clickLoginButton();
        System.out.println("clickLoginButton");
        page.choseAuthorizationMethodByLoginForm();
        System.out.println("choseAuthorizationMethodByLoginForm");
        page.fillEmail(email);
        System.out.println("fillEmail");
        page.fillPassword(password);
        System.out.println("fillPassword");
        page.submitLoginForm();
        System.out.println("submitLoginForm");
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
