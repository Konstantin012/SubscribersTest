package com.academy.demoblaze.page;

import com.academy.framework.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    private WebElement addToCard;

    public ProductPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductPage addToCard(){
        addToCard.click();
        return new ProductPage(driver);
    }

    public HomePage keepBuying(){
        selectHomePage();
        return new HomePage(driver);
    }



}
