package Utils;

import javax.swing.*;

public class EmptyStringFieldException extends RuntimeException
{
    public EmptyStringFieldException()
    {
        JOptionPane.showMessageDialog(null, "This field cannot" +
                "be empty", "Empty field", JOptionPane.ERROR_MESSAGE);
    }
}
