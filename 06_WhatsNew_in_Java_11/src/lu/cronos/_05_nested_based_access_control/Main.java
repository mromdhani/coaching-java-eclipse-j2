package lu.cronos._05_nested_based_access_control;

import java.util.Arrays;

public class Main {

	private void display() {
		System.out.println("hello from private method");
	}

	class NestedMain {
		void msg() {
			display();
		}
	}

	public static void main(String[] args) {

		Main m = new Main();
		Main.NestedMain n = m.new NestedMain();
		n.msg();

		// Get Nest Host Name
		System.out.println(Main.class.getNestHost());
		// Get Nest Members
		System.out.println(Arrays.toString(Main.class.getNestMembers()));
		// Check whether a class is nestmate
		System.out.println(Main.class.isNestmateOf(NestedMain.class));

	}
}
