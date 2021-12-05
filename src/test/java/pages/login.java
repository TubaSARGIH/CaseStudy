package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class login extends PageBase {
    public login(WebDriver driver) {
        super(driver);
    }

    WebDriver driver;
    // Web Element for Username
    @FindBy(id = "txtUserName")
    WebElement userName;

    // Web Element for Password
    @FindBy(id = "txtPassword")
    public WebElement txtPassword;

    // Web Element for Login Button
    @FindBy(id = "btnLogin")
    WebElement btnLogin;

    public void clickLoginButton(){
        log.info("Click login button");
        btnLogin.click();
    }

    public void enterUsername(String username){
        log.info("username: "+username);
        userName.sendKeys(username);
    }

    public void enterPassword(String password){
        log.info("enter pass");
        txtPassword.sendKeys(password);
    }

}
