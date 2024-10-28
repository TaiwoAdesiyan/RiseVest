package RiseVest_Test;

import Action_Class.LoginPage;
import Action_Class.WalletPage;
import Base_Class.BaseClass;
import Utils.ReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WalletBalance extends BaseClass {

    LoginPage lp;
    WalletPage sh;
    ExtentReports report;
    ExtentTest test;

    @BeforeMethod
    public void setUpPage() {
        lp = new LoginPage(getDriver());
        sh = new WalletPage(getDriver());
        report = ReportManager.getReportInstance();
    }

    @Test(priority = 0)
    public void user_can_hide_wallet_balance() throws InterruptedException {
        test = report.createTest("Hide Wallet Balance Test");

        try {
            // Step 1: Log in with valid credentials
            lp.login("adesiyantaye@gmail.com", "Omolola1!");
            test.info("Logged in with valid credentials.");

            // Step 2: Accept notifications
            sh.acceptNotification();
            test.info("Accepted notification.");

            // Step 3: Validate successful login
            lp.succesfullLogin();
            test.info("Login successful.");

            // Step 4: Click on the Wallet Menu
            sh.clickWalletMenu();
            test.info("Clicked on Wallet Menu.");

            // Step 5: Toggle the wallet balance to hide then view
//            sh.toggleWalletBalance();
//            test.info("Toggled wallet balance to hide.");
            sh.toggleWalletBalance();
            test.info("Toggled wallet balance to hide.");
            sh.toggleWalletBalance();
            test.info("Toggled wallet balance to view.");

            // Step 6: Check that the wallet balance is hidden
            sh.walletBalanceDisplayFlag("NO");
            test.pass("User successfully hid the wallet balance.");
        } catch (Exception e) {
            test.fail("Failed to hide wallet balance: " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void user_can_view_wallet_balance() throws InterruptedException {
        test = report.createTest("View Wallet Balance Test");

        try {
            // Step 1: Log in with valid credentials
            lp.login("adesiyantaye@gmail.com", "Omolola1!");
            test.info("Logged in with valid credentials.");

            // Step 2: Accept notifications
            sh.acceptNotification();
            test.info("Accepted notification.");

            // Step 3: Validate successful login
            lp.succesfullLogin();
            test.info("Login successful.");

            // Step 4: Click on the Wallet Menu
            sh.clickWalletMenu();
            test.info("Clicked on Wallet Menu.");

            // Step 5: Toggle the wallet balance to view
            sh.toggleWalletBalance();
            test.info("Toggled wallet balance to view.");

            // Step 6: Check that the wallet balance is visible
            sh.walletBalanceDisplayFlag("YES");
            test.pass("User successfully viewed the wallet balance.");
        } catch (Exception e) {
            test.fail("Failed to view wallet balance: " + e.getMessage());
        }
    }
}
