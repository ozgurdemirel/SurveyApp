package com.demirel.resource;

import com.demirel.common.dto.PaginatedData;
import com.demirel.common.dto.filter.PaginationData;
import com.demirel.model.Choice;
import com.demirel.model.Survey;
import com.demirel.model.filter.SurveyFilter;
import com.demirel.repoository.SurveyRepository;
import com.demirel.common.base.resource.GenericResourceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/survey")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SurveyResource extends GenericResourceImpl<SurveyRepository, Survey> {
    @Override
    public Response save(Survey survey) {
        for (Choice choice : survey.getChoices()) {
            choice.setSurvey(survey);
        }
        return super.save(survey);
    }

    @GET
    @Path("/findByFilter")
    public Response findByFilter(SurveyFilter surveyFilter) {
        return Response.ok().entity(getRepository().findByFilter(surveyFilter)).build();
    }
}
