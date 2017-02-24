package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;

public class MailRuLoginPage {

    @FindBy(id = "mailbox__login")
    private WebElement login;
    @FindBy(id = "mailbox__password")
    private WebElement password;
    @FindBy(id = "mailbox__auth__button")
    private WebElement enterButton;
    @FindBy(id = "PH_authLink")
    private WebElement enterLink;
    private WebDriver driver;
    private String url = "http://mail.ru";

    public MailRuLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }

    public MailRuMailPage login(String login, String password) {
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        enterButton.click();
        return new MailRuMailPage(driver);
    }

    public void checkEnter(String enterLink) {
        assertEquals(this.enterLink.getText(), enterLink);
    }
}