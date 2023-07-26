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

public class transactionAddPortfolioDetail {


    @Test(priority = 1)
    public void SuccessAddEarnViaPortfolioDetail() throws MalformedURLException, InterruptedException {
        base.LaunchTest();
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Earn Portfolio']")))
                .click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"1\"]")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='idInputAmount']"))).sendKeys("5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")))
                .click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Add Confirmed']")));

        WebElement elements1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='5 ONE']")));
        String actualText1 = elements1.getText();
        String expectedText1 = "5 ONE";
        Assert.assertEquals(expectedText1, actualText1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Added Amount']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Payment Method']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Wallet (ONE)']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='CHECK ORDER DETAIL']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"0\"]")))
                .click();

        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Add to Earn']")));
        String actualText2 = element2.getText();
        String expectedText2 = "Add to Earn";
        Assert.assertEquals(expectedText2, actualText2);

        WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='5 ONE']")));
        String actualText3 = element3.getText();
        String expectedText3 = "5 ONE";
        Assert.assertEquals(expectedText3, actualText3);

        WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Harmony']")));
        String actualText4 = element4.getText();
        String expectedText4 = "Harmony";
        Assert.assertEquals(expectedText4, actualText4);

        WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Wallet (ONE)']")));
        String actualText5 = element4.getText();
        String expectedText5 = "Wallet (ONE)";
        Assert.assertEquals(expectedText5, actualText5);

        WebElement element6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Completed']")));
        String actualText6 = element6.getText();
        String expectedText6 = "Completed";
        Assert.assertEquals(expectedText6, actualText6);
    }

    @Test(priority = 2)
    public void FailedAddEarnDidntMeetMinimumViaPortfolioDetail() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='idInputAmount']"))).sendKeys("0.1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")))
                .click();
        WebElement elements1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='The minimum amount to Add Assets is 5 ONE']")));
        String texts1 = elements1.getText();

        try {
            if (texts1.equals("The minimum amount to Add Assets is 5 ONE")) {
                System.out.println("berhasil verify error message");
            }
        }
        catch (Exception e) {
            WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")));
            String actualText2 = element2.getText();
            String expectedText2 = "ADD";
            Assert.assertEquals(expectedText2, actualText2);
        }

    }

    @Test(priority = 3)
    public void FailedAddEarnMoreThanBalanceViaPortfolioDetail() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='0.1']"))).sendKeys("20000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")))
                .click();
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")));
        String actualText1 = element1.getText();
        String expectedText1 = "ADD";
        Assert.assertEquals(expectedText1, actualText1);
    }
}
