/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Enemy;

/**
 *
 * @author kurco
 */
public class EnemyService {
    
    public void showEnemy(Enemy e ){
        System.out.println("enemy id "+e.getIdEnemy()+" enemy position "+e.getPosition()[0]+" "+e.getPosition()[1]+" "+e.getPosition()[2]+ " resistance = "+e.getResistance()+" distance = "+e.getDistance() * 1000+" mts "+" hostility "+e.isHostility() );
    } 
    
            
}
