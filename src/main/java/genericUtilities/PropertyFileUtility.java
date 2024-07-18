package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


/**
* This class consists of generic methods to read data from 
* property file
* @author harshdeliwala
* 
*/

public class PropertyFileUtility 
{
	/**
	 * This method will read data from property file and return the value to
	 * caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/CommonData.properties");
	    Properties p = new Properties();
	    p.load(fis);
	    String value = p.getProperty(key);
	    return value;
	    
	}

}