package Utils;

import javax.swing.*;

/**
 * The class that is used to display the InvalidValueException message
 * @author Group 2
 * @version 1.0
 */
public class InvalidValueException extends RuntimeException
{
    /**
     * Constructor for this exception with a basic message
     * @param string the field that has an invalid value
     */
    public InvalidValueException(String string)
    {
        JOptionPane.showMessageDialog(null, "The value you entered for " + string +
                " is not valid", "Invalid value", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Constructor for this exception with a custom message
     * @param string the field that has an invalid value
     * @param value shows if the value is too low or too high
     */
    public InvalidValueException(String string, String value)
    {
        JOptionPane.showMessageDialog(null, "The value you entered for " + string +
                " is too " + value, "Invalid value", JOptionPane.ERROR_MESSAGE);
    }
}
