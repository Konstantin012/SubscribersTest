package com.academy.project.page;

import com.academy.project.subscribers.Subscriber;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AddPage {

    @FindBy(id = "fname")
    private SelenideElement nameFiled;

    @FindBy(id = "lname")
    private SelenideElement secondNameFiled;

    @FindBy(id = "MALE")
    private SelenideElement genderMale;

    @FindBy(id = "FEMALE")
    private SelenideElement genderFemale;

    @FindBy(id = "age")
    private SelenideElement ageFiled;

    private String createSubscriberButton ="Создать";


    public HomePage createSubscriber(Subscriber data){
        nameFiled.setValue(data.name);
        secondNameFiled.setValue(data.secondName);
        if(data.name.equals("MALE")){
            genderMale.click();
        }
        if(data.name.equals("FEMALE")){
            genderFemale.click();
        }
        ageFiled.setValue(data.age);
        $(byText(createSubscriberButton)).click();
        return page(HomePage.class);
    }

}
