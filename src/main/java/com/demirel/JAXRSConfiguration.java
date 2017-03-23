package com.demirel;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.logging.Logger;

@ApplicationPath("resource")
public class JAXRSConfiguration extends Application {

    @Inject
    private Logger logger;



}
