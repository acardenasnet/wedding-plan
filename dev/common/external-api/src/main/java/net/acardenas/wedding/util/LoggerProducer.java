// ---------------------------------------------------------------------------
// COPYRIGHT Alejandro Cardenas, acardenas.net, Saltillo,Coah, MX 2013
// All rights reserved.
//
// The Copyright to the computer program(s) herein is the property of
// Alejandro Raul Cardenas
// The program(s) may be used and/or copied only with the written
// permission from Alejandro Cardenas, or in
// accordance with the terms and conditions stipulated in the
// agreement/contract under which the program(s) have been supplied.
// ---------------------------------------------------------------------------

package net.acardenas.wedding.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerProducer
{
    java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(LoggerProducer.class.getName());
    /**
     * @param injectionPoint
     * @return logger
     */
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint)
    {
        LOG.info("TEST" + injectionPoint.getMember().getDeclaringClass());
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
