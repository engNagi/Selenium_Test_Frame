package managers;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.*;

public class WebDriversManager
{

        private WebDriver driver;
        private static DriverType driverType;
        private static EnvironmentType environmentType;

        public WebDriversManager()
        {
            driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
            environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
        }

        public WebDriver getDriver()
        {
            if(driver == null) driver = createDriver();
            return driver;
        }

        private WebDriver createDriver()
        {
            switch (environmentType)
            {
                case LOCAL : driver = createLocalDriver();
                    break;
                case REMOTE : driver = createRemoteDriver();
                    break;
            }
            return driver;
        }

        private WebDriver createRemoteDriver()
        {
            throw new RuntimeException("RemoteWebDriver is not yet implemented");
        }

        private WebDriver createLocalDriver()
        {
            switch (driverType)
            {
                case FIREFOX :
                    WebDriverManager.getInstance(FIREFOX).setup();
                     driver = new FirefoxDriver();
                    break;
                case CHROME :
                    WebDriverManager.getInstance(CHROME).setup();
                     driver = new ChromeDriver();
                    break;
                case OPERA :
                    WebDriverManager.getInstance(OPERA).setup();
                    driver = new OperaDriver();
                    break;
            }

            if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
            return driver;
        }

        public void closeDriver()
        {
            driver.close();
            driver.quit();
        }

    }

