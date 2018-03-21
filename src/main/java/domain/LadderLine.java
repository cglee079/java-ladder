package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int countOfPersons) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(countOfPersons, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    public List<Point> getPoints() {
        return this.points;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initBody(int countOfPersons, List<Point> points, Point point) {
        for (int i = 1; i < countOfPersons - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    @Override
    public String toString() {
        return "LadderLine{" + "points = " + points + '}';
    }
}