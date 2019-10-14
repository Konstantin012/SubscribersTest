package com.academy.project;

import com.academy.project.subscribers.Subscriber;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.Properties;
import java.sql.*;


import static io.restassured.RestAssured.given;

public class RestTest {
    private Properties subscriberProperty;
    private String name;
    private String id;
    private static final String DEFAULT_PATH = "src/main/resources/subscriber.properties";

    @BeforeClass
    public void setUp() throws Exception{
        String subscriberData = System.getProperty("subscriber");
        if (subscriberData==null)
            subscriberData = DEFAULT_PATH;
        subscriberProperty = new Properties();

        subscriberProperty.load(new FileReader(subscriberData));
        name = subscriberProperty.getProperty("name");

        RestAssured.baseURI = "http://localhost:8081/rest/json/";
        RestAssured.port = 8081;
    }

    @Test()
    public void testDelete() {
        dataBaseRead();
        given().log().all()
                .delete("/subscribers/{id}", id)
                .then().assertThat()
                .statusCode(200);
    }

    @DataProvider
    public Object[][] subscriberProvider() {
        return new Object[][] {
                {new Subscriber().name = "Konstantin"}
        };
    }

    public void dataBaseRead() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile?user=root&password=root&serverTimezone=UTC&useSSL=false");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM subscriber");
            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                if(first_name.equals(name)) {
                    Statement statement1 = connection.createStatement();
                    ResultSet resultSet1 = statement1.executeQuery("SELECT id FROM subscriber where first_name='"+name+"'");
                    while (resultSet1.next()){
                        id = resultSet1.getString("id");
                    }

                    resultSet1.close();
                }
            }

            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }



    }
}
