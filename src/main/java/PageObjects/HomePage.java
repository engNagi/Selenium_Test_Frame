package PageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class HomePage
{

    WebDriver driver;
    private static WebElement element = null;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo_HomePage()

    {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public  WebElement loginButton(WebDriver driver)
    {
        WebElement element = driver.findElement(By.id("wp-submit"));
        return element;
    }

    public  WebElement txtbx_UserName (WebDriver driver)
    {
        WebElement element = driver.findElement(By.id("user_login"));
        return element;
    }

    public  WebElement txtbx_Password (WebDriver driver)
    {
        WebElement element = driver.findElement(By.id("user_pass"));
        return element;
    }

}
