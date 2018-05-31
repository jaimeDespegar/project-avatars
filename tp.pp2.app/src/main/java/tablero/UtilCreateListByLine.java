package tablero;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class UtilCreateListByLine {
	public static List<Point> createList(Point point1, Point point2){
		List<Point> points = new ArrayList<Point>();
		points.add(point1);
		points.add(point2);
		return points;
	}
}
