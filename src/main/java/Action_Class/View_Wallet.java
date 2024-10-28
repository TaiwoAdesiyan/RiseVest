package Action_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class View_Wallet {
    WebDriver driver;
    //enter username
    By username = By.id("email");
    //enter password
    By password = By.id("password");
    //user clicks sign in button
    By login = By.xpath("//button[normalize-space()='Sign In']");
    //user click a menu to get notification
    By notifi = By.xpath("/html/body/div[5]/div[3]/div/div[2]/button");
    //user click on a menu to got notice
    By notice = By.xpath("/html/body/div[5]/div[3]/div/div[2]/button");
    //user clicks on wallet menu
    By wallet = By.xpath("//body/div[@id='root']/div[1]/div[1]/a[3]");
    //user click on a menu to view wallet balance
  By walletBal = By.xpath("//button[@class='text-primary']//*[name()='svg']");
    // user checks if wallet balance is display successfully
    By walletDis = By.xpath("//p[contains(text(),'$0.00')]");

    //add constructor to inorder to initialize the web element
    public View_Wallet(WebDriver driver)
    {
        this.driver=driver;
    }
    //validate login
    public void setLogin()
    {
        driver.findElement(username).sendKeys("adesiyantaye@gmail.com");
        driver.findElement(password).sendKeys("Omolola1!");
        driver.findElement(login).click();
    }
    // Validate that user can view wallet successfully
    public void viewWallet () throws InterruptedException {
        driver.findElement(notifi).click();
        driver.findElement(notice).click();
        driver.findElement(wallet).click();

    }
    // Validate wallet balance is display
    public boolean disWallet()
    {
        driver.findElement(walletDis).isDisplayed();
        System.out.println("check if wallet balance is displayed"+walletDis);
        return false;
    }


}
