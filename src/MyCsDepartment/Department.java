package MyCsDepartment;

import java.util.*;

import pa3.project.MyPriorityQueue;

public class Department {
	private HashMap<String,Course> courseMap;
	private MyPriorityQueue<Professor> listOfProfs; // List
	
	public Department(MyPriorityQueue<Professor> pQueue) {
		this.courseMap = new HashMap<String, Course>();
		this.listOfProfs = pQueue;
	}

	public Map<String, Course> getCourseMap() {
		return courseMap;
	}

	public void setCourseMap(HashMap<String, Course> courseMap) {
		this.courseMap = courseMap;
	}

	public MyPriorityQueue<Professor> getListOfProfs() {
		return listOfProfs;
	}

	public void setListOfProfs(MyPriorityQueue<Professor> listOfProfs) {
		this.listOfProfs = listOfProfs;
	}

	@Override
	public String toString() {
		return "Department [courseMap=" + courseMap + ", listOfProfs=" + listOfProfs + "]";
	}


}
