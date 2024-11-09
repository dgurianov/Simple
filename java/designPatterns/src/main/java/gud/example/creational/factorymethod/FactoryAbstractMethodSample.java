package gud.example.creational.factorymethod;

public class FactoryAbstractMethodSample {
}

/*

the Factory method can be a method in all regular classes with different purposes.
But the Abstract Factory is an class/object used by a client and is ONLY responsible for creating some products in a family
it's a single method name, with multiple overrides in subclasses. It's not a single stand-alone method definition.
The example code demonstrates this with two implementations of makeFoo
*/

//Products structure
class Foo {
    public void whatever() {
        System.out.println("whatever");
    }
}

class RegularFoo extends Foo {
}

class SpecialFoo extends Foo {
}


//Usages of products
class Abcde {

    protected Foo makeFoo() {
        return new RegularFoo();
    }
}

class B extends Abcde {

    //Factory method - call overriden implementations bei being abstracted to the top parent class.
    protected Foo makeFoo() {
        //subclass is overriding the factory method
        //to return something different
        return new SpecialFoo();
    }
}


