package de.metamorphant.blog.common;

import io.cucumber.java8.En;

public class SampleSteps implements En {
	
	private static String injected;
	
	public SampleSteps() {
		Given("a calculator c", () -> {
			System.out.println("would setup a calculator here");
		});

		Given("an entered number {int}", (Integer int1) -> {
			System.out.println("would prepare state of the calculator here");
		});

		When("adding {int}", (Integer int1) -> {
			System.out.println("would perform an addition here");
		});

		Then("a result of {int} is returned", (Integer int1) -> {
			System.out.println("would check results here");
			System.out.println("injected has value: " + injected);
		});		
	}
	
	public static void inject(String value) {
		System.out.println("Setting injected to value: " + value);
		injected = value;
	}
}
