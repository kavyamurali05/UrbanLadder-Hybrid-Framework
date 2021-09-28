package com.mindtree.pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.reusable.reusableComponent;
import com.mindtree.runner.TestRunner;
import com.mindtree.uistore.HomepageUI;

public class Homepage extends reusableComponent{
	
	public Homepage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}
	HomepageUI hu = new HomepageUI (driver);
	
	public WebElement username() {
		return driver.findElement(hu.email);
	}
	public WebElement password() {
		return driver.findElement(hu.password);
	}
	public WebElement loginbutton() {
		return driver.findElement(hu.signUpButton);
	}
	public WebElement humanIcon() {
		return driver.findElement(hu.humanIcon);
	}
	
	
	public WebElement store() {
		return driver.findElement(hu.stores);
	}
	public WebElement viewDetails() {
		return driver.findElement(hu.viewDetails);
	}
	public WebElement location() {
		return driver.findElement(hu.location);
	}
	public WebElement Home() {
		return driver.findElement(hu.home);
	}
	public WebElement viewCustomerStories() {
		return driver.findElement(hu.customerStories);
	}
	public WebElement aboutUs() {
		return driver.findElement(hu.aboutUs);
	}
	public WebElement searchBox() {
		return driver.findElement(hu.searchbox);
	}
	public WebElement searchIcon() {
		return driver.findElement(hu.searchIcon);
	}
	
	public WebElement Product() {
		return driver.findElement(hu.product);
	}
	public WebElement addToCart() {
		return driver.findElement(hu.addcart);
	}
	
	public WebElement Help() {
		return driver.findElement(hu.help);
	}
	public WebElement giftCard() {
		return driver.findElement(hu.giftCard);
	}
	
	public WebElement logoutButton() {
		return driver.findElement(hu.logout);
	}

}