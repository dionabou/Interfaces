// BigRectangleFilter.java
import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) x;
            return rectangle.getWidth() + rectangle.getHeight() > 10;
        }
        return false;
    }
}
