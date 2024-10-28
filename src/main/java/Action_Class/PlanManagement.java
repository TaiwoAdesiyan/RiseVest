package Action_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class PlanManagement {

        private WebDriver driver;
        // Locators - encapsulated and kept private
        private By investPlanButton = By.xpath("//p[@class='mt-2 text-center font-bold text-sm text-black']");
        private By startPlanButton = By.xpath("//p[@class='mt-4 underline']");
        private By startInvestingButton = By.xpath("//button[normalize-space()='Start Investing']");
        private By nairaCurrencyOption = By.xpath("//body/div[@id='root']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]");
        private By planNameField = By.xpath("//input[@id='name']");
        private By continueButton = By.xpath("//button[normalize-space()='Continue']");
        private By monthlyIncomeField = By.xpath("//input[@id='name']");
        private By savingsField = By.xpath("//input[@id='mui-1']");
        private By retirementAgeField = By.xpath("//*[@id='mui-2']");
        private By stabilityOption = By.xpath("//input[@value='0.5']");
        private By distributionContinueButton = By.xpath("//button[normalize-space()='Continue']");
        private By agreeAndContinueButton = By.xpath("//button[normalize-space()='Agree & Continue']");
        private By createPlanButton = By.xpath("//button[normalize-space()='Create Plan']");

    // Fluent Wait method to wait for an element to be visible
        private WebElement waitForElementToBeVisible(By locator) {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30)) // Maximum wait time
                    .pollingEvery(Duration.ofSeconds(2)) // Poll every 2 seconds
                    .ignoring(Exception.class); // Ignore exceptions to continue waiting

            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        // Create a new investment plan
        public void createInvestmentPlan() {
            waitForElementToBeVisible(investPlanButton).click();
            waitForElementToBeVisible(startPlanButton).click();
            waitForElementToBeVisible(startInvestingButton).click();
        }

        // Select Naira as currency and input plan name
        public void selectCurrencyAndInputPlanDetails(String planName) {
            waitForElementToBeVisible(nairaCurrencyOption).click();
            waitForElementToBeVisible(planNameField).sendKeys(planName);
            waitForElementToBeVisible(continueButton).click();
        }

        // Add monthly income and savings details
        public void addIncomeAndSavings(String monthlyIncome, String savingsPercentage) {
            waitForElementToBeVisible(monthlyIncomeField).sendKeys(monthlyIncome);
            waitForElementToBeVisible(continueButton).click();
            waitForElementToBeVisible(savingsField).sendKeys(savingsPercentage);
            waitForElementToBeVisible(continueButton).click();
        }

        // Set retirement age
        public void setRetirementAge(String age) {
            waitForElementToBeVisible(retirementAgeField).sendKeys(age);
            waitForElementToBeVisible(continueButton).click();
        }

        // Select Stability as investment preference
        public void selectInvestmentPreference() {
            waitForElementToBeVisible(stabilityOption).click();
            waitForElementToBeVisible(distributionContinueButton).click();
        }

        // Agree to terms and finalize plan
        public void agreeAndCreatePlan() {
            waitForElementToBeVisible(agreeAndContinueButton).click();
            waitForElementToBeVisible(createPlanButton).click();
        }
    }




