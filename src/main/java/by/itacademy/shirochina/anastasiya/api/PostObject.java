package by.itacademy.shirochina.anastasiya.api;

import by.itacademy.shirochina.anastasiya.utils.Util;

import java.util.HashMap;

public class PostObject {
    Util util;
    public HashMap<String, String> getFormParamsWithCorrectData() {
        util = new Util();
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("backurl", "/");
        formParams.put("AUTH_FORM", "Y");
        formParams.put("TYPE", "AUTH");
        formParams.put("USER_LOGIN", util.correctEmail());
        formParams.put("USER_PASSWORD", util.correctPassword());
        formParams.put("USER_REMEMBER", "Y");
        return formParams;
    }
    public HashMap<String, String> getFormParamsWithIncorrectData() {
        util = new Util();
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("backurl", "/");
        formParams.put("AUTH_FORM", "Y");
        formParams.put("TYPE", "AUTH");
        formParams.put("USER_LOGIN", util.generateEmail());
        formParams.put("USER_PASSWORD", util.generatePassword());
        formParams.put("USER_REMEMBER", "Y");
        return formParams;
    }
    public HashMap<String, String> getQueryParams(String queryParam) {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("q", queryParam);
        return queryParams;
    }
}
