import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageobjects.MailRuLoginPage;
import pageobjects.MailRuMailPage;

public class LogIn {

    private WebDriver driver;
    private String login = "seleniumtests10@mail.ru";
    private String password = "060788avavav";
    private String exitLink = "выход";
    private String enterLink = "Вход";


    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void login() {

        MailRuLoginPage mailRuLoginPage = new MailRuLoginPage(driver);

        mailRuLoginPage.load();

        MailRuMailPage mailRuMailPage = mailRuLoginPage.login(login, password);

        mailRuMailPage.checkExit(exitLink);

        mailRuMailPage.close();
    }

    @Test
    public void logout() {

        MailRuLoginPage mailRuLoginPage = new MailRuLoginPage(driver);

        mailRuLoginPage.load();

        MailRuMailPage mailRuMailPage = mailRuLoginPage.login(login, password);

        mailRuLoginPage = mailRuMailPage.logout();

        mailRuLoginPage.checkEnter(enterLink);

        mailRuLoginPage.close();
    }
}