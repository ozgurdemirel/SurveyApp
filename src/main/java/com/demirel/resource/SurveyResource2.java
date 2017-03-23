package com.demirel.resource;

import com.demirel.model.Choice;
import com.demirel.model.Survey;
import com.demirel.repoository.SurveyRepositoryImpl;
import com.demirel.util.resource.GenericResourceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ozgur on 23.03.2017.
 */
@Path("/s2")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SurveyResource2 extends GenericResourceImpl<SurveyRepositoryImpl,Survey> {

    @GET
    public Response get(){
        Survey survey = new Survey();
        survey.setQuestionText("test");
        List<Choice> chArrays=new ArrayList<>();


        Choice c1=new Choice();
        c1.setChoice("ch1");
        c1.setSurvey(survey);
        chArrays.add(c1);

        survey.setChoices(chArrays);

        Survey add = this.getRepository().add(survey);

        return Response.ok().build();

    }

}
