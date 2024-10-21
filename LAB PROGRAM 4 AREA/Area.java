import java.util.Scanner;
abstract class shape{
double dim1;
double dim2;
public shape(double dim1,double dim2){
this.dim1=dim1;
this.dim2=dim2;
}
abstract void printArea();
}
class Rectangle extends shape{
public Rectangle(double length, double breadth){
super(length ,breadth);
}
void printArea(){
double area=dim1*dim2;
System.out.println("Area of Rectangle="+area);
}
}
class Triangle extends shape{
public Triangle(double base,double height){
super(base,height);
}
void printArea(){
double area=0.5*dim1*dim2;
System.out.println("Area of Triangle="+area);
}
}
class Circle extends shape{
public Circle(double radius){
super(radius,0);
}
void printArea(){
double area=3.14*dim1*dim1;
System.out.println("Area of Circle="+area);
}
}
public class Area{
public static void main(String args[]){
Scanner scanner=new Scanner(System.in);
System.out.println("Enter the dimensions of rectangle(length and breadth):");
double rectlength=scanner.nextDouble();
double rectbreadth=scanner.nextDouble();
shape rectangle=new Rectangle(rectlength,rectbreadth);
rectangle.printArea();

System.out.println("Enter the dimensions of the triangle (base and height):");
double tribase=scanner.nextDouble();
double triheight=scanner.nextDouble();
shape triangle=new Triangle(tribase,triheight);
triangle.printArea();

System.out.println("Enter the dimensions of the circle (radius):");
double cirradius=scanner.nextDouble();
shape circle=new Circle(cirradius);
circle.printArea();
System.out.println("Lakshith P");
System.out.println("1BM23CS164");
}
}