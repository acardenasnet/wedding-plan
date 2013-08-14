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
