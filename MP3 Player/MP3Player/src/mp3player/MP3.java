package mp3player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

public class MP3 {
    private String filename;
    private Player player;
    String title;
    
    public long pauseLocation;
    public long songTotalLength;
    public String fileLocation;
    public float time;
    public String s1;
    public String s2;
    public int minute;
    public int second;
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public MP3(String filename){
        this.filename=filename;
    }
    
    public void close(){
        if(player!=null)
            player.close();
          pauseLocation = 0;
          songTotalLength = 0;
    }
    
    public void pause(){
      if(player != null){
          try {
              pauseLocation = FIS.available();
              s2 = String.format("%.02f", (float)pauseLocation /1000000);
              player.close();
          } catch (IOException ex) {
          }        
      }
  }
    
    public void play(){
        try{
           FIS=new FileInputStream(filename);
           BIS=new BufferedInputStream(FIS);
           
           player = new Player(BIS);
           
          songTotalLength = FIS.available(); 
          s1 = String.format("%.02f", (float)songTotalLength/1000000);          
          fileLocation = filename+"";
        }catch(Exception e){
            System.out.println("Problem loading File: "+filename);
            System.out.println(e);
        }       
        new Thread(){
            public void run(){
            try{
            player.play();
        }catch(Exception e){
            System.out.println(e);
        }
        }
        }.start();        
    }
    
    
    public void resume(){
        try{
           FIS=new FileInputStream(filename);
           BIS=new BufferedInputStream(FIS);
           
           player = new Player(BIS);
           FIS.skip(songTotalLength-pauseLocation);
          
        }catch(Exception e){
            System.out.println("Problem loading File: "+filename);
            System.out.println(e);
        }        
        new Thread(){
            public void run(){
            try{
            player.play();
        }catch(Exception e){
            System.out.println(e);
        }
        }
        }.start();
        
    }
      
}
