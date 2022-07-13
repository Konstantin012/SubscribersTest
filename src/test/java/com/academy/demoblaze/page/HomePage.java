package com.academy.demoblaze.page;

import com.academy.framework.page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    Actions actions = new Actions(driver);

    private static final String test ="//a[normalize-space()=";
    private WebElement phoneSamsung;




    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static HomePage startFromHome(WebDriver driver, String baseUrl){
        driver.get(baseUrl);
        return new HomePage(driver);
    }

    public ProductPage selectPhone(String model){
        var df = test+model;
        phoneSamsung.findElement(By.xpath(test+model)).click();
        return new ProductPage(driver);
    }

    public CartPage goToCartPage(){
        selectHomePage();
        return new CartPage(driver);
    }




//    //CHECKING
//    public HomePage checAcountName(String name) {
//        checkTextFromLocator(ownAccount, name);
//        return this;
//    }





}
