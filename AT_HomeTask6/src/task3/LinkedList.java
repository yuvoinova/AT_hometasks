package task3;

public class LinkedList<T> {
	private LinkedListElement firstElement;

	public LinkedListElement getFirstElement() {
		return firstElement;
	}

	public LinkedList() {
	}

	public LinkedList(T data) {
		firstElement = new LinkedListElement(data);
	}

	public void add(T data) {
		LinkedListElement currentElement = new LinkedListElement(data);
		if (firstElement != null) {
			LinkedListElement lastElement = firstElement;
			while (lastElement.pointer != null) {
				lastElement = currentElement.pointer;
			}
			lastElement.pointer = currentElement;
		} else {
			firstElement = currentElement;
		}
	}

	public void remove(int index) {
		if (index == 0) {
			if (firstElement.pointer == null) {
				firstElement = null;
			} else {
				LinkedListElement secondElement = firstElement.pointer;
				firstElement.pointer = null;
				firstElement = secondElement;
			}
		} else {
			LinkedListElement currentElement = getElement(index);
			LinkedListElement previousElement = getElement(index - 1);
			if (currentElement != null) {
				previousElement.pointer = currentElement.pointer;
				currentElement.pointer = null;
			}
		}
	}

	private LinkedListElement getElement(int index) {
		int currentPosition = 0;
		LinkedListElement currentElement = firstElement;
		while (currentElement != null) {
			if (currentPosition == index) {
				break;
			} else {
				currentPosition++;
				currentElement = currentElement.pointer;
			}
		}
		if (currentPosition == index) {
			return currentElement;
		} else {
			return null;
		}
	}

	public T get(int index) {
		LinkedListElement currentElement = getElement(index);
		if (currentElement != null) {
			return (T) currentElement.data;
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		if (firstElement != null) {
			StringBuffer Result = new StringBuffer("");
			LinkedListElement currentElement = firstElement;
			while (currentElement != null) {
				Result.append(currentElement.data + " ");
				currentElement = currentElement.pointer;
			}
			return Result.toString().trim();
		} else {
			return "The list is empty";
		}
	}
}
