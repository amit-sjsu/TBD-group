import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Actor
{
    // instance variables - replace the example below with your own
    private Point point;

    /**
     * Constructor for objects of class House
     */
    public House(int x, int y)
    {
        point = new Point(x,y);
    }

    
    public Point getPoint(){
        return point;
    }
    public void setPoint(int x, int y){
        point.setX(x);
        point.setY(y);
    }
}