package de.metamorphant.blog.cucumberlifecycle;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	strict = true,
	features = "src/test/features",
	glue = "de.metamorphant.blog.common",
	plugin = {"de.metamorphant.blog.cucumberlifecycle.LifecycleHandler"}
)
public class CucumberLifecycleEventTest {}
