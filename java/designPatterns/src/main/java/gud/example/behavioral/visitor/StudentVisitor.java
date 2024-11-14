package gud.example.behavioral.visitor;

public class StudentVisitor {
    public static void main(String[] args) {
        TeacherVisitor teacher = new MathTeacher();
        Student mStudent = new MathStudent();
        Student swStudent = new SwimmingStudent();

        mStudent.accept(teacher);
        swStudent.accept(teacher);
    }

}

interface Student{
    void accept(TeacherVisitor t);
}

class MathStudent implements  Student{

    @Override
    public void accept(TeacherVisitor t) {
        t.check(this);
    }
}

class SwimmingStudent implements Student{

    @Override
    public void accept(TeacherVisitor t) {
        t.check(this);
    }
}

interface TeacherVisitor{
    void check(MathStudent student);
    void check(SwimmingStudent student);

}

class MathTeacher implements TeacherVisitor{
    @Override
    public void check(MathStudent student) {
        System.out.println("Math homework passed.");
    }

    @Override
    public void check(SwimmingStudent student) {
        System.out.println("Math homework failed");
    }
}
