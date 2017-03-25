package com.demirel.repoository;

import com.demirel.model.Survey;
import com.demirel.model.filter.SurveyFilter;
import com.demirel.common.base.repository.GenericRepositoryImpl;
import com.demirel.common.dto.PaginatedData;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class SurveyRepository extends GenericRepositoryImpl<Survey> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected Class<Survey> getPersistentClass() {
        return Survey.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public PaginatedData<Survey> findByFilter(final SurveyFilter surveyFilter){
        final StringBuilder clause = new StringBuilder("Where e.id is not null");
        final Map<String,Object> queryParamters = new HashMap<>();
        if (surveyFilter.getQuestionText() != null){
            clause.append(" AND UPPER(e.questionText) Like UPPER(:questionText)");
            queryParamters.put("questionText","%"+surveyFilter.getQuestionText()+"%");
        }
        return findByParameters(
                clause.toString(),
                surveyFilter.getPaginationData(),
                queryParamters,
                "questionText ASC"
                );
    }

}
