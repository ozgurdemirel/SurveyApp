package com.demirel;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * Created by ozgur on 23.03.2017.
 */
public class ConfigurationProducer {

    @Produces
    @PersistenceContext(unitName =  "ds")
    private EntityManager entityManager;


    @Produces
    public Logger createLogger(InjectionPoint ip) {
        return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
    }

}
