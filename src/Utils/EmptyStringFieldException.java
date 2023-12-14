package Utils;

import javax.swing.*;

/**
 * The class that is used to display the EmptyStringFieldException message
 * @author Group 2
 * @version 1.0
 */
public class EmptyStringFieldException extends RuntimeException
{
    /**
     * The constructor for this exception
     */
    public EmptyStringFieldException()
    {
        JOptionPane.showMessageDialog(null, "This field cannot" +
                "be empty", "Empty field", JOptionPane.ERROR_MESSAGE);
    }
}
