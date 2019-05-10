package task2.interfaces;

public interface Publisher {
	void subscribe(Observer observer);

	void unsubscribe(Observer observer);

	void notifyAll(String data);
}
