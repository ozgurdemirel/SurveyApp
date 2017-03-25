package com.demirel.repoository;

import com.demirel.builders.ChoiceBuilder;
import com.demirel.builders.SurveyBuilder;
import com.demirel.model.Survey;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;


public class SurveyRepositoryTest {

    //todo : write some test for existById  & filter & filterNull & filterWithPagination & filterByQuestionText

    private EntityManagerFactory emf;
    private EntityManager em;

    private SurveyRepository surveyRepository;

    @Before
    public void init(){
        emf = Persistence.createEntityManagerFactory("ds");
        em = emf.createEntityManager();
        surveyRepository = new SurveyRepository();
        surveyRepository.entityManager = em;
    }

    @After
    public void afterUnitTest(){
        em.close();
        emf.close();
    }

    @Test
    public void addSurveyAndFind(){
        Survey survey = getSurvey();
        em.getTransaction().begin();
        Long addedSurveyId = surveyRepository.add(survey).getId();
        em.getTransaction().commit();
        em.clear();

        Survey surveyAdded = surveyRepository.findById(addedSurveyId);
        assertThat(surveyAdded.getQuestionText(),is(equalTo(survey.getQuestionText())));
        assertThat(surveyAdded.getChoices().size(),is(equalTo(survey.getChoices().size())));
    }

    @Test
    public void findBookByIdNotFound(){
        Survey survey = surveyRepository.findById(45665L);
        assertThat(survey,is(nullValue()));
    }

    @Test
    public void updateSurvey(){
        Survey survey = getSurvey();
        em.getTransaction().begin();
        Long addedId = surveyRepository.add(survey).getId();
        em.getTransaction().commit();
        em.clear();
        assertThat(addedId,is(notNullValue()));

        Survey surveyFound = surveyRepository.findById(addedId);
        assertThat(surveyFound.getQuestionText(),is(equalTo(survey.getQuestionText())));

        surveyFound.setQuestionText("updated q");
        em.getTransaction().begin();
        surveyRepository.update(surveyFound);
        em.getTransaction().commit();
        em.clear();

        em.getTransaction().begin();
        String updatedQuestionText = surveyRepository.findById(addedId).getQuestionText();
        em.getTransaction().commit();
        em.clear();

        assertThat(updatedQuestionText,is(equalTo("updated q")));
    }

    private Survey getSurvey() {
        Survey survey = new SurveyBuilder().questionText("ques. 1").build();
        survey.setChoices(
                Arrays.asList(
                        new ChoiceBuilder().choice("choice 1").survey(survey).build(),
                        new ChoiceBuilder().choice("choice 2").survey(survey).build(),
                        new ChoiceBuilder().choice("choice 3").survey(survey).build(),
                        new ChoiceBuilder().choice("choice 4").survey(survey).build(),
                        new ChoiceBuilder().choice("choice 5").survey(survey).build()
                )
        );
        return survey;
    }
}