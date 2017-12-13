import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool
/**
 * Write a description of class IrregularPolygon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AllenZhu implements Polygon
{
    private ArrayList <Point2D.Double> myPolygon;
    private SketchPad myPaper;
    private DrawingTool myPencil;
    private double perimeter;
    private double area;
    private String name;
    // constructors
    public AllenZhu() 
    {
        myPolygon = new ArrayList<Point2D.Double>();
        myPaper = new SketchPad(500, 500);
        myPencil = new DrawingTool(myPaper);
        perimeter = 0.0;
        area = 0.0;
        name = "Allen Zhu";
    }

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public void draw()
    {
        myPencil.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
        myPencil.down();
        for (int i = 1; i < myPolygon.size(); i++)
        {
            myPencil.move(myPolygon.get(i).getX(), myPolygon.get(i).getY());
            myPencil.down();
        }
        //myPencil.down();
        myPencil.move(myPolygon.get(0).getX(), myPolygon.get(myPolygon.size() - 1).getY());
        myPencil.down();
    }

    public double perimeter()
    {
        for (int i = 0; i < myPolygon.size() - 1; i++)
        {
            double x1 = myPolygon.get(i).getX();
            double x2 = myPolygon.get(i + 1).getX();
            double y1 = myPolygon.get(i).getY();
            double y2 = myPolygon.get(i + 1).getY();
            perimeter += Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            if (i == myPolygon.size() - 2)
            {
                x1 = myPolygon.get(myPolygon.size() - 1).getX();
                x2 = myPolygon.get(0).getX();
                y1 = myPolygon.get(myPolygon.size() - 1).getY();
                y2 = myPolygon.get(0).getY();
                perimeter += Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                break;
            }
        }

        return perimeter;
    }

    public double area()
    {
        double value = 0.0;
        for (int i = 0; i < myPolygon.size() - 1; i++)
        {
            value += myPolygon.get(i).getX() * myPolygon.get(i + 1).getY();
        }
        for (int j = 0; j < myPolygon.size() - 1; j++)
        {
            value -= myPolygon.get(j).getY() * myPolygon.get(j + 1).getX();
        }
        area = 0.5 * (Math.abs(value));
        return area;
    }

    public String getName()
    {
        return name;
    }
}
