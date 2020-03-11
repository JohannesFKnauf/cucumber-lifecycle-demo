package de.metamorphant.blog.hamster;

public class Hamster {
	String port;
	Boolean happy;
	
	private Hamster(String port) {
		this.port = port;
		this.happy = true;
	}
	
	public void makeJump() {
		System.out.println("Trying to make the hamster jump through a burning loop");
		if (this.happy == true) {
			this.say("And it burns, burns, burns, The ring of fire!");
		} else {
			this.say("Go jump yourself");
			throw new NotInTheMoodException("I am mad at you!");
		}
	}
	
	public void reward() {
		System.out.println("Rewarding the hamster with a honey cracker");
		this.say("Yay! This honey cracker is yummy!");
		this.happy = true;
	}
	
	public void ignore() {
		System.out.println("Ignoring the hamster");
		this.say("You make me sad.");
		this.happy = false;
	}
	
	public Boolean isHappy() {
		return this.happy;
	}
	
	public Boolean isSad() {
		return !this.isHappy();
	}
	
	private void say(String message) {
		String output = String.format("Hamster on port %s: %s", this.port, message);
		System.out.println(output);
	}
	
	public static Hamster trainedHamster(String port) {
		System.out.println("Providing a trained hamster");
		return new Hamster(port);
	}
}
