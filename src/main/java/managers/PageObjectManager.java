package managers;

import PageObjects.AdminPage;
import PageObjects.HomePage;
import PageObjects.UsersPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

        private WebDriver driver;
        private HomePage homePage;
        private UsersPage UsersPage;
        private AdminPage AdminPage;


    public PageObjectManager(WebDriver driver)
        {
            this.driver = driver;
        }

        public HomePage getHomePage()
        {
            return (homePage == null) ? homePage = new HomePage(driver) : homePage;
        }

        public AdminPage getAdminPage()
        {
            return (AdminPage ==null) ? AdminPage = new AdminPage(driver) : AdminPage;
        }

        public UsersPage getUsersPage()
        {
            return (UsersPage == null) ? UsersPage = new UsersPage(driver) : UsersPage;
        }
}
