import java.text.DecimalFormat;
public class ShapeTest {
    public static void main(String[] args){
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        Point point = new Point (7, 11);
        Circle circle = new Circle (22, 8, 3.5);
        Cylinder cylinder = new Cylinder (20, 30, 3.3, 10.75);
         
        String output = point.getName() + ": " + point + "\n" +
                circle.getName() + ": " + circle + "\n" +
                cylinder.getName() + ": " + cylinder + "\n";
         
        Shape[] arrayOfShapes = new Shape [3];
         
        arrayOfShapes[0] = point;
        arrayOfShapes[1] = circle;
        arrayOfShapes[2] = cylinder;

         
        for (int i = 0; i < arrayOfShapes.length; i++){
            output += "\n\n" + arrayOfShapes[i].getName() + ": " +  
                    arrayOfShapes[i].toString() + "\nArea = " +
                    twoDigits.format(arrayOfShapes[i].getArea()) + "\nVolume = " +  
                    twoDigits.format(arrayOfShapes[i].getVolume());
                    //arrayOfShapes[i].getArea() + "\nVolume = " +  
                    //arrayOfShapes[i].getVolume();
        }
         
        System.out.println(output);
    }
}