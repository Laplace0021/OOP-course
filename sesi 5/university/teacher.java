
public class teacher extends person {
    private int numCourses=0;
    private String[] courses= new String [20];
    
    public teacher(String name, String address){
        super(name,address);
    }

    public boolean addCourse(String course){
        for(int i =0; i<numCourses;i++){
            if (courses[i].equals(course)){
                return false;
            }
        }
        if(numCourses<course.length()){
            courses[numCourses]=course;
            numCourses++;
            return true;
        }
        return false;
    }

    public boolean removeCourse(String course){
        for (int i =0; i<numCourses;i++){
            if (courses[i].equals(course)){
                for(int j=i;j<numCourses-1;j++){
                    courses[j]=courses[j+1];
                }
                courses[numCourses-1]=null;
                numCourses--;
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString(){
        return "Teacher: " +super.toString();
    }
}
