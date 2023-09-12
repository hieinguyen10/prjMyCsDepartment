// -------APPLICATION--------

package pa3.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

import MyCsDepartment.*;

public class MainApplication {

	public static void main(String[] args) {
		
		// ADD Professors
		MyPriorityQueue<Professor> pQueue = new MyPriorityQueue<Professor>();
		// GET Professors from File
		try {
            
            
            LocalDate hiringDate;
             File profs = new File("profs.txt"); // use path
             Scanner myReader = new Scanner(profs);
             while (myReader.hasNextLine()) {
               String line  = myReader.nextLine();
               //System.out.println(line);
               String[] profsArr = line.split(":");
               //profsArr(id, name, seniority, hiringDate, setOfDisciplines)
               //			0	1		2		3				4		
          
               // LocalDate
               String[] date = (profsArr[3].split("-"));
               hiringDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
               
               HashSet<String> setOfDisciplines = new HashSet<String>();
               // Set of disciplines
               for (String element: (profsArr[4].split(","))) {
            	   setOfDisciplines.add(element);
               }
               
               Professor profFromFile = new Professor(Integer.parseInt(profsArr[0]),profsArr[1], Float.parseFloat(profsArr[2]), hiringDate, setOfDisciplines);
	           pQueue.enQueue(profFromFile);
               
             }
             myReader.close();
		} catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
		}
		
		Department department = new Department(pQueue);
		
		HashMap<String,Course> setOfCourses = new HashMap<String,Course>();
		
		// ADD Courses
		MyQueue<Course> cQueue = new MyQueue<Course>();
		// GET courses from File
		try {
		           
				File courses = new File("courses_f22.txt"); // use path
		        Scanner myReader = new Scanner(courses);
		        while (myReader.hasNextLine()) {
		        	String line  = myReader.nextLine();
		            //System.out.println(line);
		            String[] courseArr = line.split(": ");
		            Course courseFromFile = new Course(courseArr[0],courseArr[1], courseArr[2], Integer.parseInt(courseArr[3]), Short.parseShort(courseArr[4]));
		            setOfCourses.put(courseFromFile.getId(), courseFromFile);
		            //System.out.println(course);
		            cQueue.enQueue(courseFromFile);
		            
		            
		        }
		        myReader.close();
		} catch (FileNotFoundException e) {
		       	System.out.println("An error occurred.");
		        e.printStackTrace();
		}
		
		department.setCourseMap(setOfCourses);
		
		pQueue.displayAllElements();
		System.out.println("----------------");
		cQueue.displayAllElements();
		System.out.println("----------------");
				
		
		
		
		// Look for Selection Files
		
		Professor currentProf = new Professor();	
		int size = pQueue.getSize();		
		for(int i=0; i<size; i++) {
			//System.out.println(pQueue.getSize());
			currentProf = pQueue.deQueue();
			System.out.println("Current Professor: " + currentProf.getId() + "-" + currentProf.getName());
			String path = (currentProf.getId() +"_selection.txt");
			
			File file = new File(path);
			
			
			int maxWeeklyHours;
			int remainHours;
			boolean isMatch = false;
			List<String> list = new ArrayList<String>();
			
			
			try {
				file = new File(path); // use path
				
				Scanner myReader = new Scanner(file);
            
				
            	while (myReader.hasNextLine()) {
            		String line = myReader.nextLine();
            		list.add(line);
            	}
            myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred: N0 FILE");
				
				continue;
			}
			String[] requests = list.toArray(new String[0]);
			
			maxWeeklyHours = Integer.parseInt(requests[0]);
			
			
			// If number of hours >30 -> =30
			if (maxWeeklyHours > 30) {
				maxWeeklyHours = 30;
			}
			if (maxWeeklyHours < 0) {
				maxWeeklyHours = 0;
			}
			remainHours = maxWeeklyHours;
			
			ArrayList<Course> listOfAffectedCourses = new ArrayList<Course>();
			// Check selected courses
			
			for(int n =1; n<requests.length;n++) {
				
				if (remainHours == 0) {
					break;
				}
				
				String[] selectedCourse = requests[n].split(", ");
				String selectedCourseId = selectedCourse[0];
			
				int requestedGroups = Integer.parseInt(selectedCourse[1]);
				
				// If the course exists
				if(department.getCourseMap().containsKey(selectedCourseId)) {
					
					Course course = department.getCourseMap().get(selectedCourseId);
					
					int courseGroups = course.getNumberOfGroups();
					// Check if they match the course requirements
			
					
					if (currentProf.getSetOfDisciplines().contains(course.getDiscipline())) {
						isMatch = true;
					}
					
					
					if(isMatch==true) {
						
						System.out.println("- remain: "+ remainHours + " hours");
						System.out.println("- "+ selectedCourseId + ": remain " + courseGroups + " groups");
						
						short count = 0;
						while(courseGroups>0 && requestedGroups>0) {
							int h = remainHours - (course.getNumberOfHours()/15);
							if(h>=0) {
								remainHours = h;
								courseGroups--;
								requestedGroups--;
								count++;
							}
							else {
								
								break;
							}
						}
						
						Course changedCourse = new Course(course);
						int remainGroups = course.getNumberOfGroups() - count;
						changedCourse.setNumberOfGroups(remainGroups);
						department.getCourseMap().replace(selectedCourseId, changedCourse); // csDpt.courseMap.getCourseId().setNumGroups(5)
						
						
						
						course.setNumberOfGroups(count);
						listOfAffectedCourses.add(course);
						
						
						
						
						
						
						System.out.println("Added " + count + " groups of "+selectedCourseId);
						System.out.println("");
						
					// If doesn't match
					} else {
						System.out.println(selectedCourseId + ": No qualified for the course or No enough course hours ");
					}
					
					
					
				// If the course doesn't exist
				} else {
					System.out.println(selectedCourseId + ": Doesn't exist");
				}
						
				//reset isMatch
				isMatch = false;
			}
			
			currentProf.setListOfAffectedCourses(listOfAffectedCourses);
			
			System.out.println("- Last check: remain " + remainHours + " hours");
			System.out.println("DONE");
			System.out.println("----------------");
		}
		System.out.println("--------Department--------");
		System.out.println(department);
	}
}
					
					
				
				
			
							
							
							
							

					
							
					
			
		
		
		
		
		
		
		
		
		
	
