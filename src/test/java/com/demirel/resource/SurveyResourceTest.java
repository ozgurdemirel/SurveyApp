package com.demirel.resource;

import com.demirel.builders.ChoiceBuilder;
import com.demirel.model.Survey;
import com.demirel.repoository.SurveyRepository;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class SurveyResourceTest {

    private Logger logger = Logger.getLogger(getClass().getName());

    private SurveyResource surveyResource;

    @Mock
    private SurveyRepository surveyRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        surveyResource = new SurveyResource();
        surveyResource.setRepository(surveyRepository);
    }

    @Test
    public void addValidSurvey(){
        Survey survey = getSurvey();
        logger.log(Level.INFO,new Gson().toJson(survey));
        when(surveyRepository.add(survey)).thenReturn(getSurveyWithId());

        Response response = surveyResource.save(survey);
        assertThat(response.getStatus(),is(equalTo(201)));
        survey=(Survey) response.getEntity();
        assertThat(survey.getId(),is(equalTo(1L)));
    }

    private Survey getSurvey() {
        Survey survey=new Survey();
        survey.setQuestionText("question 1");
        survey.setChoices(
                Arrays.asList(
                    new ChoiceBuilder().choice("choice 1").build(),
                    new ChoiceBuilder().choice("choice 2").build(),
                    new ChoiceBuilder().choice("choice 3").build(),
                    new ChoiceBuilder().choice("choice 4").build(),
                    new ChoiceBuilder().choice("choice 5").build()
                ));
        return survey;
    }

    private Survey getSurveyWithId(){
        Survey survey = getSurvey();
        survey.setId(1L);
        return survey;
    }
}