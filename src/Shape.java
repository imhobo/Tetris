import java.awt.*;
import java.util.List;
import java.util.logging.Logger;


/**
 * Created by Safal on 27 Mar, 2018
 */

public abstract class Shape {

  public enum ORIENTATION {
    ZERO, NINETY, ONE80, TWO70
  }

  protected int id;
  protected ORIENTATION orientation;
  protected Rectangle rectangle;
  protected List<Point> filledPoints;

  protected void resolveReferences() throws Exception {
    if(!Util.checkNotNull(filledPoints)) {
      throw new Exception("Filled Points is null");
    }
    if(!Util.checkNotNull(rectangle)) {
      throw new Exception("Rectangle is null");
    }

    filledPoints.stream().forEach(p -> {
      if(!rectangle.contains(p)) {
        try {
          throw new Exception(String.format("Point is out of bounds of the rectangle <%d, %d> ", p.x, p.y));
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    });
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ORIENTATION getOrientation() {
    return orientation;
  }

  public void setOrientation(ORIENTATION orientation) {
    this.orientation = orientation;
  }

  public Rectangle getRectangle() {
    return rectangle;
  }

  public void setRectangle(Rectangle rectangle) {
    this.rectangle = rectangle;
  }

  public List<Point> getFilledPoints() {
    return filledPoints;
  }

  public void setFilledPoints(List<Point> filledPoints) {
    this.filledPoints = filledPoints;
  }
}
