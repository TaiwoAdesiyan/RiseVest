package RiseVest_Test;

import Action_Class.LoginPage;
import Action_Class.WalletPage;
import Action_Class.PlanManagement;
import Base_Class.BaseClass;
import Utils.ReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatePlanFeature extends BaseClass {

    LoginPage lp;
    WalletPage sh;
    PlanManagement cp;
    ExtentReports report;
    ExtentTest test;

    @BeforeMethod
    public void setUpPage() {
        lp = new LoginPage(getDriver());
        sh = new WalletPage(getDriver());
        cp = new PlanManagement();
        report = ReportManager.getReportInstance();
    }

    @Test
    public void CreatePlan() throws InterruptedException {
        test = report.createTest("Create Investment Plan Test"); // Create a new test in the report

        try {
            // Step 1: Login with valid credentials
            lp.login("adesiyantaye@gmail.com", "Omolola1!");
            test.info("Step 1: Logged in with valid credentials.");

            // Step 2: Accept notification
            sh.acceptNotification();
            test.info("Step 2: Accepted notification.");

            // Step 3: Validate successful login
            lp.succesfullLogin();
            test.info("Step 3: Login successful.");

            // Step 4: Create investment plan
            cp.createInvestmentPlan();
            test.info("Step 4: Navigated to create investment plan.");

            // Step 5: Select currency and input plan details
            cp.selectCurrencyAndInputPlanDetails("T_gift");
            test.info("Step 5: Selected currency and input plan details.");

            // Step 6: Add income and savings
            cp.addIncomeAndSavings("30000", "35");
            test.info("Step 6: Added income and savings.");

            // Step 7: Set retirement age
            cp.setRetirementAge("45");
            test.info("Step 7: Set retirement age.");

            // Step 8: Select investment preference
            cp.selectInvestmentPreference();
            test.info("Step 8: Selected investment preference.");

            // Step 9: Agree and create the plan
            cp.agreeAndCreatePlan();
            test.pass("Investment plan created successfully.");
        } catch (Exception e) {
            test.fail("Failed to create investment plan: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        report.flush(); // Generate the report after each test execution
    }
}
