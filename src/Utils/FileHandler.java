package Utils;

import java.io.*;

public class FileHandler
{
  // Reads the first object from the file with the given file name and returns it.
  // Whoever calls the method will need to cast it from type Object to its actual type
  public static Object readFromBinaryFile(String fileName) throws
      FileNotFoundException, IOException, ClassNotFoundException
  {
    Object obj = null;
    ObjectInputStream readFromFile = null;
    try
    {
      FileInputStream fileInStream = new FileInputStream(fileName);

      try
      {
        // We put this line in the try block because if the file is empty, it throws EOFException on it and not on the .readObject() line
        readFromFile = new ObjectInputStream(fileInStream);
        obj = readFromFile.readObject();
      }
      catch (EOFException eof)
      {
        //Done reading
        System.out.println("Done reading from file " + fileName);
      }
    }
    finally
    {
      if (readFromFile != null)
      {
        try
        {
          readFromFile.close();
        }
        catch (IOException e)
        {
          System.out.println("IO Error closing file " + fileName);
        }
      }
    }

    return obj;
  }

  // Writes the given object to a file with the given file name
  public static void writeToBinaryFile(String fileName, Object obj) throws FileNotFoundException, IOException
  {
    ObjectOutputStream writeToFile = null;

    try
    {
      FileOutputStream fileOutStream = new FileOutputStream(fileName);
      writeToFile = new ObjectOutputStream(fileOutStream);

      writeToFile.writeObject(obj);
    }
    finally
    {
      if (writeToFile != null)
      {
        try
        {
          writeToFile.close();
        }
        catch (IOException e)
        {
          System.out.println("IO Error closing file " + fileName);
        }
      }
    }
  }
}
