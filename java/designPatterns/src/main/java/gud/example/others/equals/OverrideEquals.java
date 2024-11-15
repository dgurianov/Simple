package gud.example.others.equals;

public class OverrideEquals {
    public static void main(String[] args) {
        String val = "CDE";
        ClassToOverrideEquals i1 = new ClassToOverrideEquals("ABC");
        ClassToOverrideEquals notI1 = new ClassToOverrideEquals("ABC");
        ClassToOverrideEquals i2 = new ClassToOverrideEquals(val);
        ClassToOverrideEquals i2Too = new ClassToOverrideEquals(val);
        System.out.println("i1 equals i2 %s".formatted(i1.equals(i2)));
        System.out.println("i2 equals i2Too %s".formatted(i2.equals(i2Too)));
        System.out.println("i2 equals i2 %s".formatted(i2.equals(i2)));
        System.out.println("i1 equals notI1 %s".formatted(i1.equals(notI1)));
    }

}


class ClassToOverrideEquals {
    public ClassToOverrideEquals(String value) {
        this.value = value;
    }

    private String value;


    @Override
    public boolean equals(Object obj) {
        //Check for null
        if(obj == null) return false;
        //this instance check
        if ( this == obj) return  true;
        //check for instanceof and value
        if( (obj instanceof ClassToOverrideEquals)  &&  ((ClassToOverrideEquals) obj).getValue() == this.value )  return true;

        return false;
    }


    public String getValue(){
        return this.value;
    }
}
