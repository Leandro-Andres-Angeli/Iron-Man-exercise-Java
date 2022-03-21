/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author kurco
 */
public class Radar {
    private boolean [][][] radarDimension ;
    
    public Radar() {
       radarDimension = new boolean[20][20][20];
          
       
        
    }

    public Radar(boolean [][][] radarDimension) {
        this.radarDimension = radarDimension;
    }

    public boolean[][][] getRadarDimension() {
        return radarDimension;
    }

    public void setRadarDimension(boolean[][][] radarDimension) {
        this.radarDimension = radarDimension;
    
    }
    
    public Radar setRadarPosition(boolean val ,int x ,int y , int z ){
     this.radarDimension[x][y][z]=val;
     return this;
    }

  

   

   
}
