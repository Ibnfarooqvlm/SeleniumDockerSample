package sample;

import com.utilities.BaseFunctions;
import com.utilities.TLDriverFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class ARCFirefox extends BaseFunctions {

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        if(Main.isDocker){
            getProperties().setProperty(TLDriverFactory.BROWSER,TLDriverFactory.FIREFOX_DOCKER);
        }else{
            getProperties().setProperty(TLDriverFactory.BROWSER,TLDriverFactory.FIREFOX);
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        launchURL("DMS");
        String strUsername = getProperties().getProperty("USERNAME");
        String strPassword = getProperties().getProperty("PASSWORD");
        new LoginPage().doLogin(strUsername,strPassword);
    }

    @Test(enabled = true)
    public void arcFirefoxDemo(){
        try {
            HomePage homePage = new HomePage();
            homePage.showDealership();
            homePage.showUserInfo();
        }catch(Throwable t){
            logException(t);
        }
    }
}
