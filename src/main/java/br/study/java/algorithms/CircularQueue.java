package br.study.java.algorithms;

/**
 * https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
 * 
 * @param item
 */
public class CircularQueue {

	
	private int size;
	private int[] elements;
	
	private int rear;
	private int front;
	
	public static void main(String[] args) { 
		
		CircularQueue q =  new CircularQueue(5); 
	  
	    // Inserting elements in Circular Queue 
	    q.enQueue(14); 
	    q.enQueue(22); 
	    q.enQueue(13); 
	    q.enQueue(-6); 
	  
	    // Display elements present in Circular Queue 
	    q.print(); 
	  
	    // Deleting elements from Circular Queue 
	    System.out.printf("\nDeleted value = %d", q.deQueue()); 
	    System.out.printf("\nDeleted value = %d", q.deQueue()); 
	  
	    q.print(); 
	  
	    q.enQueue(9); 
	    q.enQueue(20); 
	    q.enQueue(5); 
	  
	    q.print(); 
	  
	    q.enQueue(20); 
	} 
	
	public CircularQueue(int size) {
		this.size = size;
		elements = new int[this.size];
        size = 0;
        front = -1;
        rear = -1;
	}
	
	public void enQueue(int item) {
		
		if (isFull()) {
			throw new RuntimeException("Queue is full");
		}

		if (front == -1) {
			// Insert first element
			front = rear = 0;
			elements[rear] = item;
		} else if (rear == size - 1 && front != 0) {
			rear = 0;
			elements[rear] = item;
		} else {
			rear++;
			elements[rear] = item;
		}
	}
	
	public int deQueue() {
		
		if(front == -1) {
			throw new RuntimeException("Queue is empty");
		}
		
		int data = elements[front];
		elements[front] = -1;
		
		if(front == rear) {
			front = rear = -1;
		} else if(front == size -1) {
			front = 0;
		} else {
			front++;
		}
		
		return data;
	}
	
	public boolean isFull() {
		return (front == 0 && rear == size-1) || (rear == (front-1)%(size-1));
	}
	
	public void print() {
		
		if(front == -1) {
			System.out.println("\nCircular queue is empty");
			
		} else if (rear >= front){
			
			System.out.println("\nElements [rear >=front]: ");
			for (int i = front; i <= rear; i++) {
				System.out.println(elements[i]);
			}
			
		} else {
			
			System.out.println("\nElements: ");
			
			for (int i = front; i < size; i++) {
				System.out.println(elements[i]);
			}
	  
	        for (int i = 0; i <= rear; i++) {
	        	System.out.println(elements[i]);
	        }
		}
		
	}
}
