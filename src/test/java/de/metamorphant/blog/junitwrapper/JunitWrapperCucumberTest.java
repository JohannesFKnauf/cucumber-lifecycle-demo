package de.metamorphant.blog.junitwrapper;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
		glue = "de.metamorphant.blog.common",
		features = "src/test/features"
)
public class JunitWrapperCucumberTest {
	@BeforeClass
	public static void setupClass() {
		System.out.println("I run at test class initialization time, i.e. before the whole bunch of all tests");
	}
	
	@Before
	public void setupMethod() {
		System.out.println("I run at test method initialization time, i.e. before every single test");
	}

	@After
	public void teardownMethod() {
		System.out.println("I run at test method completion time, i.e. after every single test");
	}

	@AfterClass
	public static void teardownClass() {
		System.out.println("I run at test class completion time, i.e. after the whole bunch of all tests");
	}
}
