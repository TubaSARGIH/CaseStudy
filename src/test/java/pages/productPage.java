package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productPage extends PageBase {
    public productPage(WebDriver driver) {
        super(driver);
    }

    WebDriver driver;

    // Web Element for addToCart
    @FindBy(id = "addToCart")
    public WebElement addToCart;

    public void ClickAddToCart()
    {
        log.info("Click addtocart button");
        addToCart.click();
    }


}
