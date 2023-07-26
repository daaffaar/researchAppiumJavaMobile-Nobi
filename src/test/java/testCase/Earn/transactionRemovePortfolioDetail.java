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
import java.time.Duration;

public class transactionRemovePortfolioDetail {
    @Test(priority = 1)
    public void FailedRemoveEarnMoreThanBalanceViaEarnPage() throws MalformedURLException, InterruptedException {
        base.LaunchTest();
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Earn Portfolio']")))
                .click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"1\"]")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='REMOVE']")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='idInputAmount']"))).sendKeys("100");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='REMOVE']")))
                .click();

        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='REMOVE']")));
        String actualText1 = element1.getText();
        String expectedText1 = "REMOVE";
        Assert.assertEquals(expectedText1, actualText1);
    }

    @Test(priority = 2)
    public void SuccessRemoveEarnViaEarnPage() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='100']"))).sendKeys("0.1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='REMOVE']")))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Remove Amount']")));

        WebElement elements1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='0.1 ONE']")));
        String actualText1 = elements1.getText();
        String expectedText1 = "0.1 ONE";
        Assert.assertEquals(expectedText1, actualText1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Payment Method']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Earn (Harmony)']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Total Amount']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='0.1 ONE']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='CONFIRM(15)']"))).click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Remove Confirmed']")));

        WebElement elements2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='0.1 ONE']")));
        String actualText2 = elements2.getText();
        String expectedText2 = "0.1 ONE";
        Assert.assertEquals(expectedText2, actualText2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='From']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Earn (Harmony)']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='CHECK ORDER DETAIL']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"0\"]")))
                .click();

        WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Remove from Earn']")));
        String actualText3 = element3.getText();
        String expectedText3 = "Remove from Earn";
        Assert.assertEquals(expectedText3, actualText3);

        WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='0.1 ONE']")));
        String actualText4 = element4.getText();
        String expectedText4 = "0.1 ONE";
        Assert.assertEquals(expectedText4, actualText4);

        WebElement element5= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Wallet (ONE)']")));
        String actualText5 = element5.getText();
        String expectedText5 = "Wallet (ONE)";
        Assert.assertEquals(expectedText5, actualText5);

        WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Completed']")));
        String actualText6 = element6.getText();
        String expectedText6 = "Completed";
        Assert.assertEquals(expectedText6, actualText6);
    }
}
