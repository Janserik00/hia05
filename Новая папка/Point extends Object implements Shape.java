public class Point extends Object implements Shape {
    private int x;
    private int y;
     
    public Point (int xValue, int yValue){
        x = xValue;
        y = yValue;
    }
     
    public void setX (int xValue){
        x = xValue;         
    }
     
    public int getX(){
        return x;
    }
     
    public void setY(int yValue){
        y = yValue;
    }
     
    public int getY(){
        return y;
    }
     
    public double getArea(){
        return 0.0;         
    }
     
    public double getVolume(){
        return 0.0;
    }
     
    public String getName(){
        return "Point";         
    }
     
    public String toString(){
        return "[" + getX() + ", " + getY() + "]";
    }
}

public class Circle extends Point{
    private double radius;
     
    public Circle (int x, int y, double radiusValue){
        super (x, y);
        setRadius(radiusValue);
    }
     
    public void setRadius (double radiusValue){
        radius = (radiusValue < 0.0 ? 0.0 : radiusValue);
    }
     
    public double getRadius(){
        return radius;
    }
     
    public double getDiameter(){
        return 2*getRadius();
    }
     
    public double getCircumference(){
        return Math.PI*getDiameter();
    }
     
    public double getArea(){
        return Math.PI * getRadius() * getRadius();
    }
     
    public String getName(){
        return "Circle";
    }
     
    public String toString(){
        return "Center = " + super.toString() + "; Radius = " + getRadius();
    }
}
public class Cylinder extends Circle{
    private double height;
     
    public Cylinder (int x, int y, double radius, double heightValue){
        super(x, y, radius);
        setHeight(heightValue);
    }

    public void setHeight(double heightValue){
        height = (heightValue < 0.0 ? 0.0 : heightValue);
    }
     
    public double getHeight(){
        return height;
    }
     
    public double getArea(){
        return 2 * super.getArea() + getCircumference() * getHeight();
    }
     
    public double getVolume(){
        return super.getArea() * getHeight();
    }
     
    public String getName(){
        return "Cylinder";
    }
     
    public String toString(){
        return super.toString() + "; Height = " + getHeight();
    }
}