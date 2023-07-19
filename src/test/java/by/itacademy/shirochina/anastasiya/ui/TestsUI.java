package by.itacademy.shirochina.anastasiya.ui;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestsUI extends BaseTest {

    @Test
    public void testFormWithIncorrectDataAndSubmit() {
        step.fillFormAndSubmitWithIncorrectData(util.generateEmail(), util.generatePassword());
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void testFormWithEmailAndEmptyPassword() {
        step.fillFormAndSubmitWithIncorrectData(util.generateEmail(), "");
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void testFormWithPasswordAndEmptyEmail() {
        step.fillFormAndSubmitWithIncorrectData("", util.generatePassword());
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void testFormWithEmptyData() {
        step.fillFormAndSubmitWithIncorrectData("", "");
        Assertions.assertEquals(homePage.expectedErrorMessage, homePage.getErrorMessage());
    }

    @Test
    public void testFormWithCorrectData() {
        step.fillFormAndSubmitWithCorrectData(util.correctEmail(), util.correctPassword());
        Assertions.assertEquals(homePage.expectedUserName, homePage.getSuccessfulUserName());
    }
}
