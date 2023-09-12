package MyCsDepartment;

public class Course {
	private String id;
	private String title;
	private String discipline;
	private int numberOfHours;
	private int numberOfGroups;
	
	public Course() {
		this.numberOfGroups=0;
	}
	
	public Course(String id, String title, String discipline, int numberOfHours, short numberOfGroups) {
		this.id = id;
		this.title = title;
		this.discipline = discipline;
		this.numberOfHours = numberOfHours;
		this.numberOfGroups = numberOfGroups;
	}
	
	public Course(Course course) {
		this.id = course.id;
		this.title = course.title;
		this.discipline = course.discipline;
		this.numberOfHours = course.numberOfHours;
		this.numberOfGroups = course.numberOfGroups;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	public int getNumberOfHours() {
		return numberOfHours;
	}
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	public int getNumberOfGroups() {
		return numberOfGroups;
	}
	public void setNumberOfGroups(int numberOfGroups) {
		this.numberOfGroups = numberOfGroups;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", discipline=" + discipline + ", numberOfHours="
				+ numberOfHours + ", numberOfGroups=" + numberOfGroups + "]";
	}
	
	
}
