
public interface LinkedList {
    public void add(int v);
    public boolean remove(int v); //Returns true if a Node is removed, false otherwise.
	public void print();
	public boolean isEmpty();
	public int size();
	public int indexOf(int v); //Returns the first appearance of an integer, if more than two exist. Returns -1 if an integer does not exist.
}


public class Node {
    private Node next;
    private int val;
    public Node(int v) {
        val = v;
    }
    public Node(int v, Node n) {
        val = v;
        next = n;
    }
    public void set(Node n) {
        next = n;
    }
    public Node getNext() {
        return next;
    }
    public int get(){
        return val;
    }
}

public class MyLinkedList implements LinkedList {
	private Node head;
	private int count;
	public MyLinkedList() {
		head = null;
		count = 0;
	}
	public void add(int v) {
		if(head == null)
			head = new Node(v);
		else if(v < head.get()) {
			Node n = new Node(v, head);
			head = n;
		} else {
			Node temp = head;
			while(temp.getNext() != null){
				if(v >= temp.get() && v <= temp.getNext().get()) {
					Node n = new Node(v, temp.getNext());
					temp.set(n);
					count++;
					return;
				}
				temp = temp.getNext();
			}
			temp.set(new Node(v));
		}
		count++;
	}
	public boolean remove(int v) {
		if(head == null)
			return false;

		if(head.get() == v) {
			head = head.getNext();
			count--;
			return true;
		}
		Node temp = head;
		while(temp.getNext() != null) {
			if(temp.getNext().get() == v) {
				temp.set(temp.getNext().getNext());
				count--;
				return true;
			} else 
				temp = temp.getNext();
		}
		return false;
	}
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.get() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	public boolean isEmpty() {
		return count == 0;
	}
	public int size() {
		return count;
	}
	public int indexOf(int v) {
		Node temp = head;
		int tcount = 0;
		while(temp != null) {
			if(temp.get() == v)
				return tcount;
			else {
				tcount++;
				temp = temp.getNext();
			}
		}
		return -1;
	}
}
