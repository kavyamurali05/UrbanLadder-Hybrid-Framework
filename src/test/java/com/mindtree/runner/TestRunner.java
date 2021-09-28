package com.mindtree.runner;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mindtree.pageObjects.Homepage;
import com.mindtree.reusable.reusableComponent;
import com.mindtree.utility.ExcelSheetReader;
import com.mindtree.utility.screenshot;

import junit.framework.Assert;
	public class TestRunner extends reusableComponent{
		
		public static Logger log = LogManager.getLogger(TestRunner.class.getName());
		
		
		
		@BeforeTest
		 public void launchTestSite() throws IOException  {
			try {
				//PropertyConfigurator.configure("files\\log4j.propertises");
			     driver  =  initializeDriver();
				String url = prop.getProperty("url");
				driver.get(url);
				driver.manage().window().maximize();
				log.info("Driver initialised");
				log.info(url);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(driver);
				
			}
			
			}
		
		Homepage hp = new Homepage(driver);
		
		@Test(priority =0,dataProvider="loginData")
		public void signup(String email,String password) throws Exception {
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			hp.username().sendKeys(email);
			hp.password().sendKeys(password);
			hp.loginbutton().click();
			log.info("Successfully signed in");
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("C:\\test\\signUpScreenshot.png"));
			
		}
		
		  @Test(priority =1)
			public void store() throws Exception {
				hp.store().click();
				hp.viewDetails().click();
				System.out.println(hp.location().getText());
				log.info("Successfully validated store");
				
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src,new File("C:\\test\\storeScreenshot.png"));
				
			}
		  
		  @Test(priority =2)
			public void customerStories() throws Exception {
			      hp.Home().click();
				  hp.viewCustomerStories().click();
				  log.info("customer stories opened successfully");
				  
				  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  FileUtils.copyFile(src,new File("C:\\test\\customerStoriesScreenshot.png"));
			}
		  
			@Test(priority =3)
			public void validateAboutUs() throws Exception {
				hp.Home().click();
				hp.aboutUs().click();
				System.out.println(driver.getTitle());
				log.info("Successfully validated about us");
				
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src,new File("C:\\test\\aboutUsScreenshot.png"));
				
			}
			
			@Test(priority =4,dataProvider="searchData")
			public void search(String product) throws Exception {
				hp.searchBox().sendKeys(product);
				hp.searchIcon().click();
				driver.navigate().back();
				log.info("Successfully searched the product");
				
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src,new File("C:\\test\\searchScreenshot.png"));
			}
			
			@Test(priority =5)
			public void Help() throws Exception
			{
				hp.Home().click();
				hp.Help().click();
				log.info(driver.getTitle());
				Assert.assertEquals(driver.getTitle(), "Help | urbanladder.com");
				log.info("Successfully validated help button");
				
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src,new File("C:\\test\\helpScreenshot.png"));
				
				
			}
			
			@Test(priority =6)
			public void giftCard() throws Exception {
				hp.Home().click();
				hp.giftCard().click();
				log.info(driver.getTitle());
				Assert.assertEquals(driver.getTitle(), "Gift Card - Buy Gift Cards & Vouchers Online for Wedding, Birthday | Urban Ladder");
				log.info("Successfully validated gift cards");
				
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src,new File("C:\\test\\giftCardScreenshot.png"));
			}
			
			@Test(priority =7)
			public void addToCart() throws Exception  {
				//Thread.sleep(1000);
				hp.searchBox().sendKeys("sofas");
				hp.searchIcon().click();
				hp.Product().click();
			    hp.addToCart().click();		
			    log.info("Product successfully added to cart");
			    
			    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src,new File("C:\\test\\cartScreenshot.png"));
			}
			
			@Test(priority =8)
			public void logout() throws Exception {
				hp.Home().click();
				hp.humanIcon().click();
				hp.logoutButton().click();
				log.info("Successfully logged out");
				
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  FileUtils.copyFile(src,new File("C:\\test\\logoutScreenshot.png"));
				
				}
			
			
			@DataProvider
			public Object[] searchData() throws IOException
			{
				
				ArrayList d=ExcelSheetReader.getData("search");
				int size=d.size();
				Object[] data=new Object[size];
				for(int i=0;i<size;i++)
				{
					data[i]=d.get(i);
					
				}
				
				return data;
				
			}
			@DataProvider
			public Object[][] loginData()
			{
				Object[][] data= new Object[1][2];
				data[0][0] =prop.getProperty("email");
				data[0][1] =prop.getProperty("password");
				
				return data;
			}
			
			@AfterTest
			public void clear() {
				driver.quit();
			}
		
		
			
			
		
	}