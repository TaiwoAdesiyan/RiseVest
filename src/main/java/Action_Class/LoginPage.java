package Action_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LoginPage {

    // WebDriver instance - initialized via constructor
    private WebDriver driver;

    // Locators - encapsulated and kept private
    private By username = By.id("email");
    private By password = By.id("password");
    private By loginButton = By.xpath("//button[normalize-space()='Sign In']");
    private By loginGreeting = By.xpath("//p[@data-test-id='greeting']");
    private By invalidCredentials = By.xpath("//div[text()='Invalid email or password.']");

    // Constructor to initialize WebDriver instance
    public LoginPage(WebDriver driver) {
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

    private void enterUsername(String userName) {
        WebElement usernameField = waitForElementToBeVisible(username);
        usernameField.clear(); // Clear the field before entering text
        usernameField.sendKeys(userName);
    }

    private void enterPassword(String passWord) {
        WebElement passwordField = waitForElementToBeVisible(password);
        passwordField.clear(); // Clear the field before entering text
        passwordField.sendKeys(passWord);
    }

    private void clickLoginButton() {
        WebElement loginBtn = waitForElementToBeVisible(loginButton);
        loginBtn.click();
    }

    public boolean isLoginButtonDisplayed() {
        return waitForElementToBeVisible(loginButton).isDisplayed();
    }

    public boolean succesfullLogin() {
        return waitForElementToBeVisible(loginGreeting).isDisplayed();
    }

    public boolean invalidCredentialsValidation() {
        return waitForElementToBeVisible(invalidCredentials).isDisplayed();
    }

    public void login(String userName, String passWord) {
        enterUsername(userName);
        enterPassword(passWord);
        clickLoginButton();
    }
}
