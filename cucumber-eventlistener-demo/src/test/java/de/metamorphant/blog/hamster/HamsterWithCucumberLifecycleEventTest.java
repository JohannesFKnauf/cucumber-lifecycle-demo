package de.metamorphant.blog.hamster;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	strict = true,
	features = "src/test/features",
	glue = "de.metamorphant.blog.hamster.steps",
	plugin = {"de.metamorphant.blog.hamster.cucumberlifecycle.PortSetupLifecycleHandler"}
)
public class HamsterWithCucumberLifecycleEventTest {}
