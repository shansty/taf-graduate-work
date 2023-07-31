package by.itacademy.shirochina.anastasiya.ui;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestsUI extends BaseTest {

    @Test
    public void testFormWithIncorrectDataAndSubmit() {
        homeStep.fillFormAndSubmitWithIncorrectData(util.generateEmail(), util.generatePassword());
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void testFormWithEmailAndEmptyPassword() {
        homeStep.fillFormAndSubmitWithIncorrectData(util.generateEmail(), "");
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void testFormWithPasswordAndEmptyEmail() {
        homeStep.fillFormAndSubmitWithIncorrectData("", util.generatePassword());
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void testFormWithEmptyData() {
        homeStep.fillFormAndSubmitWithIncorrectData("", "");
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void testFormWithCorrectData() {
        homeStep.fillFormAndSubmitWithCorrectData(util.correctEmail(), util.correctPassword());
        Assertions.assertEquals(homePage.expectedUserName, homePage.getSuccessfulUserName());
    }
}
