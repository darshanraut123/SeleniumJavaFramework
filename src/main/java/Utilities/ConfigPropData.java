package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigPropData {
	
	public String getPropertiesFromFile(String propertyName) throws Exception{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"/Resources/common.properties"));
		prop.load(fis);
		return prop.getProperty(propertyName);
	}

}
