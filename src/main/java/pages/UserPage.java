package pages;

import com.beust.ah.A;
import driver.Driver;
import entity.DataFromUserTable;
import entity.User;
import helper.AlertHelper;
import helper.FakeDataHelper;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserPage extends BasePage {

    User fakeUser;
    DataFromUserTable addUserData;

    @FindBy(xpath = "//div[@class='btn-group']/a[@class='btn btn-primary']")
    public WebElement addUserBtn;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement fieldFirstName;
    @FindBy(xpath = "//input[@name='surname']")
    public WebElement fieldLastName;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement fieldEmailAddress;
    @FindBy(xpath = "//input[@name='login']")
    public WebElement fieldUsername;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement fieldPassword;
    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement fieldBio;
    @FindBy(xpath = "//input[@name='submit_personal_details']")
    public WebElement saveUserInTableBtn;
    @FindBy(xpath = "//td[@class=' tl-align-left']")
    public List<WebElement> userNameCells;
    @FindBy(xpath = "//td[@class=' tl-align-left hidden-phone']/span")
    public List<WebElement> userEmailAndUserTypeCells;
    @FindBy(xpath = "//div[@class='tl-table-operations-trigger touchable']")
    public List<WebElement> iconOption;
    @FindBy(xpath = "//div[@class='tl-table-operations touchable']/i[@class='icon-remove icon-grid']")
    public List<WebElement> removeUserBtn;
    @FindBy(xpath = "//a[@class='btn btn-danger']/i[@class='icon-trash']")
    public WebElement removeConfirmBtn;

    public void addUserInTable() {
        fakeUser = FakeDataHelper.createNewUserWithFakerData();
        String userFirstName = fakeUser.getFirstname();
        String userLastName = fakeUser.getLastname();
        String email = fakeUser.getEmailAddress();
        String userType = "Learner-Type";

        addUserData = new DataFromUserTable(userFirstName.charAt(0) + ". " + userLastName, email, userType);
        webElementHelper.click(addUserBtn)
                .sendKeys(fieldFirstName, userFirstName)
                .sendKeys(fieldLastName, userLastName)
                .sendKeys(fieldEmailAddress, email)
                .sendKeys(fieldUsername, fakeUser.getUsername())
                .sendKeys(fieldPassword, fakeUser.getUsername() + "1234W")
                .sendKeys(fieldBio, fakeUser.getBio())
                .click(saveUserInTableBtn);
    }

    public boolean checkUserInTable() {
        for(DataFromUserTable dataFromUserTable : getUderDataFromTable()){
            if(dataFromUserTable.equals(addUserData)){
                return true;
            }
        }
        return false;
    }

    public List<DataFromUserTable> getUderDataFromTable(){
        List<DataFromUserTable> dataFromUserTable = new ArrayList<>();
        DataFromUserTable userData = new DataFromUserTable();

        for(int i = 0; i < userNameCells.size(); i++){
            userData.setUserName(userNameCells.get(i).getText());
            userData.setEmail(userEmailAndUserTypeCells.get(i * 2).getText());
            userData.setUserType(userEmailAndUserTypeCells.get(i * 2 + 1).getText());

            dataFromUserTable.add(userData);
        }
        return dataFromUserTable;
    }

    public int findIndexUserInTable() {
        int step = 0;
            for(DataFromUserTable dataFromUserTable : getUderDataFromTable()){
                if(dataFromUserTable.equals(addUserData)){
                    return step;
                }
                step++;
            }
            return 0;
    }

    public void removeUser(){
                webElementHelper.moveToElement(iconOption.get(findIndexUserInTable()))
                        .click(removeUserBtn.get(findIndexUserInTable()))
                        .click(removeConfirmBtn);
    }
}
