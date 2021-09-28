package com.mindtree.utility;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.reporters.Files;

public class screenshot {
	
	static WebDriver driver;
	public static String takeSnapShot(WebDriver driver) throws Exception{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType. FILE);
	String path=System. getProperty("user.dir")+"/Screenshot/"+System. currentTimeMillis()+".png";

	File destination=new File(path);
	try {
	FileUtils. copyFile(src, destination);
}
	catch (IOException e) {
	System.out.println("Capture Failed "+e.getMessage());
	}
	return path;
	}

}
