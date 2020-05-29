package Tanks;

// Used from Pong project
public interface Locatable 
{
    public void setPos( double x, double y);
    public void setX( double x );
    public void setY( double y );

    public double getX();
    public double getY();
}
