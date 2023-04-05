package lk.ijse.dep10.oop.exersice;

public class Exercise5 {
    static{
        System.out.println("Exercise05 template is being initialized - 01");        //done
    }

    static Course[] courses = initializeCourses();      //done

    static{
        System.out.println("Exercise05 template is being initialized - 02");        //done
    }
    private static Course[] initializeCourses(){
        System.out.println("Initializing Courses");     //done
        Course[] courses = new Course[3];           //done
        courses[0] = new Course("DEP", "Direct Entry Program");     //done
        courses[1] = new Course("CMJD", "Comprehensive Master Java Developer", "Kanishka"); //done
        courses[2] = new Course("GDSE", "Graduate Diploma in Software Engineering");        //done
        return courses;
    }

    public static void main(String[] args) {
        for (Course course : courses) {
            System.out.println(course.id + " : " +  course.coordinator);
        }
    }
}

class Course{
    String id;
    String name;
    String coordinator;
    static String[] coordinators = {"Kasun", "Nuwan"};  //done
    static int i;       //done

    static{
        System.out.println("Course template is being initialized");     //done
    }

    public Course(String id, String name) {
        this(id, name, getCoordinator());       //here
        System.out.printf("Course id: %s, name: %s created! \n", id, name);
    }

    public Course(String id, String name, String coordinator){
        this.id = id;
        this.name = name;
        this.coordinator = coordinator;
    }

    private static String getCoordinator(){
        if (i >= coordinators.length) i = 0;
        return coordinators[i++];
    }
}
