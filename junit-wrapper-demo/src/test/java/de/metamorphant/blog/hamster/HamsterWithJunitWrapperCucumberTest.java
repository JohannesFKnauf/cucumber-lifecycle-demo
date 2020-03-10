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
	@BeforeClass
	public static void setupClass() {
		System.out.println("This method runs at test class initialization time, i.e. before the whole bunch of all tests");
		HamsterSteps.injectPort(HamsterWithJunitWrapperCucumberTest.randomPort());
	}
	
	@Before
	public void setupMethod() {
		System.out.println("This method would run at test method initialization time, i.e. before every single test; for Cucumber Runner it will never appear");
	}

	@After
	public void teardownMethod() {
		System.out.println("This method would run at test method completion time, i.e. after every single test; for Cucumber Runner it will never appear");
	}

	@AfterClass
	public static void teardownClass() {
		System.out.println("This method runs at test class completion time, i.e. after the whole bunch of all tests");
	}
	
	public static String randomPort() {
		Random rng = new Random();
		Integer basePortOffset = 30000;
		Integer port = basePortOffset + rng.nextInt(2000);

		return port.toString();
	}
}
