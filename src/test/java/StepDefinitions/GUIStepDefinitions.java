package StepDefinitions;

import Util.Lib;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GUIStepDefinitions extends Lib {

    WebDriver driver;

    @Before
    public void initialize() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            System.out.println("Running a Mac system");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/mac/chrome");
        } else if (os.contains("windows")) {
            System.out.println("Running a Windows system");
            System.setProperty("webdriver.driver.chrome", "D:\\Google Drive\\PIIT\\IntellijCodes\\CNNBDD\\chromedriver.exe");
        } else {
            System.out.println("Running a Linux System");
        }

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.cnn.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Given("^i am on homepage$")
    public void homepage(){
        String title = getTitle(driver);
        System.out.println("Title: " + title);
    }

    @Then("^i click ustab and go back home$")
    public void usTab() throws IOException, InterruptedException {
        WebElement ustab = findElem(driver, readProperty("usTab"));
        ustab.click();
        Thread.sleep(1000);
        driver.navigate().back();
    }

    @Then("^i click worldtab and go back home$")
    public void worldTab() throws IOException, InterruptedException {
        WebElement worldtab = findElem(driver, readProperty("worldTab"));
        worldtab.click();
        Thread.sleep(1000);
        takeScreenshot(driver, "test");
        driver.navigate().back();
    }


    @After
    public void teardown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }



}
