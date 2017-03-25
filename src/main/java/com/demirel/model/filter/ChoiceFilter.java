package com.demirel.model.filter;

import com.demirel.common.dto.filter.GenericFilter;

/**
 * Created by ozgur on 25.03.2017.
 */
public class ChoiceFilter extends GenericFilter {
    private String choice;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return "ChoiceFilter{" +
                "choice='" + choice + '\'' +
                '}';
    }
}
