package de.metamorphant.blog.hamster.cucumberlifecycle;

import java.util.Random;

import de.metamorphant.blog.hamster.steps.HamsterSteps;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;

public class PortSetupLifecycleHandler implements EventListener {
	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestRunStarted.class, event -> {
			System.out.println("Caught TestRunStarted event; starting to train a hamster");
						
			HamsterSteps.injectPort(PortSetupLifecycleHandler.randomPort());
		});
		
		publisher.registerHandlerFor(TestRunFinished.class, event -> {
			System.out.println("Caught TestRunFinished event; gracefully shutting down hamster");
		});
	}
	
	public static String randomPort() {
		Random rng = new Random();
		Integer basePortOffset = 30000;
		Integer port = basePortOffset + rng.nextInt(2000);

		return port.toString();
	}
}
