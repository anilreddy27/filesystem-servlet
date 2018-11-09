package com.filesystem.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

public class FileUtils {
	InputStream inputStream = null;
	public Properties getPropValues(ServletContext context)throws IOException{
		Properties properties = new Properties();
		try{
			String propertiesFile = "application.properties";
			inputStream = context.getResourceAsStream("/WEB-INF/properties/"+propertiesFile);
			if(inputStream != null)
			{
				properties.load(inputStream);
			}else{
				throw new FileNotFoundException("properties file not found");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception"+e.getMessage());
		}finally {
			inputStream.close();
		}
		return properties;
	}

}
