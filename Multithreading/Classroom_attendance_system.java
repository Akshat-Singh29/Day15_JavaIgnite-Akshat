class Classroom {
    private boolean attendanceStarted = false;

    // Student waits until teacher starts attendance
    public synchronized void waitForAttendance() {
        while (!attendanceStarted) {
            try {
                System.out.println(Thread.currentThread().getName() + " : Student Waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : Student Marked Present");
    }

    // Teacher starts attendance and notifies all students
    public synchronized void startAttendance() {
        attendanceStarted = true;
        System.out.println("Teacher Started Attendance");
        notifyAll();
    }
}

// Teacher Thread
class TeacherThread extends Thread {
    private Classroom classroom;

    public TeacherThread(Classroom classroom) {
        this.classroom = classroom;
    }

    public void run() {
        classroom.startAttendance();
    }
}

// Student Thread
class StudentThread extends Thread {
    private Classroom classroom;

    public StudentThread(Classroom classroom, String name) {
        super(name);
        this.classroom = classroom;
    }

    public void run() {
        classroom.waitForAttendance();
    }
}

// Main Class
public class AttendanceSystem {
    public static void main(String[] args) {
        Classroom classroom = new Classroom();

        // Create student threads
        StudentThread s1 = new StudentThread(classroom, "Student-1");
        StudentThread s2 = new StudentThread(classroom, "Student-2");
        StudentThread s3 = new StudentThread(classroom, "Student-3");

        // Create teacher thread
        TeacherThread teacher = new TeacherThread(classroom);

        // Start students first
        s1.start();
        s2.start();
        s3.start();

        // Wait for a few seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start teacher thread
        teacher.start();
    }
}/*
Classroom Attendance System

Teacher thread:

Takes attendance

Student thread:

Waits until attendance starts
Requirements
Students should not proceed immediately.
Students must wait.
Teacher gives signal.
Students continue after signal.

Expected Flow:

Student Waiting...

Teacher Started Attendance

Student Marked Present
Concepts Tested
wait()
notifyAll()


Instructions - 
Create Class Classroom

    Variable:
        attendanceStarted = false

    synchronized method waitForAttendance()

        While attendanceStarted is false

            Print:
                "Student Waiting..."

            wait()

        Print:
            "Student Marked Present"


    synchronized method startAttendance()

        attendanceStarted = true

        Print:
            "Teacher Started Attendance"

        notifyAll()


Create Class TeacherThread

    Classroom classroom

    run()

        classroom.startAttendance()


Create Class StudentThread

    Classroom classroom

    run()

        classroom.waitForAttendance()


Main Method

    Create Classroom object

    Create multiple Student threads

    Create Teacher thread

    Start Student threads

    Wait for a few seconds

    Start Teacher thread
Thread Coordination
Synchronization
*/
