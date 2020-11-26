package com.mykh.videolib.service;

@Deprecated
public class NumberFormatService {
    /**
     * This method fix java.lang.NumberFormatException: null (HTTP Status 500 - null)
     * for method findActorsByManyFilms and removeFilmsByYear
     * parse string value to integer as well
     * @param element - value that server gets in the text field
     * @return
     */

    public int checkAndParse(String element) {
        return element == null ? Integer.MAX_VALUE : Integer.parseInt(element);
    }
}
