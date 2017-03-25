package com.demirel.builders;


import com.demirel.model.Choice;
import com.demirel.model.Survey;

import java.util.ArrayList;
import java.util.List;

public class SurveyBuilder {

    private Long id;

    private String questionText;

    private List<Choice> choices =new ArrayList<>();

    public SurveyBuilder() {
    }

    public  SurveyBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public  SurveyBuilder questionText(String questionText) {
        this.questionText = questionText;
        return this;
    }

    public SurveyBuilder choices(List<Choice> choices) {
        this.choices = choices;
        return this;
    }

    public Survey build(){
        Survey survey = new Survey();
        survey.setId(this.id);
        survey.setQuestionText(this.questionText);
        survey.setChoices(this.choices);
        return survey;
    }

}
