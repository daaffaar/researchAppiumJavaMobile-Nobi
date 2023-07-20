 package testCase.Earn;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class earnPage {

    @Test(priority = 1)
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


    @Test(priority = 2)
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

    @Test(priority = 3)
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

    @Test(priority = 4)
    public void OpenCSMessage() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup"))).click();
        Thread.sleep(10000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

    @Test(priority = 5)
    public void CoinDetailPage() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        double principal = 100;
        double apy = 5;
        double time6Months = 0.5;
        double time1Year = 1;
        String expectedMinimumAdd = "0.25";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='DOT']")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='123456']"))).sendKeys("100");

        WebElement interest6Month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[5]")));
        String expectedInterest6Month = interest6Month.getText();
        String[] splitInterest6Month = expectedInterest6Month.split(" ");
        String resultSplitInterest6Month= splitInterest6Month[0];

        WebElement interest1Year = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[6]")));
        String expectedInterest1Year = interest1Year.getText();
        String[] splitInterest1Year= expectedInterest1Year.split(" ");
        String resultSplitInterest1Year = splitInterest1Year[0];

        double actualInterest6Month = principal * (apy / 100) * time6Months;
        String actualInterest6MonthConvert = actualInterest6Month  % 1 == 0 ? String.format("%.0f", actualInterest6Month) : String.valueOf(actualInterest6Month);
        Assert.assertEquals(actualInterest6MonthConvert, resultSplitInterest6Month);

        double actualInterest1Year = principal * (apy / 100) * time1Year;
        String actualInterest1YearConvert = actualInterest1Year  % 1 == 0 ? String.format("%.0f", actualInterest1Year) : String.valueOf(actualInterest1Year);
        Assert.assertEquals(actualInterest1YearConvert, resultSplitInterest1Year);

        WebElement minimumAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView[2]")));
        String actualMinimumAdd = minimumAdd.getText();
        String[] splitMinimumAdd= actualMinimumAdd.split(" ");
        String resultSplitMinimumAdd = splitMinimumAdd[0];

        Assert.assertEquals(expectedMinimumAdd, resultSplitMinimumAdd);

        WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='ADD']")));
        String actualText4 = element4.getText();
        String expectedText4 = "ADD";
        Assert.assertEquals(expectedText4, actualText4);

        WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='REMOVE']")));
        String actualText5 = element5.getText();
        String expectedText5 = "REMOVE";
        Assert.assertEquals(expectedText5, actualText5);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

}