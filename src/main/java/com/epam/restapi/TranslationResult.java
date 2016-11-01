package com.epam.restapi;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by OLEG on 28.07.2016.
 */
@XmlRootElement
public class TranslationResult {


    private String code;

    private List<String> text;

    private String lang;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "TranslationResult{" +
                "code='" + code + '\'' +
                ", text=" + text +
                ", lang='" + lang + '\'' +
                '}';
    }
}
