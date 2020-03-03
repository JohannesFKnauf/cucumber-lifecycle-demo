package de.metamorphant.blog.cucumberlifecycle;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;

public class LifecycleHandler implements ConcurrentEventListener {
	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestRunStarted.class, event -> {
			System.out.println("Caught TestRunStarted event");
		});
		publisher.registerHandlerFor(TestRunFinished.class, event -> {
			System.out.println("Caught TestRunFinished event");
		});
	}
}
