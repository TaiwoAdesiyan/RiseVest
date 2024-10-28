package Action_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class WalletPage {
    private WebDriver driver;

    // Locators - encapsulated and kept private
    private By username = By.id("email");
    private By password = By.id("password");
    private By loginButton = By.xpath("//button[normalize-space()='Sign In']");
    private By notificationButton = By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[1]");
    private By walletMenu = By.xpath("//body/div[@id='root']/div[1]/div[1]/a[3]");
    private By walletBalanceToggle = By.xpath("//button[@class='text-primary']//*[name()='svg']");
    private By hideBalanceOption = By.xpath("//*[name()='path' and contains(@d,'M12 7c2.76')]");
    private By walletBallanceField = By.cssSelector("p.mt-3.font-tomato.text-center");

    // Constructor to initialize the WebDriver instance
    public WalletPage(WebDriver driver) {
        this.driver = driver;
    }

    // Fluent Wait method to wait for an element to be visible
    private WebElement waitForElementToBeVisible(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100)) // Maximum wait time
                .pollingEvery(Duration.ofSeconds(2)) // Poll every 2 seconds
                .ignoring(Exception.class); // Ignore exceptions to continue waiting

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Accept notification
    public void acceptNotification() {
        waitForElementToBeVisible(notificationButton).click();
        waitForElementToBeVisible(notificationButton).click(); // Assuming it clicks again for confirmation
    }
    // click wallet menu
    public void clickWalletMenu() {
        waitForElementToBeVisible(walletMenu).click();
    }

    // Hide wallet balance
    public void toggleWalletBalance() {
        waitForElementToBeVisible(walletBalanceToggle).click();
    }

    public void walletBalanceDisplayFlag(String YES_or_NO) throws InterruptedException {
        String displayedText = waitForElementToBeVisible(walletBallanceField).getText();

        if (YES_or_NO.equalsIgnoreCase("YES")) {
            Assert.assertTrue(displayedText.contains("."), "Expected balance to be visible, but it was not.");
        } else if (YES_or_NO.equalsIgnoreCase("NO")) {
            Assert.assertTrue(displayedText.contains("*"), "Expected balance to be hidden, but it was visible.");
        } else {
            throw new IllegalArgumentException("Invalid Argument Provided: Please provide 'YES' or 'NO'.");
        }
    }


}
