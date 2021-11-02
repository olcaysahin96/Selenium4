import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class Selenium4Test extends BaseTest{

    @Test(description = "Screenshot spesific element", priority = 1)
    public void screenShot() throws IOException {
        driver.get("https://www.trendyol.com/");
        WebElement trendyolLogo = driver.findElement(By.id("logo"));
        File file = trendyolLogo.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("Trendyol_Logo.png");
        FileUtils.copyFile(file, destinationFile);
    }

    @Test(description = "New tab and new window open", priority = 2)
    public void newTabAndWindow() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.n11.com/");
    }

    @Test(description = "Location Element", priority = 3)
    public void locationElement() {
        driver.get("https://www.trendyol.com/");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"account-navigation-container\"]/div/div[1]/div[1]/p"));

        System.out.println("Element height : " + loginBtn.getRect().getDimension().getHeight());
        System.out.println("Element width : "+ loginBtn.getRect().getDimension().getHeight());
        System.out.println("Element X location : "+loginBtn.getRect().getX());
        System.out.println("Element Y location : "+loginBtn.getRect().getY());
    }

    @Test(description = "Friendly Locator", priority = 4)
    public void friendlyLocator() {
        driver.get("https://automationbookstore.dev/");
        WebElement element = driver.findElement(RelativeLocator.with(By.tagName("li")).toLeftOf(By.id("pid6")).below(By.id("pid1")));
        String id = element.getAttribute("id");
        Assert.assertEquals("pid5", id);
    }
}
