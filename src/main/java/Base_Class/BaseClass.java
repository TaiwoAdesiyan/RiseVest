package Base_Class;

import Utils.ReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;

public class BaseClass {

    // WebDriver instance
    WebDriver driver;
    ExtentReports report;

    // Setup method to initialize WebDriver before each test
    @BeforeMethod
    @Parameters("browser") // This will allow TestNG to inject the 'browser' parameter
    public void setup(String browserType) {
        report = ReportManager.getReportInstance();

        // Initialize the appropriate WebDriver based on the parameter
        switch (browserType.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-web-security");
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        // Navigate to the application URL
        System.out.println("Running tests on browser: " + browserType);
        driver.get("https://app.risevest.com/");
    }

    // Tear down method to quit the WebDriver after each test
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        report.flush(); // Generate the report after the test methods
    }

    // Getter method for WebDriver instance
    public WebDriver getDriver() {
        return driver;
    }
}
