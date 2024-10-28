package Utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            // Create an instance of ExtentSparkReporter
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setDocumentTitle("Test Results");

            // Create an instance of ExtentReports and attach the Spark reporter
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Add system info or any other information you want to include
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "Taiwo Hassan");
        }
        return extent;
    }
}