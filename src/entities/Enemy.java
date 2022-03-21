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

public class Enemy {
    private boolean hostility;
    private int   position[];
    private int resistance;
    private int idEnemy;
    private float  distance;
  

 

    public Enemy(boolean hostility, int[] position, int resistance, int idEnemy,float distance) {
        this.hostility = hostility;
        this.position = position;
        this.resistance = resistance;
        this.idEnemy = idEnemy;
        this.distance = distance;
     
        
    }

    public Enemy() {
     
        idEnemy= (int)(Math.random() * ((300 - 100) + 1)) + 100;
        resistance =(int)(Math.random() * ((100 - 40) + 1)) + 40;   
        hostility= (int) Math.ceil(Math.random()*10) >= 5  ;
        position = new int []{(int)(Math.random() * ((3 - 0) + 0)) + 1,(int)(Math.random() * ((3 - 0) + 0)) + 1,(int)(Math.random() * ((3 - 0) + 0)) + 0};
        distance = (float) Math.round(Math.sqrt(Math.pow(position[0],position[0]) + Math.pow(position[1],position[1])+Math.pow(position[2],position[2])));
   
    }
    public Enemy getElementById(int query){
        Enemy e=null;
        if(e.idEnemy == query ){
        return  e;
        }
        else return null;
    }
    public boolean isHostility() {
        return hostility;
    }

    public void setHostility(boolean hostility) {
        this.hostility = hostility;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int getResistance() {
        return resistance;
    }
      public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getIdEnemy() {
        return idEnemy;
    }

    public void setIdEnemy(int idEnemy) {
        this.idEnemy = idEnemy;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Enemy{" + "hostility=" + hostility + ", position= " + position[0]+" "+position[1]+" "+position[2] + " , resistance=" + resistance + ", idEnemy=" + idEnemy + ", distance=" + distance + '}';
    }

   

    
     
 
}
        
