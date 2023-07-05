package com.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class earn {

    @Test
    public void HideAndUnhideBalanceOnEarnPage() throws MalformedURLException, InterruptedException {

        base.LaunchTest();
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Total Earn Balance']"))).click();
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='*****']")));
        String text1 = element1.getText();

        if (text1.equals("*****")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Total Earn Balance']")))
                    .click();
            System.out.println("Hide dan Unhide Balance berhasil");
        } else {
            System.out.println("Hide dan Unhide Balance tidak berhasil");
        }
    }


    @Test
    public void SortBY() throws MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[2]"))).click();

        List<WebElement> elements2 = new ArrayList<>();

        WebElement HighestApyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Highest APY']")));
        elements2.add(HighestApyElement);

        WebElement LowestAPYElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Lowest APY']")));
        elements2.add(LowestAPYElement);

        WebElement CoinNameAZ = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Coin Name A-Z']")));
        elements2.add(CoinNameAZ);

        WebElement CoinNameZA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Coin Name Z-A']")));
        elements2.add(CoinNameZA);

        List<String> expectedTexts = Arrays.asList("Highest APY", "Lowest APY", "Coin Name A-Z", "Coin Name Z-A");

        for (int i = 0; i < elements2.size(); i++) {
            WebElement element2 = elements2.get(i);
            String actualText2 = element2.getText();
            String expectedText2 = expectedTexts.get(i);

            Assert.assertEquals(expectedText2, actualText2);
        }

        driver.findElement(By.xpath("//android.widget.TextView[@text='CLOSE']")).click();
    }

    @Test
    public void VerifyTextOnTabEarn() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Gain Rewards on your Assets']")));
        String actualText3 = element3.getText();
        String expectedText3 = "Gain Rewards on your Assets";
        Assert.assertEquals(expectedText3, actualText3);

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")).click();
        WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='NOBI Earn is a reward-bearing account, which provides competitive Annual Percentage Yield (APY). With NOBI Earn, you can earn rewards from your crypto assets every Monday.']")));
        String actualText4 = element4.getText();
        String expectedText4 = "NOBI Earn is a reward-bearing account, which provides competitive Annual Percentage Yield (APY). With NOBI Earn, you can earn rewards from your crypto assets every Monday.";
        Assert.assertEquals(expectedText4, actualText4);
        driver.findElement(By.xpath("//android.widget.TextView[@text='I UNDERSTAND']")).click();

    }

    @Test
    public void OpenCSMessage() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")).click();
        Thread.sleep(10000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

    @Test
    public void CoinDetailPage() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='BTC']")))
                .click();

    }
}