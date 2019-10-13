package com.academy.project.page;



import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {


    private static String subscribersLink="div>a";

    @FindBy(xpath = "//td")
    private SelenideElement newSubcr;


    public static SubscribersPage goToSubscribers(){
        $(byCssSelector(subscribersLink)).click();
        return page(SubscribersPage.class);
    }

    public void checkTheUserAfretAdding(String expectedName){
        $(byXpath("//*[contains(text(), "+expectedName+")]"));
    }


}
