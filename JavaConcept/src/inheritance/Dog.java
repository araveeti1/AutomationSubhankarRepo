package inheritance;

/**
 * The Dog class belongs to Animal class and a subclass/child of the Animal
 * class.
 */

public class Dog extends Animal {
	public static void main(String[] args) {
		// As the subclass wants to inherit the property of the super class, we are
		// creating the object of the subclass/child class.
		// i.e- Dog wants to make a sound. Animal does not. So object of dog will be
		// created here.
		Dog obj = new Dog();
		// As here we have inherited from Animal class, the object of the sub class
		// could access the property of the superclass.
		obj.sound();
	}
}
