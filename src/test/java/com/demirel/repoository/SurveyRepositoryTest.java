package com.demirel.repoository;

import com.demirel.builders.ChoiceBuilder;
import com.demirel.builders.SurveyBuilder;
import com.demirel.common.dto.PaginatedData;
import com.demirel.common.dto.filter.PaginationData;
import com.demirel.model.Survey;
import com.demirel.model.filter.SurveyFilter;
import com.demirel.utils.TestBaseRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;


public class SurveyRepositoryTest extends TestBaseRepository{

    //todo : write some test for existById  & filter & filterNull & filterWithPagination & filterByQuestionText
    private Logger logger = Logger.getLogger(getClass().getName());
    private SurveyRepository surveyRepository;

    @Before
    public void init(){
        initializeTestDB();
        surveyRepository = new SurveyRepository();
        surveyRepository.entityManager = em;
    }

    @After
    public void afterUnitTest(){
        closeEntityManager();
    }

    @Test
    public void addSurveyAndFind(){
        Survey survey = getSurvey();
        Long addedSurveyId =dbCommandExecutor.executeCommand(() -> surveyRepository.add(survey).getId());
        Survey surveyAdded = surveyRepository.findById(addedSurveyId);
        assertThat(surveyAdded.getQuestionText(),is(equalTo(survey.getQuestionText())));
        assertThat(surveyAdded.getChoices().size(),is(equalTo(survey.getChoices().size())));
    }

    @Test
    public void findSurveyByIdNotFound(){
        Survey survey = surveyRepository.findById(45665L);
        assertThat(survey,is(nullValue()));
    }

    @Test
    public void  findByFilterNoFilter(){
        surveyListInsert();
        PaginatedData<Survey> paginatedData = surveyRepository.findByFilter(new SurveyFilter());
        assertThat(paginatedData.getNumberOfRows(),is(equalTo(9)));
        assertThat(paginatedData.getRows().size(),is(equalTo(9)));
        assertThat(paginatedData.getRow(0).getQuestionText(),is(equalTo("art")));
        assertThat(paginatedData.getRow(paginatedData.getRows().size()-1).getQuestionText(),is(equalTo("programming")));
    }

    @Test
    public void findByFilterByPaginationAndOrderModeDesc(){
        surveyListInsert();

        SurveyFilter surveyFilter=new SurveyFilter();
        surveyFilter.setQuestionText("p");
        //getting first page
        surveyFilter.setPaginationData(new PaginationData(0,2,"id",PaginationData.OrderMode.DESCENDING));
        PaginatedData<Survey> paginatedData = surveyRepository.findByFilter(surveyFilter);
        assertThat(paginatedData.getRows().size(),is(equalTo(2)));
        assertThat(paginatedData.getNumberOfRows(),is(equalTo(5)));
        //getting third page
        surveyFilter.setPaginationData(new PaginationData(4,2,"id", PaginationData.OrderMode.DESCENDING));
        paginatedData = surveyRepository.findByFilter(surveyFilter);
        assertThat(paginatedData.getRows().size(),is(equalTo(1)));
        assertThat(paginatedData.getNumberOfRows(),is(equalTo(5)));
    }

    @Test
    public void updateSurvey(){
        Survey survey = getSurvey();
        Long addedId = dbCommandExecutor.executeCommand(() -> surveyRepository.add(survey).getId());
        assertThat(addedId,is(notNullValue()));
        Survey surveyFound = surveyRepository.findById(addedId);
        assertThat(surveyFound.getQuestionText(),is(equalTo(survey.getQuestionText())));
        surveyFound.setQuestionText("updated q");
        dbCommandExecutor.executeCommand(() -> {surveyRepository.update(surveyFound); return null;});
        String updatedQuestionText = dbCommandExecutor.executeCommand(() -> surveyRepository.findById(addedId).getQuestionText());
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

    private void surveyListInsert(){
        dbCommandExecutor.executeCommand(()->{
            surveyRepository.add(getSurveyWithParameter("maths","maths"));
            surveyRepository.add(getSurveyWithParameter("chemistry","chemistry"));
            surveyRepository.add(getSurveyWithParameter("art","art"));
            surveyRepository.add(getSurveyWithParameter("programming","programming"));
            surveyRepository.add(getSurveyWithParameter("poet","p1"));
            surveyRepository.add(getSurveyWithParameter("params","p2"));
            surveyRepository.add(getSurveyWithParameter("paradigm","p3"));
            surveyRepository.add(getSurveyWithParameter("politic","politic"));
            surveyRepository.add(getSurveyWithParameter("hunger games","hunger games"));
            return null;
        });
    }

    private Survey getSurveyWithParameter(String question,String choice) {
        Survey survey = new SurveyBuilder().questionText(question).build();
        survey.setChoices(
                Arrays.asList(
                        new ChoiceBuilder().choice(choice+" 1").survey(survey).build(),
                        new ChoiceBuilder().choice(choice+" 2").survey(survey).build(),
                        new ChoiceBuilder().choice(choice+" 3").survey(survey).build(),
                        new ChoiceBuilder().choice(choice+" 4").survey(survey).build(),
                        new ChoiceBuilder().choice(choice+" 5").survey(survey).build()
                )
        );
        return survey;
    }
}