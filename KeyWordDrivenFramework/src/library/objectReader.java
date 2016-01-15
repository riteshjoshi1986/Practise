package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class objectReader {
	Properties pro = new Properties();
	
	public Properties getObjectRepository() throws IOException{
		File or = new File("C:\\Ritesh\\KeyWordDrivenFramework\\ObjectProperties.properties");
		FileInputStream fis = new FileInputStream(or);
		pro.load(fis);
		return pro;
	}

}
