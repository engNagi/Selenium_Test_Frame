package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AdminPage
{

    WebDriver driver;

    public AdminPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement admin_Bar(WebDriver driver)
    {
        WebElement element = driver. findElement(By.id("wp-admin-bar-my-account"));

        return element;
    }
}
