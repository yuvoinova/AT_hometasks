
public class Pet {
	int age;
	float weight;
	float height;
	String color;
	
	final public void sleep() {
		System.out.println("��������� ����! �� ������");
	}
	
	public void eat() {
		System.out.println("� ����� �������, ������� ��������� �������!");
	}
	
	public String say(String aWord) {
		String petResponse = "�� �����!! " + aWord;
		return petResponse;
	}

}
