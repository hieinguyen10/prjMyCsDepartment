package pa3.project;

import java.util.*;

public class MyQueue<T> {
	
	public int maxSize = 20;
	protected ArrayList<T> myQueue= new ArrayList<T>(maxSize);
	protected int front;
	protected int rear; 
	
	public MyQueue() {
		
		this.front = -1;
		this.rear = -1;
	}
	
	// Check if the queue is FULL
	public boolean isFull() {
		if(front == 0 && rear == maxSize -1) {
			return true;
		}
		if (rear == (front - 1) % (maxSize - 1)) {// front == (rear+1)%
			return true;
		}
		return false;
	}
	
	// Check if the queue is EMPTY
	public boolean isEmpty(){
		if(front == -1) {
			return true;
		}
		return false;
	}
	
	// INSERT Item at the end
	public void enQueue(T value) {
		// If Full resize the queue
		if (isFull()) {
			reSize();
		}
		// If Empty
		else if (front== -1 ){
				front = rear = 0;
				myQueue.add(rear,value);
			}
		else if(rear == maxSize - 1 && front != 0)
	    {
	        rear = 0;
	        myQueue.set(rear, value);
	    }
		else
	    {
	        rear = (rear + 1);
	      
	        // Adding a new element if 
	        if(front <= rear)
	        {
	        	myQueue.add(rear,value);
	        }
	      
	        // Else updating old value
	        else
	        {
	        	myQueue.set(rear, value);
	        }
	    }
	}
	
	
	// REMOVE Item at the front
	public T deQueue() {
		T element;
		if (front == -1) {
			throw new NoSuchElementException("Dequeue: Queue is EMPTY");
	
		}
		else {
			element = myQueue.get(front);
			// If Queue only has 1 element before Dequeue
			if (front == rear) {
				front = -1;
				rear = -1;
			}
			else {
				front = (front +1)%maxSize;
			}
			return element;
			
		}
	}
	
	// Resize
	public void reSize() {
		int newSize = maxSize*2;
		
		ArrayList<T> tmp = new ArrayList<T>(newSize);
		
		for (int i = 0; i < maxSize; i++) {
			tmp.add(myQueue.get(i));
		}
		
		myQueue=tmp;
		front = 0;
		rear = maxSize - 1;
		maxSize = newSize;
	}
	
	public int getSize() {
		return myQueue.size();
	}
	
	
	// Display all Elements
	public void displayAllElements() {
		for (T element: myQueue) {
			System.out.println(element);
		}
	}
}
	

	

	
	
	
	
	

