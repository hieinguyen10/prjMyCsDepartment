package pa3.project;

import MyCsDepartment.Professor;

public class MyPriorityQueue<T> extends MyQueue<Professor> {
	
	public MyPriorityQueue() {
		super();

		}
	
	public void displayElement(int id) {
		for(Professor element: myQueue) {
			if (element.getId() == id)
				System.out.println(element);
		}
	}
	
	public void displayHigherPriorityElements(Professor prof) {
		for(Professor element: myQueue) {
			if (element.getSeniority() > prof.getSeniority() )
				System.out.println(element);
		}
	}
	
	public void displayLowerPriorityElements(Professor prof) {
		for(Professor element: myQueue) {
			if (element.getSeniority() < prof.getSeniority() )
				System.out.println(element);
		}
	}

	@Override
	public void enQueue(Professor value) {
		super.enQueue(value);
		
		if(super.getSize()==1) {
			return;
		}
		else {
			int size = myQueue.size();
			int temp = (rear-1)%size;
			while (temp>=front && value.compareTo(myQueue.get(temp))==-1) {
				myQueue.set(temp+1,myQueue.get(temp));
				temp = temp-1;
				
			}
			myQueue.set(temp+1,value);
			
		}
		
		
	}
	
}
	


				
	

