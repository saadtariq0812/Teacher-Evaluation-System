package dsproject;

public class Ratings {
    String teachername; // use this later 
    String coursename;
    String grading;
    String learning;
    String workload;
    Comments comments;

    public Ratings(String teachername, String coursename,String grading,String learning, String workload, Comments comments){
            this.teachername = teachername;
            this.coursename = coursename;
            this.grading = grading;
            this.learning = learning;
            this.workload = workload;
            this.comments = comments;
    }

    public void displayRatings(){
        System.out.println("Course: " + coursename);
        System.out.println("Grading :" + grading +"/5");
        System.out.println("Learning :" + learning +"/5");
        System.out.println("Workload :" + workload +"/5");
    }
    public String getCourseName(){
        return coursename;
    }
    public String getGrading(){
        return grading;
    }
    public String getLearning(){
        return learning;
    }
    public String getWorkload(){
        return workload;
    }
    public String getTeacherName(){
        return teachername;
    }
}
