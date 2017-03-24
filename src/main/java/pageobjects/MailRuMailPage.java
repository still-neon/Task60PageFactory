package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailRuMailPage {
    @FindBy(id = "PH_logoutLink")
    private WebElement exitLink;
    @FindBy(id = "PH_authLink")
    private WebElement enterLink;
    private WebDriver driver;
    private WebElement myDynamicElement;

    public MailRuMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MailRuLoginPage logout() {
        exitLink.click();
        myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(enterLink));
        return new MailRuLoginPage(driver);
    }

    public String getExitValue() {
        return exitLink.getText();
    }
}