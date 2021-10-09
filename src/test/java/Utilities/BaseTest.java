package Utilities;

import org.testng.Assert;

import java.util.Properties;

public class BaseTest {
    protected String url;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String pswd;
    protected String pswdconfirm;

    public BaseTest() {
        readProperties();
    }

    public void readProperties() {


        try {
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            this.url = (String) properties.get("url");
            this.firstName = (String) properties.get("firstName");
            this.lastName = (String) properties.get("lastName");
            this.email = (String) properties.get("email");
            this.pswd = (String) properties.get("pswd");
            this.pswdconfirm = (String) properties.get("pswdconfirm");


        } catch (Exception e) {
            Assert.fail("Config.properties file not found");
        }
    }
}
