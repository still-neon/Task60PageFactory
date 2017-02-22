import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class LogIn {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://mail.ru");
    }

    @Test
    public void login() {
        WebElement username = driver.findElement(By.cssSelector("#mailbox__login"));
        WebElement password = driver.findElement(By.cssSelector("#mailbox__password"));
        WebElement enter = driver.findElement(By.cssSelector("#mailbox__auth__button"));

        username.sendKeys("seleniumtests10@mail.ru");
        password.sendKeys("060788avavav");
        enter.click();

        WebElement exit = driver.findElement(By.cssSelector("#PH_logoutLink"));
        assertEquals(exit.getText(),"выход");
    }

    @Test
    public void logout() {
        WebElement exit = driver.findElement(By.cssSelector("#PH_logoutLink"));

        exit.click();

        WebElement enter = driver.findElement(By.cssSelector("#mailbox__auth__button"));
        assertEquals(enter.getAttribute("value"),"Войти");
    }

    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}