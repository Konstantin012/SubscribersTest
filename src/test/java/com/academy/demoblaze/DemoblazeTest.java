package com.academy.demoblaze;

import com.academy.demoblaze.listener.TestListener;
import com.academy.demoblaze.page.CartPage;
import com.academy.framework.test.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.Properties;

import static com.academy.demoblaze.page.HomePage.startFromHome;


@Listeners(TestListener.class)
public class DemoblazeTest extends BaseTest {
    private static final String DEFAULT_PATH = "src/main/resources/propertDemo.properties";
    private String homeUrl;
    private Properties propertDemo;


    @BeforeClass(alwaysRun = false)
    public void setUp() throws Exception {
        String automationPath = System.getProperty("propertDemo");
        if (automationPath == null)
            automationPath = DEFAULT_PATH;
        propertDemo = new Properties();
        propertDemo.load(new FileReader(automationPath));
        homeUrl = propertDemo.getProperty("homeUrl");
    }


    @Test(enabled = true, dataProvider = "demoblazeTestProvider")
    public void testCase(String hTCOneM9, String samsungGalaxyS6) {
        CartPage cartPage = startFromHome(driver, homeUrl).
                selectPhone(hTCOneM9).
                addToCard().
                keepBuying().
                selectPhone(samsungGalaxyS6).
                addToCard().
                keepBuying().
                goToCartPage();
        String totalPrice = cartPage.getTotalPrice();
        cartPage.DeleteAllItems();

    }


    //DATA PROVIDERS
    @DataProvider(name = "demoblazeTestProvider")
    public Object[][] demoblazeTestProvider() {
        String samsungGalaxyS6 = "Samsung galaxy s6";
        String hTCOneM9 = "HTC One M9";
        return new Object[][]{
                {samsungGalaxyS6, hTCOneM9}
        };
    }
}

