package com.demirel.model.filter;

import com.demirel.common.dto.filter.GenericFilter;

/**
 * Created by ozgur on 23.03.2017.
 */
public class SurveyFilter extends GenericFilter {

    private String questionText;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public String toString() {
        return "SurveyFilter{" +
                "questionText='" + questionText + '\'' +
                '}';
    }
}
