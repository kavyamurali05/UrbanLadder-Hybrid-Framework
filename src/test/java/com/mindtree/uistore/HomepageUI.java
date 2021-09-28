package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomepageUI {
	
	public HomepageUI(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public   By email=By.cssSelector("input.textfield:nth-child(3)");
	
	public   By password = By.cssSelector("input.textfield:nth-child(4)");
	
	public   By signUpButton = By.cssSelector("#signup_form > input.button.primary.signup");
	
	public   By humanIcon = By.cssSelector("#header > div.header__topBar > div > section.header__topBar_sectionRight > ul > li.header__topBarIconList_profile-icon > span > svg");
	
	public   By stores = By.xpath("//*[@id=\"header\"]/section/div/ul[2]/li[1]/a");
	
	public   By viewDetails = By.xpath("//*[@id=\"app-container\"]/div/main/section[2]/div/a[10]/div[2]/button");
	
	public   By location = By.xpath("//*[@id=\"store-details\"]/div[4]/div[1]/address");
	
	public   By home = By.cssSelector("#header > div.header__topBar > div > section.header__topBar_sectionLeft > a > figure");
	
	public   By customerStories = By.xpath("//*[@id=\"home\"]/div[1]/div[4]/div[4]/div[3]/a");
			
	public   By aboutUs = By.xpath("/html/body/div[1]/footer/div[2]/div[1]/div[1]/ul[1]/li[1]/a");
	
	public   By searchbox = By.cssSelector("#search");
	
	public   By searchIcon=By.cssSelector("#search_button > span");
	
	public   By product = By.className("product-img");
	
	public   By addcart = By.cssSelector("#add-to-cart-button");
	
	public   By help =By.cssSelector("#header > section > div > ul.featuredLinksBar__contact-links > li:nth-child(1) > a");
	
	public   By giftCard=By.cssSelector("#header > section > div > ul.featuredLinksBar__linkContainer > li:nth-child(3) > a");

	public   By logout = By.cssSelector("#logout");
	
	

}
