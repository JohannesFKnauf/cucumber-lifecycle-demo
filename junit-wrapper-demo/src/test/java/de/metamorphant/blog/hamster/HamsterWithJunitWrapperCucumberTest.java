package de.metamorphant.blog.hamster;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import de.metamorphant.blog.hamster.steps.HamsterSteps;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	strict = true,
	features = "src/test/features",
	glue = "de.metamorphant.blog.hamster.steps"
)
public class HamsterWithJunitWrapperCucumberTest {
	// A method with annotation @BeforeClass runs at test class initialization time, i.e. before the whole bunch of all tests
	@BeforeClass
	public static void setupClass() {
		System.out.println("JUnit BeforeClass hook started; starting to train a hamster");
		HamsterSteps.injectPort(HamsterWithJunitWrapperCucumberTest.randomPort());
	}
	
	// A method with annotation @Before runs at test method initialization time, i.e. before every single test
	// for Cucumber Runner it will never appear
	@Before
	public void setupMethod() {
		System.out.println("JUnit Before hook called");
	}

	// A method with annotation @After runs at test method completion time, i.e. after every single test
	// for Cucumber Runner it will never appear
	@After
	public void teardownMethod() {
		System.out.println("JUnit After hook called");
	}

	// A method with annotation @AfterClass runs at test class completion time, i.e. after the whole bunch of all tests
	@AfterClass
	public static void teardownClass() {
		System.out.println("JUnit AfterClass hook started; gracefully shutting down hamster");
	}
	
	public static String randomPort() {
		Random rng = new Random();
		Integer basePortOffset = 30000;
		Integer port = basePortOffset + rng.nextInt(2000);

		return port.toString();
	}
}
