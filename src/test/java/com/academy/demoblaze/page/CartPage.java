package com.academy.demoblaze.page;

import com.academy.framework.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//h3[@id='totalp']")
    private WebElement totalPrice;

    @FindBy(xpath = "(//a[@href='#'][normalize-space()='Delete'])[1]")
    private WebElement deleteButton;


    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void DeleteAllItems(){
        while (tryFindElement(By.xpath("(//a[@href='#'][normalize-space()='Delete'])[1]"))){
            deleteButton.click();
        }
    }

    public String getTotalPrice(){
        return totalPrice.getText();
    }
}
