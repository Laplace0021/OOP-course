public class student extends person {
    private int numCourses=0;
    //menetapkan ukuran maksimum array ke 40
    private String[] courses= new String[40];
    private int[] grades= new int[40];

    public student(String name, String address){
        super(name,address);
    }

    public void addCourseGrade(String course, int grade){
        if(numCourses<40){
            courses[numCourses]=course;
            grades[numCourses]=grade;
            numCourses++;
            System.out.println("Course Grade telah ditambahkan");
        }
    }

    public void printGrades(){
        System.out.println("Courses\t\tGrade"
        );
        for (int i =0; i<numCourses;i++){
            System.out.println(courses[i]+" :\t\t "+grades[i]);   
        }
    }

    public double getAverageGrade(){
        if (numCourses == 0) {
            return 0.0; 
        }
        int sum=0;
        for(int i =0; i<numCourses;i++){
            sum+=grades[i];
        }
        return (double)sum/numCourses;
    }
    public String toString(){
        return "Student: "+super.toString();
    }
}
