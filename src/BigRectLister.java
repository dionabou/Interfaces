// BigRectLister.java
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;  // Add this import for Arrays
import java.util.List;    // Add this import for List

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(4, 2));
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(5, 1));
        rectangles.add(new Rectangle(3, 4));
        rectangles.add(new Rectangle(6, 7));
        rectangles.add(new Rectangle(2, 9));
        rectangles.add(new Rectangle(1, 8));
        rectangles.add(new Rectangle(3, 3));
        rectangles.add(new Rectangle(2, 6));

        Filter bigRectangleFilter = new BigRectangleFilter();
        List<Object> bigRectangles = collectAll(rectangles.toArray(), bigRectangleFilter);

        System.out.println("Big rectangles: " + bigRectangles);
    }

    public static List<Object> collectAll(Object[] objects, Filter filter) {
        return Arrays.asList(objects).stream()
                .filter(filter::accept)
                .toList();
    }
}
