package Utils;

import parser.ParserException;
import parser.XmlJsonParser;

import java.io.*;

/**
 * The class that is used to handle reading to and writing from files
 * @author Group 2
 * @version 1.0
 */
public class FileHandler
{
  // Reads the first object from the file with the given file name and returns it.
  // Whoever calls the method will need to cast it from type Object to its actual type

  /**
   * Method used to read from binary files
   * @param fileName the name of the file in use
   * @return obj the text read from file
   */
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

  /**
   * Method used to write to binary files
   * @param fileName the file in use
   * @param obj the text to be written in the file
   */
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

  /**
   * Method used to write to Xml files
   * @param fileName the file in use
   * @param obj the text to be written in the file
   */
  public static void writeToXmlFile(String fileName, Object obj) throws
      ParserException
  {
    XmlJsonParser parser = new XmlJsonParser();
    try
    {
      parser.toXml(obj, fileName);
    }
    catch (ParserException e)
    {
      System.out.println("Error writing to XML file");
    }
    finally
    {
      System.out.println("Done writing to XML file");
    }
  }
}
