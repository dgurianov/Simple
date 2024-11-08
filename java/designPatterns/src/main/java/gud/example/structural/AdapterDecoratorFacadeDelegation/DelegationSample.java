package gud.example.structural.AdapterDecoratorFacadeDelegation;

/*
Adapter or wrapper 	| Converts one interface to another so that it matches what the client is expecting
Decorator 	        | Dynamically adds responsibility to the interface by wrapping the original code
Delegation 	        | Support "composition over inheritance"
Facade 	            | Provides a simplified interface
 */

//In the example below  the class Window delegates the area() call to its internal Rectangle object (its delegate).
public class DelegationSample {
}

class Rectangle{
    int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int area(){
        return this.width*this.height;
    }
}

class Window{
    Rectangle bounds;

    public Window(Rectangle bounds) {
        this.bounds = bounds;
    }

    int area(){
        return bounds.area();
    }
}
