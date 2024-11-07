package gud.example;

public class Java16 {
    public static void main(String[] args) {
        //Pattern matching for instanceof
        String obst = "papap";
        Object obj = (Object) obst;

        //Before
        if(obj instanceof String){
            String s = (String) obj;
            s.equalsIgnoreCase("mama");
        }
        //After
        if(obj instanceof String patternMatched){
            patternMatched.equalsIgnoreCase("lolol");
        }else {
            System.out.println("Variable patternMatched is OUT of SCOPE here!!");
        }
    }



}

//Regular class
class Student{
    private String name;
    private String studentClass;

    public Student(String name, String studentClass) {
        this.name = name;
        this.studentClass = studentClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public boolean equals(Object o) {
        //Overriden Equals
        return true;
    }

    @Override
    public int hashCode() {
        //Overriden hashcode
        return 10;
    }
}
//Record class
record StudentRecord(String name, String studentClass){}



