package tricentis.utils;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.rules.TestWatcher;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static tricentis.utils.Utils.getProperty;
import static tricentis.utils.Utils.loadProperties;


public class Hooks extends TestWatcher {
    private static WebDriver driver;
    private static Scenario scenario;
    private static String activeAutomation;

    public Hooks() {
        super();
    }

    @Before
    public void beforeCenario(Scenario scenario) {
        Hooks.scenario = scenario;
        new File("src/test/java/report").mkdir();
        new File("src/test/java/report/Screenshoots").mkdir();
        Utils.deleteAllFilesInFolder("src/test/java/report/Screenshoots");

    }

    @After
    public void afterCenario() throws IOException {
        if (scenario.isFailed()) {
            if (driver != null) {
                GeralPage basePage = new GeralPage();
                System.out.println("The test is failed");
                Throwable throwable = logError(scenario);
                String errorMessage = throwable.getMessage();
            }
        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

    private Throwable logError(Scenario scenario) {
        Field field = FieldUtils.getField(Scenario.class , "delegate" , true);
        Method getError = null;
        try {
            final TestCaseState testCase = (TestCaseState) field.get(scenario);
            if (getError == null) {
                getError = MethodUtils.getMatchingMethod(testCase.getClass() , "getError");
                getError.setAccessible(true);
            }
            return (Throwable) getError.invoke(testCase);
        } catch (Exception e) {
            System.err.println("error receiving exception" + e);
        }
        return null;
    }

    /**
     * Inicializa browser Chrome
     */
    public static void openBrowser() {
        activeAutomation = "chrome";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    /**
     * Retorna o browser inicialzado
     *
     * @return
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Navega pelo site tricentis
     *
     * @param url
     */
    public static void navigate(String url) {
        driver.navigate().to(getProperty(loadProperties(System.getProperty("user.dir") + "\\src\\test\\resources\\dataform.properties") , url));
    }

}
