package task3;

public class Test {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList(1);
		System.out.println("Creat list with 1 Integer element. The list: ");
		System.out.println(myList);
		System.out.println();

		myList.add("Azaza");
		System.out.println("Add String element \"Azaza\" to the list. The list: ");
		System.out.println(myList);
		System.out.println();

		System.out.println("Get element with index = 0. The element is ");
		System.out.println(myList.get(0));
		System.out.println();

		myList.remove(0);
		System.out.println("Remove element with index = 0. The list: ");
		System.out.println(myList);
		System.out.println();

		myList.remove(0);
		System.out.println("Remove element with index = 0. The list: ");
		System.out.println(myList);
		System.out.println();

		System.out.println("Get element with index = 0. The element is ");
		System.out.println(myList.get(0));
		System.out.println();

		myList.add(5.8);
		System.out.println("Add Double element to the empty list. The list: ");
		System.out.println(myList);
		System.out.println();

		myList.remove(10);
		System.out.println("Remove element with nonexistent index = 10. The list: ");
		System.out.println(myList);
		System.out.println();
	}
}
