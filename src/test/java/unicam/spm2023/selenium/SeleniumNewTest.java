package unicam.spm2023.selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.ArrayList;
import io.github.bonigarcia.wdm.WebDriverManager;

class SeleniumNewTest {

	static String projectPath;	
	static WebDriver driver;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		WebDriverManager.chromedriver().setup();
	}
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	//	System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/java/unicam/spm2023/drivers/chromedriver");
		driver = new ChromeDriver();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	@Disabled
	void checkProsSite() throws InterruptedException {
		
		driver.get("http://pros.unicam.it/");

		Thread.sleep(3000);
		
		String at = driver.getTitle();
		String et = "PROS - PROcesses & Services lab | Computer Science division @Unicam";
		
		//System.out.println(at);		
		Thread.sleep(4000);

		assertEquals(et,at);
		
		
	}
	
	@Test
	@Disabled
	void checkProsSiteSearch() throws InterruptedException {
		
		// navigate your driver to mail.google.com
		driver.get("https://pros.unicam.it/");

		Thread.sleep(4000);
		
		//Find Element by className
		driver.findElement(By.className("toggle-search")).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.className("search")).click();
		
		Thread.sleep(4000);

		driver.findElement(By.className("search")).sendKeys("Digital Twin");

		driver.findElement(By.className("search")).sendKeys(Keys.RETURN);

		Thread.sleep(4000);

		List<WebElement> elements = driver.findElements(By.xpath("//div//div//a"));
		ArrayList<String> retrieved_text = null;

		boolean textPresent=false;

		for (WebElement element : elements) {

			//System.out.println("text:" + element.getText());
			//String text = element.getText();

			if(element.getText().equals("Digital Twin"))textPresent=true;

		}

		assertTrue(textPresent);
		//TO COMPLETE
			
	}


	@Test
	@Tag("AcceptanceTest")
	void shouldBeExpectedPage() throws InterruptedException {

		//System.out.println(projectPath);
		driver.get("http://localhost:8080/spm2023/");

		Thread.sleep(3000);

		String at = driver.getTitle();
		String et = "SPM 2023";

		assertEquals(et,at);


	}



}
