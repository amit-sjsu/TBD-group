import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Level
{
    
    private ArrayList<IEdge> selectedPath  = new ArrayList<IEdge>();
    public IEdge [] solution;

    /**
     * Constructor for objects of class Level1.
     * 
     */
    private int timer=1200;
    Timer timerText = new Timer();
   
    private House house[]= new House[6];
    private Path path[] = new Path[8];
    Counter counter;
    Submit submit, submit2;

    public Level1()
    {
        GreenfootImage level = new GreenfootImage("grassBackground.jpg");
        level.scale(getWidth(), getHeight());
        setBackground(level);
        prepare();
        setupObjects();

    }

    public void setupObjects(){
        System.out.println("Loading Level 1:");
        house[0] = new House(350, 235);
        house[0].setId(0);
        addObject(house[0], house[0].getPoint().getX(), house[0].getPoint().getY());
        house[1] = new House(700, 200);
        house[1].setId(1);
        addObject(house[1], house[1].getPoint().getX(), house[1].getPoint().getY());
        house[2] = new House(830, 293);
        house[2].setId(2);
        addObject(house[2], house[2].getPoint().getX(), house[2].getPoint().getY());
        house[3] = new House(500, 488);
        house[3].setId(3);
        addObject(house[3], house[3].getPoint().getX(), house[3].getPoint().getY());
        house[4] = new House(154, 323);
        house[4].setId(4);
        addObject(house[4], house[4].getPoint().getX(), house[4].getPoint().getY());
        house[5] = new House(264, 609);
        house[5].setId(5);
        addObject(house[5], house[5].getPoint().getX(), house[5].getPoint().getY());
        path[0] = new Path(house[1], house[3]);
        path[1] = new Path(house[4], house[0]);
        path[2] = new Path(house[3], house[2]);
        path[3] = new Path(house[4], house[2]);
        path[4] = new Path(house[0], house[1]);
        path[5] = new Path(house[5], house[3]);
        path[6] = new Path(house[0], house[3]);
        path[7] = new Path(house[5], house[4]);

        addObject(path[0], 0,0);
        addObject(path[1], 0,0);
        addObject(path[2], 0,0);
        addObject(path[3], 0,0);
        addObject(path[4], 0,0);
        addObject(path[5], 0,0);
        addObject(path[6], 0,0);
        addObject(path[7], 0,0);
        
        path[0].layoutBlock();
        path[1].layoutBlock();
        path[2].layoutBlock();
        path[3].layoutBlock();
        path[4].layoutBlock();
        path[5].layoutBlock();
        path[6].layoutBlock();
        path[7].layoutBlock();

        
        int c = 0;
        System.out.println("Initial");
        for(Path pat : path)
        {
             pat.setSubmitObserver(submit2);
        }
        
        Graph graph = new Graph(6, 8);
        graph.addEdges(path[0]);
        graph.addEdges(path[1]);
        graph.addEdges(path[2]);
        graph.addEdges(path[3]);
        graph.addEdges(path[4]);
        graph.addEdges(path[5]);
        graph.addEdges(path[6]);
        graph.addEdges(path[7]);

        IEdge[] paths = graph.GetMinimalSpanningEdges();
        //Path[] selectedPaths = new Path[3]; //test path
        int totalLen = paths.length;
        int counter = 0;
        System.out.println("minimal spanning tree" + " len: "+ paths.length );
        for(IEdge path : paths)
        {
            counter++;
             
            System.out.println("count : " + counter + " " + path.getWeight() + " id: " + path.getId());
        }
        /*for(IEdge path : paths)
        {
            int src = path.getSrc();
            int des = path.getDest();
            for(Path selPath : selectedPaths)
            {
                if(src == selPath.getSrc() && des == selPath.getDest())
                    counter++;
                    
            }
            
        }*/
        /*submit2.solution =  paths;
        String result= "Loose";
        if(counter == totalLen && paths.length == selectedPaths.length)
            result = "Win";*/
            
        
        
    }
    

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(timerText, 874, 38);
        timerText.setTime("Time left: " + (timer/60));
        counter = new Counter();
        addObject(counter,94,51);
        //counter.setCounter("Score: " + (0));
     
        submit = new Submit();
        addObject(submit,775,695);
        removeObject(submit);
        submit2 = new Submit();
        addObject(submit2,869,729);
      
    }
    
    
    public void act()
    {
        timer-=6;
        if (timer%60==0) 
        {
            timerText.setTime("Time left: " + (timer/60));
        }
        if(timer==0)
        {
            
           
            Greenfoot.stop();
          
           
        }
        
        
    }
    
}
