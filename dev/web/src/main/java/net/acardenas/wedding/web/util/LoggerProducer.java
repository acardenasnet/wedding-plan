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

package net.acardenas.wedding.web.util;

import java.util.logging.Logger;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@Default
public class LoggerProducer
{

    /**
     * @param injectionPoint
     * @return logger
     */
    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint)
    {
        System.out.println("produceLogger");
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}