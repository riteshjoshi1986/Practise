/**
 * 
 */
package Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

/**
 * @author rj0844
 * This class is created to read the object repository file which contains the locating elements details 
 */
public class ObjectRepositoryReader {

	Properties p = new Properties();
		
	public Properties readObjectRepository(String filepath, String filename) throws Exception{
		File source = new File(filepath+"\\"+filename);
		FileInputStream fis = new FileInputStream(source);
		p.load(fis);
		return p;
		
	}
	
}
