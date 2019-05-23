package inheritance;

/**
 * As BullDog belongs to Dog class so, it will inherit the Dog class, not the Animal class.
 * As the Dog class already carrying the properties of the Animal Class.
 */
public class BullDog extends Dog {
	public static void main(String[] args) {
		
		BullDog obj = new BullDog();
		obj.sound();
	}
}
