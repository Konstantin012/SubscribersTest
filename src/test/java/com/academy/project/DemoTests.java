package com.academy.project;

import com.academy.project.subscribers.Subscriber;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.Properties;

import static com.academy.project.page.HomePage.goToSubscribers;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;


public class DemoTests {


    private Properties subscriberProperty;
    private String homeUrl;
    private static final String DEFAULT_PATH = "src/main/resources/propertDemo.properties";

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//        .screenshots(true)
//        .savePageSource(false));
        String subscriberData = System.getProperty("subscriber");
        if (subscriberData==null)
            subscriberData = DEFAULT_PATH;
        subscriberProperty = new Properties();
        subscriberProperty.load(new FileReader(subscriberData));
        homeUrl = subscriberProperty.getProperty("homeUrl");
        browser = "chrome";
        timeout =10000;
        startMaximized=true;
    }

    @Test(enabled = true,dataProvider = "testDataProvider")
    public void addNewSubscribers(Subscriber subscriber)  {
        open(homeUrl);
        goToSubscribers()
                .addNewSubscriber()
                .createSubscriber(subscriber)
                .checkTheUserAfretAdding(subscriber.name);
    }



    @DataProvider(name="testDataProvider")
    public Object[][] testDataProvider() {
        Subscriber subscriber = new Subscriber();
        subscriber.name = subscriberProperty.getProperty("name");
        subscriber.secondName = subscriberProperty.getProperty("secondName");
        subscriber.gender = subscriberProperty.getProperty("gender");
        subscriber.age = subscriberProperty.getProperty("age");
        return new Object[][] {
                {subscriber}
        };
    }


}
