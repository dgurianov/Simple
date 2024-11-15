package gud.example.others.hashcode;

public class OverrideHashcode {
    /*
    Hashcode general contracts
    1) If two obejcts are equal by equals() method then the hashcode returned by hasCode() must be the same
    2)Whenever the hashcode method is invoked on the same Object more then once within a single execution of the application  ,
    it must return the same integer. It has to be guaranteed that none of the fields used in equals or haschode methods were modified.
    3) IF two objects are not equal by equals() , it is not required that their hascode has to be different.
    However,  it is always a good practice to return different hashcode for unequal objects.
    Different hashcode for different objects can improve performance of hashmap and hashtable by reducing collisions.


     Prime number - is a natural number greater then 1 , that is not a product of two smaller natural numbers.

     Pseudo-code :
     1. Take a prime hash 5 , 7 , 17 or 31 (prime number as hash results in distinct hashcode for distinct objects)
     2. Take another prime, that differs from prev one ,  as multiplier
     3. Compute hashcode for each member and add them into final hash . Repeat this for all value members that participate in equals() comparison
     4. Return hash


     */


}


class  OverrideHashcodeWithFields{
    private String name ;
    private String address ;
    private int id;
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 17 * hash + (this.address != null ? this.address.hashCode():0);
        hash = 17 * hash + (this.id^(this.id>>>32));
        return hash;

    }
}
