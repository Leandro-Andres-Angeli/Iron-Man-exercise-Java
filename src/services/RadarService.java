/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Radar;

/**
 *
 * @author kurco
 */
public class RadarService {
    
    public void showRadar(Radar r1){
        for (int i = 0; i < 19; i++) {
           
            for (int j = 0; j < 19; j++){
                
                for (int k = 0; k < 19; k++) {
                    
              
                    System.out.print(" "+ r1.getRadarDimension()[i][j][k]);
                        
                }
                System.out.println(" ");
                    
                
            }
            System.out.println(" ");
        }
    
    }
}
