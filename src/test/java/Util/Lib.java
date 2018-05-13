package Util;

import cucumber.api.java.sk.Tak;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Lib {

    public static String getTitle(WebDriver driver) {
        String title = driver.getTitle();
        return title;
    }

    public static WebElement findElem(WebDriver driver, String xpath) {
        WebElement elem = driver.findElement(By.xpath(xpath));
        return elem;
    }

    public static String readProperty(String key) throws IOException {
        File file = new File("D:\\Google Drive\\PIIT\\IntellijCodes\\CNNBDD\\src\\Resources\\locator.properties");
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        String locator = prop.getProperty(key);
        return locator;
    }

    public static void takeScreenshot(WebDriver driver, String name) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D:\\Google Drive\\PIIT\\IntellijCodes\\CNNBDD\\cnn" + name + ".png"));
    }
}
