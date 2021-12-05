package suite;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.checkout;
import pages.login;
import pages.productPage;

public class case3 extends TestBase {

    login obj_login;
    productPage obj_productPage;
    checkout obj_checkout;

    @Test(priority=1, description = "Hepsiburada Case3")
    public void open_url() {

        log.info("Open Hepsiburada Login URL.");
        driver.get(data.getProperty("base.url"));

        log.info("Get input username from properties file and put it into the textbox.");
        obj_login = new login(driver);
        obj_login.enterUsername(data.getProperty("user.username"));

        log.info("Press Enter");
        obj_login.pressEnter();

        log.info("Get input password from properties file and put it into the textbox.");
        wait.until(ExpectedConditions.visibilityOf(obj_login.txtPassword));
        obj_login.enterPassword(data.getProperty("user.password"));
        obj_login.pressEnter();

        log.info("Go to product page and add to cart.");
        obj_productPage = new productPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated((new By.ByCssSelector("input.desktopOldAutosuggestTheme-input"))));
        driver.get(data.getProperty("case3.BookUrl"));
        wait.until(ExpectedConditions.visibilityOf(obj_productPage.addToCart));
        obj_productPage.ClickAddToCart();

        log.info("Go to checkout page and click continue.");
        obj_checkout = new checkout(driver);
        driver.get(data.getProperty("case3.CheckoutUrl"));
        wait.until(ExpectedConditions.visibilityOf(obj_checkout.continueBtn));
        obj_checkout.clickContinue();
        obj_checkout.clickContinue();

        log.info("Control url is same");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("payment-methods"))));
        String currentUrl=  driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,data.getProperty("case3.OdemeUrl"));

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("payment-methods"))));
        WebElement instantRemit=driver.findElement(
                new By.ByCssSelector("div.sardesPaymentPage-Accordion-wrapper>div.sardesPaymentPage-Accordion-accordion_tab:nth-child(2)"));
        instantRemit.click();

        WebElement bank = driver.findElement(new By.ByCssSelector("div.sardesPaymentPage-Accordion-accordion_tab:nth-child(2)"));
        bank.findElement(new By.ByName("typepayment-money-transfer")).click();

        String banknameBefore = bank.findElement(new By.ByCssSelector("p.sardesPaymentPage-MoneyTransfer-bank_name")).getText();

        obj_checkout.clickContinue();

        wait.until(ExpectedConditions.visibilityOfElementLocated((new By.ByCssSelector("section.payment_summary_1yhmB"))));

        String banknameAfter = driver.findElement(new By.ByCssSelector("div.detail_20j8y>span:last-child")).getText();

        Assert.assertEquals(banknameBefore,banknameAfter);

        log.info("Test end");
    }

}
