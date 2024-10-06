package testBase;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseClass {
    public static WebDriver driver;

    @BeforeTest
    public void Setup()
    {
        driver = new ChromeDriver();
        driver.get("https://ecommerce.tealiumdemo.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest

    public void TearDown()
    {
        driver.quit();
    }


    public String captureScreen(String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot)driver;
        BufferedImage sourceFile = ImageIO.read(ts.getScreenshotAs(OutputType.FILE));

        String targetFilePath = System.getProperty("user.dir")+"/ScreenShots/"+testName+"_"+timeStamp+".png";
        File targetFile = new File(targetFilePath);
        ImageIO.write(sourceFile ,"png",targetFile);

        return targetFilePath;
    }
}
