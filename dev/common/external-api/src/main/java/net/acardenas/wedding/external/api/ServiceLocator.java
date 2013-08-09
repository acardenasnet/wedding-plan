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

package net.acardenas.wedding.external.api;

import java.util.MissingResourceException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public final class ServiceLocator
{
    private ServiceLocator()
    {
        // Empty
    }

    /**
     * Returns an instance of <code>aServiceClass</code>.
     * 
     * @param aJndiName
     *            the name of the service
     * @param aServiceClass
     *            the service type to lookup
     * @param <S>
     *            extends an Object
     * @return Returns a <code>aServiceClass</code> instance.
     * @throws MissingResourceException
     *             if a naming exception is encountered
     */
    public static <S extends Object> S lookup(String aJndiName,
            Class<S> aServiceClass) throws MissingResourceException
    {
        try
        {
            InitialContext myCtx = new InitialContext();
            return lookup(aJndiName, aServiceClass, myCtx);
        } catch (NamingException exception)
        {
            throw new MissingResourceException(
                    "Failed to lookup: " + aJndiName, aServiceClass.getName(),
                    aJndiName);
        }
    }

    private static <S extends Object> S lookup(String aJndiName,
            Class<S> aServiceClass, Context aContext) throws NamingException
    {
        String myJndiName = aJndiName + "#" + aServiceClass.getName();
        Object myObject = aContext.lookup(myJndiName);

        return aServiceClass.cast(PortableRemoteObject.narrow(myObject,
                aServiceClass));
    }
}