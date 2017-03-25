package com.demirel.repoository;

import com.demirel.common.base.repository.GenericRepositoryImpl;
import com.demirel.common.dto.PaginatedData;
import com.demirel.model.Choice;
import com.demirel.model.Survey;
import com.demirel.model.filter.ChoiceFilter;
import com.demirel.model.filter.SurveyFilter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class ChoiceRepository extends GenericRepositoryImpl<Choice> {

    @Inject
    protected EntityManager entityManager;

    @Override
    protected Class<Choice> getPersistentClass() {
        return Choice.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public PaginatedData<Choice> findByFilter(final ChoiceFilter choiceFilter){
        final StringBuilder clause = new StringBuilder("Where e.id is not null");
        final Map<String,Object> queryParamters = new HashMap<>();
        if (choiceFilter.getChoice() != null){
            clause.append(" AND UPPER(e.choice) Like UPPER(:choice)");
            queryParamters.put("choice","%"+choiceFilter.getChoice()+"%");
        }
        return findByParameters(
                clause.toString(),
                choiceFilter.getPaginationData(),
                queryParamters,
                "id DESC"
                );
    }

}
