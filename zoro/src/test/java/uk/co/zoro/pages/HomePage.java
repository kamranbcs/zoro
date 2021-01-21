package uk.co.zoro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uk.co.zoro.drivers.DriverManager;

import java.util.List;

public class HomePage extends DriverManager {

    @FindBy(css = ".NewLoginForm_NewLogin_title__1-ZfQ")
    WebElement loginPopupTitle;

    @FindBy(css = ".visible-lg-inline")
    List<WebElement> topNav;

    @FindBy(xpath = "//label[contains(text(),'My Account')]")
    WebElement myAccountIconTxt;

    public String currentUrl()
    {
       return driver.getCurrentUrl();
    }

    public void clickTopNav(String navTxt)
    {
        for(WebElement element : topNav)
        {
            if(element.getText().equalsIgnoreCase(navTxt))
            {
                element.click();
                break;
            }
        }
    }

    public String getLoginPopupTitle()
    {
        return loginPopupTitle.getText();
    }

    public String getMyAccountIconTxt()
    {
        return myAccountIconTxt.getText();
    }
}
