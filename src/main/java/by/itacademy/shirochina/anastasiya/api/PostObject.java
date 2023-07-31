package by.itacademy.shirochina.anastasiya.api;

import by.itacademy.shirochina.anastasiya.utils.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.util.HashMap;

public class PostObject {
    private Util util;
    public String endpoint = "https://markformelle.by/ajax/auth_ajax.php";
    public String searchEndpoint  = "https://markformelle.by/search";
    public String successMessage = "Вы успешно вошли на сайт!";
    public String errorMessage = "Неверный Email или пароль.";
    public String tagNameForCorrectMessage = "span";
    public String tagNameForIncorrectMessage = "font";
    public String validQueryParam = "t-shirt";
    public String invalidQueryParam = "лестница";
    public String cssQueryForCorrectSearch = "li.catalog-item.women-item input[name='name']";
    public String attributeForCorrectSearch = "value";
    public String cssQueryForIncorrectSearch = "div.text";
    public String expectedMessageForValidSearch = "Бюстгальтер t-shirt без косточек белого цвета";
    public String expectedMessageForInvalidSearch = "Сожалеем, но по вашему запросу ничего не найдено";

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
    public String getActualMessageFromTagName(String htmlResponse, String tagName) {
        Document document = Jsoup.parse(htmlResponse);
        return document.getElementsByTag(tagName).text();
    }
    public String getActualMessageFromCssQuery(String htmlResponse, String cssQuery) {
        Document document = Jsoup.parse(htmlResponse);
        return document.select(cssQuery).text();
    }
    public String getActualMessageInAttribute(String htmlResponse, String cssQuery, String attribute) {
        Document document = Jsoup.parse(htmlResponse);
        return document.select(cssQuery).attr(attribute);
    }
}
