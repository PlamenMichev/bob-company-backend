package Util;

import javax.swing.*;

public class InvalidValueException extends RuntimeException
{
    public InvalidValueException()
    {
        JOptionPane.showMessageDialog(null, "The value you entered " +
                "is not valid", "Invalid value", JOptionPane.ERROR_MESSAGE);
    }
}
