package gud.example;

public class Java20 {
    /*
    1. Record Patterns (Preview)
Record patterns extend pattern matching to destructure record values directly in patterns.

    You can use a record pattern to test whether a value is an instance of a record class type (see Record Classes) and, if it is, to recursively perform pattern matching on its component values.
    The following example tests whether obj is an instance of the Point record with the record pattern Point(double x, double y):
*/

    record Point(double x, double y) {}

    static void printAngleFromXAxis(Object obj) {
        if (obj instanceof Point(double x, double y)) {
            System.out.println(Math.toDegrees(Math.atan2(y, x)));
        }
    }


/*


2. Preview feature from Java SE 17 re-previewed for this release.

In this release:

An exhaustive switch (that is, a switch expression or a pattern switch statement) over an enum class throws a MatchException instead of an IncompatibleClassChangeError if no switch label applies at run time.
The grammar for switch labels is simpler.
The compiler can infer the type of the type arguments for generic record patterns in all constructs that accept patterns: switch statements and expressions, instanceof expressions, and enhanced for statements.
     */

    public static double getPerimeter(Shape s) throws IllegalArgumentException {
        return switch (s) {
            case Rectangle r -> 2 * r.length() + 2 * r.width();
            case Circle c    -> 2 * c.radius() * Math.PI;
            default          -> throw new IllegalArgumentException("Unrecognized shape");
        };
    }


    class Shape {
        public double length() {
            return 0;
        }

        public double width() {
            return 0;
        }

        public double radius() {
            return 0;
        }
    }

    class Rectangle extends Shape {
        private double length;
        private double width;

        public double length() {
            return length;
        }

        public double width() {
            return width;
        }
    }

    class Circle extends Shape {
        private double radius;

        public double radius() {
            return radius;
        }
    }
}
