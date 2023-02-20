package TestFlow;

import Utils.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    private static List<DriverFactory> driverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> threadLocal = new ThreadLocal<>();
    private static String browser;

    @BeforeTest
    public void initDriverSession()
    {
        this.browser = "chrome";
        //System.getProperty("browser") != null ? System.getProperty("browser") : properties.getProperty("browser");
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Utils/information.properties");
            Properties properties = new Properties();
            properties.load(fis);

            threadLocal = ThreadLocal.withInitial(()->{
                DriverFactory driverFactory = new DriverFactory();
                driverThreadPool.add(driverFactory);
                return driverFactory;
            });

            /*DriverFactory driverFactory = new DriverFactory();
            threadLocal.set(driverFactory.initDriver(this.browser));*/
        }catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @AfterTest(alwaysRun = true)
    public void quitSession()
    {
        threadLocal.get().closeSession();
    }

    @AfterMethod
    public void takeErrorScreenShot(ITestResult testResult) {
        if(testResult.getStatus() == ITestResult.FAILURE) {
            String failedMethodName = testResult.getName();
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            String takenTime = localDateTime.format(dtf);
            String fileName = failedMethodName + " - " + takenTime + ".png";
            String fileLocation = System.getProperty("user.dir") + "src/test/ErrorPics/" + fileName;

            TakesScreenshot takeScreenShotDriver = (TakesScreenshot) getDriver();
            File sourceFile = takeScreenShotDriver.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(sourceFile, new File(fileLocation));
                Path filePath = Paths.get(fileLocation);
                InputStream inputStream = Files.newInputStream(filePath);
                Allure.addAttachment(failedMethodName, inputStream);
            } catch (Exception ex) {
                throw new IllegalArgumentException("[ERR] Cannot take screen shot and attach into allure report !!!");
            }
        }
    }

    /*@BeforeClass(dependsOnMethods = {"initDriver"})
    public void goToLandingPage()
    {
        System.out.println("chay sau");
        LoginPageForm loginPageForm = new LoginPageForm(this.driver);
        loginPageForm.goToLoginPage();
    }*/

    public WebDriver getDriver() {
        return threadLocal.get().initDriver(browser);
    }




}
