/**
 * 
 */
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
     * @param message
     */
    public WeddingPlannerException(String message)
    {
        super(message);
    }

    /**
     * @param cause
     */
    public WeddingPlannerException(Throwable cause)
    {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public WeddingPlannerException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
