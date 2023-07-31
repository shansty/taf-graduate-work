package by.itacademy.shirochina.anastasiya.api;

import by.itacademy.shirochina.anastasiya.utils.Util;

import java.util.HashMap;

public class PostObject {
    Util util;
    String endpoint = "https://markformelle.by/ajax/auth_ajax.php";
    String searchEndpoint  = "https://markformelle.by/search";
    String successMessage = "Вы успешно вошли на сайт!";
    String errorMessage = "Неверный Email или пароль.";
    String validQueryParam = "t-shirt";
    String invalidQueryParam = "лестница";
    String expectedMessageForValidSearch = "Бюстгальтер t-shirt без косточек белого цвета";
    String expectedMessageForInvalidSearch = "Сожалеем, но по вашему запросу ничего не найдено";

    private HashMap<String, String> getGeneralFormParams() {
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("backurl", "/");
        formParams.put("AUTH_FORM", "Y");
        formParams.put("TYPE", "AUTH");
        return formParams;
    }

    public HashMap<String, String> getFormParamsWithCorrectData() {
        util = new Util();
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("USER_LOGIN", util.correctEmail());
        formParams.put("USER_PASSWORD", util.correctPassword());
        formParams.put("USER_REMEMBER", "Y");
        formParams.putAll(getGeneralFormParams());
        return formParams;
    }

    public HashMap<String, String> getFormParamsWithIncorrectData() {
        util = new Util();
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("USER_LOGIN", util.generateEmail());
        formParams.put("USER_PASSWORD", util.generatePassword());
        formParams.put("USER_REMEMBER", "Y");
        formParams.putAll(getGeneralFormParams());
        return formParams;
    }
    public HashMap<String, String> getQueryParams(String queryParam) {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("q", queryParam);
        return queryParams;
    }
}
