package ku.ac.th.billbroweb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest {
    @LocalServerPort
    private Integer port;

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1000);
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/login");
    }

    @AfterEach
    public void afterEach() throws InterruptedException {
        Thread.sleep(3000);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    void testLoginCorrectIdPin() {
        WebElement idField = wait.until(webDriver ->
                webDriver.findElement(By.id("username")));
        WebElement pinField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submitbtn"));

        idField.sendKeys("nz3672");
        pinField.sendKeys("1234");

        WebElement resultHeader = wait.until(webDriver ->
                webDriver.findElement(By.tagName("h1")));
        assertEquals("nz3672", resultHeader.getText());
    }


}
