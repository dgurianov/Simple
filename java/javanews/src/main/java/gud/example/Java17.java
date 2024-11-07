package gud.example;

public class Java17 {
}
//Sealed types - manipulate with inheritance, restrict who can inherit.
abstract sealed class Shape permits Circle, Rectangle, Square {}
final class Circle extends Shape{}

sealed class Rectangle extends Shape permits TransparentRectangle, FilledRectangle{}
final class TransparentRectangle extends Rectangle{}
final class FilledRectangle extends Rectangle {}

non-sealed class Square extends Shape{}


