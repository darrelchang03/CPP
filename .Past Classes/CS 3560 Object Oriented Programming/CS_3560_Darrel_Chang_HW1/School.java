import java.util.*;

public class School {

    private List<Class> classList;
    private List<Instructor> instructorList;
    private List<LectureHall> lectureHallList;

    
    /** 
     * @param className name of Class
     * @param instructor Instructor to be assigned to class
     * @param lectureHall Lecture hall to be assigned to class
     * @return Class
     */
    public Class createClass(String className, Instructor insturctor, LectureHall lectureHall) {

    }

    /**
     * Deletes class
     * @param className name of class to be deleted
     */
    public void deleteClass(String className) {

    }

    /**
     * @param lectureHallName
     * @return LectureHall object
     */
    public LectureHall createLectureHall(String lectureHallName, String location) {

    }

    /**
     * Deletes lecture hall
     * @param lectureHall name of lecture hall to be deleted
     */
    public void deleteLectureHall(String lectureHallName) {

    }

    /**
     * Creates an instance of Instructor class
     * @param instructorName Name of instructor to be created
     * @return Instructor object
     */
    public Instructor hireInstructor(String instructorName) {

    }

    /**
     * Deletes instructor
     * @param instructorName Name of instructor to be deleted
     */
    public void terminateInstructor(String instructorName) {

    }

    /**
     * Creates an instance of Student class
     * @param name Name of student
     * @return Students to be created
     */
    public Student admitStudent(String studentName) {

    }

    /**
     * Deletes students
     * @param studentID ID number of student to be deleted
     */
    public void releaseStudent(int studentID) {

    }
    /**
     * Outputs all courses 
     */
    public void generateCourseCatalog() {

    }
}