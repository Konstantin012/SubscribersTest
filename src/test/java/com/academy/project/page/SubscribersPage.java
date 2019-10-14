package com.academy.project.page;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


import static com.codeborne.selenide.Selenide.page;

public class SubscribersPage {

    @FindBy(id = "add")
    private SelenideElement addNewSubscriber;

    public AddPage addNewSubscriber(){
        addNewSubscriber.click();
        return page(AddPage.class);
    }
}
