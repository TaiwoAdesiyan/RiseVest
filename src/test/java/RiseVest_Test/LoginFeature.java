package RiseVest_Test;

import Action_Class.LoginPage;
import Base_Class.BaseClass;
import Utils.ReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFeature extends BaseClass {

    LoginPage lp;
    ExtentReports report;
    ExtentTest test;

    @BeforeMethod
    public void setUpPage() {
        lp = new LoginPage(getDriver());
        report = ReportManager.getReportInstance();
    }

    @Test
    public void user_can_login_with_valid_credentials() throws InterruptedException {
        test = report.createTest("Login with Valid Credentials Test");

        // Step 1: Perform login
        test.info("Attempting to log in with valid credentials.");
        lp.login("adesiyantaye@gmail.com", "Omolola1!");
        test.info("Entered username and password.");

        // Step 2: Validate successful login
        lp.succesfullLogin();
        test.pass("User successfully logged in with valid credentials.");
    }

    @Test
    public void user_can_not_login_with_invalid_credentials() throws InterruptedException {
        test = report.createTest("Login with Invalid Credentials Test");

        // Step 1: Perform login with invalid credentials
        test.info("Attempting to log in with invalid credentials.");
        lp.login("adesiyantaye@gmail.com", "taiwo2024");
        test.info("Entered username and invalid password.");

        // Step 2: Validate error message
        lp.invalidCredentialsValidation();
        test.pass("Invalid credentials validation displayed correctly.");
    }

}
