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
public class HamsterCucumberTest {}
