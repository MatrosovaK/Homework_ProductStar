package geometry;

/**
 * Заполните этот класс в соответсвии с заданием из лекции.
 */
public class Circle {
   protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double newRadius) {
        if (newRadius <= 0) {
            throw new IllegalArgumentException("radius cannot be less than 0");
        }
        this.radius = newRadius;
    }

    public double getArea(){
        return Math.PI * radius * radius;

    }

}

