package com.demirel.resource;

import com.demirel.model.Survey;
import com.demirel.repoository.SurveyRepository;
import com.demirel.common.base.resource.GenericResourceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/surveyResource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SurveyResource  extends GenericResourceImpl<SurveyRepository,Survey> {

}
