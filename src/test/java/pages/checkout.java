package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkout extends PageBase {
    public checkout(WebDriver driver) {
        super(driver);
    }

    WebDriver driver;

    // Web Element for continueBtn
    @FindBy(id = "continue_step_btn")
    public WebElement continueBtn;

    public void clickContinue()
    {
        log.info("Click continue button");
        continueBtn.click();
    }

}
