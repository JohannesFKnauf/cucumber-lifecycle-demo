package de.metamorphant.blog.hamster.cucumberlifecycle;

import de.metamorphant.blog.hamster.HamsterUtil;
import de.metamorphant.blog.hamster.steps.HamsterSteps;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;

public class PortSetupLifecycleHandler implements EventListener {
	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestRunStarted.class, event -> {
			System.out.println("Caught TestRunStarted event; starting to train a hamster");
			
			String port = HamsterUtil.performExpensiveHamsterTraining();
			HamsterSteps.injectPort(port);
		});
		
		publisher.registerHandlerFor(TestRunFinished.class, event -> {
			System.out.println("Caught TestRunFinished event; gracefully shutting down hamster");
		});
	}
}
