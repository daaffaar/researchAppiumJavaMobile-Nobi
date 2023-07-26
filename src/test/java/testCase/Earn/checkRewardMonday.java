package testCase.Earn;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;

public class checkRewardMonday {

    @Test(priority = 1)
    public void checkReward() throws MalformedURLException, InterruptedException {
        base.LaunchTest();
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Earn Portfolio']")))
                .click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"0\"]")))
                .click();

        DayOfWeek hariIni = LocalDate.now().getDayOfWeek();

        if (hariIni == DayOfWeek.MONDAY) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"0\"]")))
                    .click();

            WebElement elements1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Reward']")));
            String actualText1 = elements1.getText();
            String expectedText1 = "Reward";
            Assert.assertEquals(expectedText1, actualText1);

            WebElement elements2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Harmony']")));
            String actualText2 = elements2.getText();
            String expectedText2 = "Harmony";
            Assert.assertEquals(expectedText2, actualText2);

            WebElement elements3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Completed']")));
            String actualText3 = elements3.getText();
            String expectedText3 = "Completed";
            Assert.assertEquals(expectedText3, actualText3);

         } else {
        System.out.println("Hari ini bukan hari Senin, tidak ada pengecekan.");
        }
}

}
