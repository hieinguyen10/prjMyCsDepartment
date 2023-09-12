package MyCsDepartment;

import java.time.LocalDate;
import java.util.*;

public class Professor implements Comparable <Professor>{
	private int id;
	private String name;
	private float seniority;
	private LocalDate hiringDate;
	private HashSet<String> setOfDisciplines;// HashSet 
	private ArrayList<Course> listOfAffectedCourses;
	

	public Professor() {
		this.listOfAffectedCourses = null;
	}
	
	public Professor(int id, String name, float seniority, LocalDate hiringDate, HashSet<String> setOfDisciplines) {
		this.id = id;
		this.name = name;
		this.seniority = seniority;
		this.hiringDate = hiringDate;
		this.setOfDisciplines = setOfDisciplines;
		this.listOfAffectedCourses = null;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSeniority() {
		return seniority;
	}
	public void setSeniority(float seniority) {
		this.seniority = seniority;
	}
	public LocalDate getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(LocalDate hiringDate) {
		this.hiringDate = hiringDate;
	}
	public HashSet<String> getSetOfDisciplines() {
		return setOfDisciplines;
	}

	public void setSetOfDisciplines(HashSet<String> setOfDisciplines) {
		this.setOfDisciplines = setOfDisciplines;
	}
	
	public ArrayList<Course> getListOfAffectedCourses() {
		return listOfAffectedCourses;
	}

	public void setListOfAffectedCourses(ArrayList<Course> listOfAffectedCourses) {
		this.listOfAffectedCourses = listOfAffectedCourses;
	}
	
	
	
	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", seniority=" + seniority + ", hiringDate=" + hiringDate
				+ ", setOfDisciplines=" + setOfDisciplines + ", listOfAffectedCourses=" + listOfAffectedCourses + "]";
	}

	@Override
    public int compareTo(Professor prof) 
    {
        if (this.getSeniority() > prof.getSeniority()) {
        	return -1;
        }
        else if (this.getSeniority() == prof.getSeniority())
        {
        	if(this.getHiringDate().isBefore(prof.getHiringDate())) {
        		return -1;
        	}
        	else
        		return 1;
        }
        	
        else
        	return 1;
    }
	
	 
	
}
