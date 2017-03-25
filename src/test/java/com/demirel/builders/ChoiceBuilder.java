package com.demirel.builders;

import com.demirel.model.Choice;
import com.demirel.model.Survey;

public class ChoiceBuilder {

    private Long id;
    private String choice;
    private Survey survey;
    private Integer clickCount;

    public ChoiceBuilder() {
    }

    public ChoiceBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ChoiceBuilder choice(String choice) {
        this.choice = choice;
        return this;
    }

    public ChoiceBuilder survey(Survey survey) {
        this.survey = survey;
        return this;
    }

    public ChoiceBuilder clickCount(Integer clickCount){
        this.clickCount = clickCount;
        return this;
    }

    public Choice build(){
        Choice choice = new Choice();
        choice.setId(this.id);
        choice.setChoice(this.choice);
        choice.setSurvey(this.survey);
        choice.setClickCount(this.clickCount);
        return choice;
    }

}