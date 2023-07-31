package by.itacademy.shirochina.anastasiya.ui;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestsUI extends BaseTest {

    @Test
    public void testFormWithIncorrectDataAndSubmit() {
        long time = System.currentTimeMillis();
        homeStep.fillFormAndSubmitWithIncorrectData(util.generateEmail(), util.generatePassword());
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
        System.out.println("getSuccessfulUserName");
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time);
    }

    @Test
    public void testFormWithEmailAndEmptyPassword() {
        long time = System.currentTimeMillis();
        System.out.println("debag1");
        homeStep.fillFormAndSubmitWithIncorrectData(util.generateEmail(), "");
        System.out.println("debag2");
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
        System.out.println("debag3");
        System.out.println("getSuccessfulUserName");
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time);
    }

    @Test
    public void testFormWithPasswordAndEmptyEmail() {
        long time = System.currentTimeMillis();
        homeStep.fillFormAndSubmitWithIncorrectData("", util.generatePassword());
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
        System.out.println("getSuccessfulUserName");
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time);
    }

    @Test
    public void testFormWithEmptyData() {
        long time = System.currentTimeMillis();
        homeStep.fillFormAndSubmitWithIncorrectData("", "");
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
        System.out.println("getSuccessfulUserName");
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time);
    }

    @Test
    public void testFormWithCorrectData() {
        long time = System.currentTimeMillis();
        homeStep.fillFormAndSubmitWithCorrectData(util.correctEmail(), util.correctPassword());
        Assertions.assertEquals(homePage.expectedUserName, homePage.getSuccessfulUserName());
        System.out.println("getSuccessfulUserName");
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time);
    }
}
