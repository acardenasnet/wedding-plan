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

package net.acardenas.wedding.exception;

import javax.ejb.ApplicationException;

/**
 * @author acardenas
 *
 */
@ApplicationException(rollback = false)
public class WeddingPlannerException 
    extends RuntimeException
{
    private static final long serialVersionUID = -387524337230772787L;

    /**
     * 
     */
    public WeddingPlannerException()
    {
        // empty
    }

    /**
     * @param aMessage
     */
    public WeddingPlannerException(String aMessage)
    {
        super(aMessage);
    }

    /**
     * @param aCause
     */
    public WeddingPlannerException(Throwable aCause)
    {
        super(aCause);
    }

    /**
     * @param aMessage
     * @param aCause
     */
    public WeddingPlannerException(String aMessage, Throwable aCause)
    {
        super(aMessage, aCause);
    }

}
