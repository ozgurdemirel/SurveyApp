package com.demirel.resource;

import com.demirel.common.base.resource.GenericResourceImpl;
import com.demirel.model.Choice;
import com.demirel.model.Survey;
import com.demirel.repoository.ChoiceRepository;
import com.demirel.repoository.SurveyRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/choice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChoiceResource extends GenericResourceImpl<ChoiceRepository,Choice> {

}
