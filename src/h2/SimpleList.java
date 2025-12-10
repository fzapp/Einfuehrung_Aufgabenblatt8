package h2;

public class SimpleList {
	Node head;
	
	SimpleList(){
		head = new Node(Integer.MIN_VALUE);
	}
	
	public Node getFirst() {
		return head.next;
	}
	
	public Node getLast() {
		if(head.next == null) {
			return null;
		}
		Node output = head;
		do {
			output = output.next;
		}while(output.next != null);
		return output;
	}
	
	public void append(int newValue) {
		Node lastNode = this.getLast();
		Node toAppend = new Node(newValue);
		lastNode.next = toAppend;
	}
	
	public Node findFirst(int value) {
		Node currentNode = this.getFirst();
		while(currentNode.value != value && currentNode.next != null) {
			currentNode = currentNode.next;
		}
		if(currentNode.value == value) {
			return currentNode;
		}
		return null;
	}
	
	public boolean insertAfter(int preValue, int newValue) {
		if(findFirst(preValue) == null) {
			return false;
		}
		Node preNode = findFirst(preValue);
		Node newNode = new Node(newValue);
		newNode.next = preNode.next;
		preNode.next = newNode;
		return true;
	}
	
	//Das gilt auch für den Fall, dass der Kopfknoten gelöscht werden soll.
			//Wie soll das obere je der Fall sein? Der Kopfknoten speichert doch nach Defintion keinen Wert
			//also kann er auch nicht der erste Knoten mit einem bestimmten Wert sein
			//also kann er auch nie durch die Methode gelöscht werden
			//Ich habe mich also letztendlich beschlossen den Satz zu ignorieren
	
	public boolean delete(int value) {
		if(findFirst(value) == null) {
			return false;
		}
		Node prevNode = findFirstAndPrev(value)[0];
		Node toDelete = findFirst(value);
		prevNode.next = toDelete.next;
		return true;
	}
	
	//hilfsmethode
	public Node[] findFirstAndPrev(int value) {
		Node[] output = new Node[2];
		Node currentNode = this.getFirst();
		Node prevNode = head;
		while(currentNode.value != value && currentNode.next != null) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		if(currentNode.value == value) {
			output[0] = prevNode;
			output[1] = currentNode;
		}
		else {
			output[0] = null;
			output[1] = null;
		}
		return output;
		
	}
	

}
