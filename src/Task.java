import java.util.*;

/* a task in the organizer
 * used to hold a specific event or task for the user
 * is due by "deadline" and/or has urgency "rank"
 * 
 * each task must have a nontrivial string
 * 
 */
public class Task implements Comparable<Task> {
	private boolean completed;
	private String text;
	private int deadline;
	private int rank;
	private PriorityQueue<Notification> notificationQueue;
	
	//creates an urgent task
	public Task(String s) {
		this(s,0,0);
	}
	
	//creates a Task without a deadline
	public Task(String s, int priority) {
		this(s, 0, priority);
	}
	
	//generic constructor for implementing all the details.
	public Task(String s, int date, int priority) {
		if (s==null | s==""){
			throw new NullPointerException("Each Task must have a string.");
		}
		text = s;
		deadline = date;
		rank = priority;
		completed = false;
		notificationQueue = null;
	}
	
	public int getRank(int priority) {
		return rank;
	}
	public void setRank(int priority) {
		rank = priority;
	}
	
	//sets a notification to display to the user at the given time
	public void addNotification(int timeToDeadline) {
		if (this.deadline == 0) {
			System.out.println("This task has no deadline");
		}
	}
	
	//A notification node holds a time to warn the user about its task
	//it points to the next chronological notification
	private class Notification {
		public int time;
		public Notification next;
		
		public Notification(int timeToDisplay, Notification nextNoti) {
			this.time = timeToDisplay;
			this.next = nextNoti;
		}
	}
	
	//compares this task with another
	//allows order in the task queue
	public int compareTo(Task other) {
		if (other == null) {
			throw new IllegalArgumentException();
		}
		if (this.rank == 0) {
			return -1;
		}
		return(this.deadline - other.deadline);
	}
}


