package org.displaytag.exception;

/**
 * Exception thrown when a Tag is not properly nested into another one.
 * @author Fabrizio Giustina
 * @version $Revision $ ($Author $)
 */
public class TagStructureException extends BaseNestableJspTagException
{

    /**
     * D1597A17A6.
     */
    private static final long serialVersionUID = 899149338534L;

    /**
     * Constructor for InvalidTagAttributeValueException.
     * @param source Class where the exception is generated
     * @param currentTag name of the current tag
     * @param shoudBeNestedIn missing parent tag
     */
    public TagStructureException(Class source, String currentTag, String shoudBeNestedIn)
    {
        super(source, "Tag \"" + currentTag + "\" should ne nested in \"" + shoudBeNestedIn + "\"");
    }

    /**
     * @return SeverityEnum.ERROR
     * @see org.displaytag.exception.BaseNestableJspTagException#getSeverity()
     * @see org.displaytag.exception.SeverityEnum
     */
    public SeverityEnum getSeverity()
    {
        return SeverityEnum.ERROR;
    }

}
