/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Enemy;
import java.util.Scanner;

/**
 *
 * @author kurco
 */
public class Attack {

    public int selectEnemyFunction() {
        int inputResponse = 0;
        Scanner read = new Scanner(System.in);
        System.out.println("Seleccione enemigo por ID");
        inputResponse = read.nextInt();
        return inputResponse;

    }

    public Enemy findEnemy(int id, Enemy[] enemiesArray,int attackTime) {
        Enemy ReturnedEnemy = null;
        for (int i = 0; i < enemiesArray.length; i++) {
             
            if (enemiesArray[i].getIdEnemy() == id ) {
                 ReturnedEnemy = enemiesArray[i];
                
                if(ReturnedEnemy.getDistance()<= 5.5 && ReturnedEnemy.isHostility()==true){
             
                
              
               
                ReturnedEnemy.setResistance(ReturnedEnemy.getResistance()-attackFunction(ReturnedEnemy.getDistance(),attackTime));
                System.out.println(ReturnedEnemy.toString());
               
                }
                else if(ReturnedEnemy.isHostility()==false){
                    System.out.println("enemigo no hostil");
                   
                }
                else if(ReturnedEnemy.getDistance() > 5.5){
                    System.out.println("enemigo demasiado lejos");
                   
                }
              }  
         
        }
        return ReturnedEnemy;
    }

    public int attackFunction(double distance,int attackTime) {

        if (distance <= 2) {
            return 30 * attackTime;
        } else if (distance > 2 && distance < 2.5) {
            return 25 * attackTime;
        } else if (distance >= 2.5 && distance <= 4) {
            return 20 * attackTime;
        } else if(distance > 4  && distance <= 5.5) {
            return 15 * attackTime;
        }
        else{
            return 0;
        }
    }
 public boolean checkDefeatedEnemy( Enemy e ){
     boolean returnedVal=false;
     if(e.getResistance()<=0){
         System.out.println("ENEMIGO DERROTADO");
         returnedVal = true;
     }
     else if ( e.getResistance() > 0 ){ 
         System.out.println("ENEMIGO NO DERROTADO");
         returnedVal=false;
     }
  return returnedVal;
 }    
 public boolean checkDefeatedEnemies( Enemy [] enemiesArray ){
     int hostilityCount=0;
     int counter =0;
     for (Enemy enemy : enemiesArray) {
         if(enemy.isHostility()==true && enemy.getDistance()<= 5.5){
             hostilityCount = hostilityCount + 1;
         }
         System.out.println("host count = "+hostilityCount);
     }
         
    
     for (Enemy e : enemiesArray ) {
         if(e.isHostility()==true && e.getResistance()<=0 && e.getDistance()<= 5.5){
                counter = counter +1;
         }
         System.out.println("enemy count = "+counter);
      }    
  
    
     return hostilityCount == counter;
 }
}
