import java.util.*;

/* The Organizer
 * holds information about upcoming tasks and events for the user
 * displays that information in order of urgency
 */
public class Organizer {
	private PriorityQueue<Task> toDoList; //can point to past events
	private PriorityQueue<Task> completedList; //points to next upcoming task in time
	
	//add a new Task to the toDoList
	public void addTask(String toDo) {
		addTask(toDo, 0, 0);
	}
	public void addTask(String toDo, int priority) {
		addTask(toDo, 0, priority);
	}
	public void addTask(String toDo, int date, int priority) {
		toDoList.add(new Task(toDo, date, priority));
	}
	
	//move the head task from the toDoList to the completedList
	public void finishTask(Task task) {
		completedList.add(toDoList.poll());
	}
	
	//return the most urgent task
	public Task top() {
		return toDoList.peek();
	}
}
