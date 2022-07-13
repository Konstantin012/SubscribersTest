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


    @FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
    private WebElement phoneSamsung;
    @FindBy(xpath = "//a[normalize-space()='HTC One M9']")
    private WebElement phoneHtcOneM9;



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
        if (model.contains("Samsung")){
            phoneSamsung.click();
        }
        if (model.contains("HTC")){
            phoneHtcOneM9.click();
        }
        return new ProductPage(driver);
    }

    public CartPage goToCartPage(){
        selectCartPage();
        return new CartPage(driver);
    }




//    //CHECKING
//    public HomePage checAcountName(String name) {
//        checkTextFromLocator(ownAccount, name);
//        return this;
//    }





}
