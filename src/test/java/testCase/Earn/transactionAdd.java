package testCase.Earn;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class transactionAdd {

    @Test(priority = 1)
    public void SuccessAddEarnViaEarnPage() throws MalformedURLException, InterruptedException {
        base.LaunchTest();
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='DOT']")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='CONTINUE']")))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='idInputAmount']"))).sendKeys("0.25");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")))
                .click();

        Thread.sleep(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Add Confirmed']")));

        WebElement elements1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='0.25 DOT']")));
        String actualText1 = elements1.getText();
        String expectedText1 = "0.25 DOT";
        Assert.assertEquals(expectedText1, actualText1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Added Amount']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Payment Method']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Wallet (DOT)']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='RETURN TO EARN']"))).click();
    }

    @Test(priority = 2)
    public void FailedAddEarnDidntMeetMinimumViaEarnPage() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='DOT']")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='CONTINUE']")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='idInputAmount']"))).sendKeys("0.1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")))
                .click();
        WebElement elements1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='The minimum amount to Add Assets is 0.25 DOT']")));
        String texts1 = elements1.getText();

        try {
            if (texts1.equals("The minimum amount to Add Assets is 0.25 DOT")) {
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
    public void FailedAddEarnMoreThanBalanceViaEarnPage() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='0.1']"))).sendKeys("1500");

        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")));
        String actualText1 = element1.getText();
        String expectedText1 = "ADD";
        Assert.assertEquals(expectedText1, actualText1);
    }

}
