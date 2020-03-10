package de.metamorphant.blog.hamster.steps;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import de.metamorphant.blog.hamster.Hamster;
import de.metamorphant.blog.hamster.NotInTheMoodException;
import io.cucumber.java8.En;

public class HamsterSteps implements En {
	private Hamster hamster;
	private static String port;
	
	public HamsterSteps() {
		HamsterSteps.readPortFromSystemProperties();
		
		Given("a trained hamster", () -> {
			this.hamster = Hamster.trainedHamster(port);
		});

		When("I make the hamster jump through a burning loop", () -> {
			this.hamster.makeJump();
		});

		When("I reward him with a honey cracker", () -> {
			this.hamster.reward();
		});

		When("I do not react", () -> {
			this.hamster.ignore();
		});

		Then("the hamster will be happy", () -> {
			assertTrue(this.hamster.isHappy());
		});
		
		Then("the hamster will be sad", () -> {
			assertTrue(this.hamster.isSad());
		});

		Then("the hamster will be ready to just do it again", () -> {
			this.hamster.makeJump();
		});
	
		Then("the hamster will decline another jump", () -> {
			assertThrows(NotInTheMoodException.class, () -> {
				this.hamster.makeJump();
			});				
		});

	}
	
	private static void readPortFromSystemProperties() {
		String port = System.getProperty("hamster.port");
		if (port != null) {
			HamsterSteps.port = port;
		}
	}

	public static void injectPort(String port) {
		System.out.println("Setting port to: " + port);
		HamsterSteps.port = port;
	}
}
