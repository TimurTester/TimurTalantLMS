package uiTest;

import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static pages.TalentLMS_PAGES.USER_PAGE;

public class UserTest extends BaseTest {

    @Test
    @Feature("talentLMS User Types")
    @Description("Checking when adding user type it must be unique")
    @Owner("Timur")
    @Severity(SeverityLevel.CRITICAL)
    @Story("TL-014")
    @Tag("Negative")
    public void addUserInTableTest(){
        browserManager.openByNavigate(USER_PAGE.toString());
        userPage.addUserInTable();
            browserManager.openByNavigate(USER_PAGE.toString());
        System.out.println(userPage.checkUserInTable());
        browserManager.openByNavigate(USER_PAGE.toString());
        /*userPage.addUserInTable();
        browserManager.openByNavigate(USER_PAGE.toString());
        userPage.addUserInTable();
        browserManager.openByNavigate(USER_PAGE.toString());*/
       // userPage.removeUser();
        /*userPage.removeUser();
        userPage.removeUser();*/
    }
}
