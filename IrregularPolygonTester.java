import java.awt.geom.*;
/**
 * Write a description of class IrregularPolygonTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IrregularPolygonTester
{
    public static void main(String[] args)
    {
        IrregularPolygon polygon = new IrregularPolygon();
        System.out.print(polygon.getName("Allen Zhu"));
        polygon.add(new Point2D.Double(0, 0));
        //polygon.add(Point2D.Double(0,0));
        
    }
}
