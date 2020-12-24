package ku.ac.th.billbroweb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegisterTest {
    @LocalServerPort
    private Integer port;

    private static WebDriver driver;
    private static WebDriverWait wait;

    @FindBy(id = "username")
    private WebElement idField;

    @FindBy(id = "password")
    private WebElement pinField;

    @FindBy(id = "cUsername")
    private WebElement userField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "c_email")
    private WebElement emailField;

    @FindBy(id = "in-app")
    private WebElement inappField;

    @FindBy(id = "submitbtn")
    private WebElement submitButton;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1000);
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://localhost:" + port + "/register");
        PageFactory.initElements(driver, this);
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
    void testRegisterCheck() {

        userField.sendKeys("nz3671");
        passwordField.sendKeys("1234");
        emailField.sendKeys("thehelper05@gmail.com");
        inappField.sendKeys("Nice");
        submitButton.click();

        driver.get("http://localhost:" + port + "/login");
        idField.sendKeys("nz3671");
        passwordField.sendKeys("1234");
        submitButton.click();
        assertTrue(driver.getCurrentUrl().endsWith("home"));
    }

}
