package uiTest;

import driver.Driver;
import helper.BrowserManager;
import helper.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import pages.accountAndSettings.AccountUsersPage;
import pages.accountAndSettings.BasicSettingsPage;
import pages.accountAndSettings.ThemesPage;
import pages.accountAndSettings.CertificatesPage;
import pages.accountAndSettings.EcommercePage;
import pages.accountAndSettings.DomainPage;
import pages.accountAndSettings.SubscriptionPage;
import pages.accountAndSettings.gamification.GamificationPage;
import pages.accountAndSettings.gamification.PointsBox;
import pages.accountAndSettings.gamification.BadgesBox;
import pages.accountAndSettings.gamification.LevelsBox;
import pages.accountAndSettings.gamification.RewardsBox;
import pages.accountAndSettings.gamification.LeaderboardBox;
import pages.categories.DeleteCategory;
import pages.categories.DownloadCategoriesInfo;
import pages.categories.EditTheCategories;
import pages.categories.ViewCourseCatalog;
import pages.categories.CategoriesPage;
import pages.courses.CoursesPage;
import pages.users.UsersPage;
import pages.reports.ReportsPage;
import pages.reports.TrainingMatrixPage;
import pages.reports.ReportsIconAndLinkPage;
import pages.reports.CoursesUnderReportsPage;
import pages.reports.UsersUnderReportsPage;

import java.util.List;

import static pages.TalentLMS_PAGES.LOGIN;

public class BaseTest {

    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    protected BrowserManager browserManager;
    protected BrowserManager.WindowHelper windowHelper;
    protected BrowserManager.FrameHelper frameHelper;
    protected LoginPage loginPage;
    protected BasicSettingsPage basicSettingsPage;
    protected AccountUsersPage accountUsersPage;
    protected ThemesPage themesPage;
    protected CertificatesPage certificatesPage;
    protected EcommercePage ecommercePage;
    protected DomainPage domainPage;
    protected SubscriptionPage subscriptionPage;
    protected GamificationPage gamificationPage;
    protected PointsBox pointsBox;
    protected BadgesBox badgesBox;
    protected LevelsBox levelsBox;
    protected RewardsBox rewardsBox;
    protected LeaderboardBox leaderboardBox;
    protected UsersPage usersPage;
    protected CategoriesPage categoriesPage;
    protected EditTheCategories editTheCategories;
    protected DeleteCategory deleteCategory;
    protected DownloadCategoriesInfo downloadCategoriesInfo;
    protected ViewCourseCatalog viewCourseCatalog;
    protected CoursesPage coursesPage;
    protected ReportsPage reportsPage;
    protected TrainingMatrixPage trainingMatrixPage;
    protected UserTypesPage userTypesPage;
    protected List<String> listUserTypes;
    protected ReportsIconAndLinkPage reportsIconAndLinkPage;
    protected CoursesUnderReportsPage coursesUnderReportsPage;
    protected UsersUnderReportsPage usersUnderReportsPage;
    protected AddUserTypePage addUserTypePage;
    protected ExportPage exportPage;

    protected UserPage userPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = Driver.getDriver();
        webElementHelper = new WebElementHelper();
        browserManager = new BrowserManager(driver);
        windowHelper = new BrowserManager.WindowHelper(driver);
        frameHelper = new BrowserManager.FrameHelper(driver);
        loginPage = new LoginPage();
        usersPage = new UsersPage();
        basicSettingsPage = new BasicSettingsPage();
        accountUsersPage = new AccountUsersPage();
        themesPage = new ThemesPage();
        certificatesPage = new CertificatesPage();
        ecommercePage = new EcommercePage();
        domainPage = new DomainPage();
        subscriptionPage = new SubscriptionPage();
        gamificationPage = new GamificationPage();
        pointsBox =  new PointsBox();
        badgesBox = new BadgesBox();
        levelsBox = new LevelsBox();
        rewardsBox = new RewardsBox();
        leaderboardBox = new LeaderboardBox();
        categoriesPage = new CategoriesPage();
        editTheCategories = new EditTheCategories();
        deleteCategory = new DeleteCategory();
        downloadCategoriesInfo = new DownloadCategoriesInfo();
        viewCourseCatalog = new ViewCourseCatalog();
        coursesPage = new CoursesPage();
        reportsPage = new ReportsPage();
        trainingMatrixPage = new TrainingMatrixPage();
        userTypesPage = new UserTypesPage();
        reportsIconAndLinkPage = new ReportsIconAndLinkPage();
        coursesUnderReportsPage = new CoursesUnderReportsPage();
        usersUnderReportsPage = new UsersUnderReportsPage();
        addUserTypePage = new AddUserTypePage();
        exportPage = new ExportPage();
        userPage = new UserPage();
        browserManager.openByNavigate(LOGIN.toString());
        loginPage.doLogin();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
//        Driver.closeDriver();
    }
}