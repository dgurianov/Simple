package gud.example.structural.composite;

import java.util.ArrayList;
import java.util.List;
/*
Create tree structure (Composite) from objects and be capable to call one method recursively to traverse all tree beneath .
 */
public class CompositeSample {
    public static void main(String[] args) {
        ElectricityDepartment ed = new ElectricityDepartment("Newton", null);
        ElectricityDepartment ed1 = new ElectricityDepartment("Tesla",ed);
        ElectricityDepartment ed2 = new ElectricityDepartment("Tesla 1,5", ed1);
        ElectricityDepartment ed3 = new ElectricityDepartment("Newton  2.0", ed);
        ElectricityDepartment ed4 = new ElectricityDepartment("Analog  1.0", ed);
        //Taking ed1, or ed will  traverse all underlying  classes and call their print functions
        ed1.printAllChildren();
        ed.printAllChildren();
    }
}

//Composite\Leaf interface
interface Department{
    //Connect child dept to yourself
    void addToSelf(Department child);
    //Stream all children and call printAllChildren to create tree traverse
    void printAllChildren();
}


class ElectricityDepartment implements Department {
    private String departmentName;
    private List<Department> subdepartments = new ArrayList<>();

    public ElectricityDepartment(String departmentName, Department parent) {
        this.departmentName = departmentName;
        if (parent != null) {
            parent.addToSelf(this);
        }
    }

    @Override
    public void addToSelf(Department child) {
        if (child != null) subdepartments.add(child);
    }

    @Override
    public void printAllChildren() {
        if(!subdepartments.isEmpty()) {
            subdepartments.forEach(Department::printAllChildren);
        }
        System.out.println(" Electricity dept: --" + departmentName + "--");

    }
}
