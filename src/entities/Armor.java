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
public class Armor {

    private String primaryColor;
    private String secondaryColor;
    private int health;
    private float generator;
    private double consumeHand;
    private double consumeBoot;
    private  double generatorPercentage;
    private boolean leftHandRepulsor;
    private boolean rightHandRepulsor;
    private boolean rightBootPropulsor;
    private boolean leftBootPropulsor;
    private int resistance;
    private int attack;

    public Armor() {
        //default values here 
        primaryColor = "amarillo";
        secondaryColor = "rojo";

        generator = Float.MAX_VALUE;
    
        generatorPercentage = 100 ;
        resistance = 60;
        health = 100;
        consumeHand=0.0025;
        consumeBoot=0.0025;
        
        leftHandRepulsor = true;
        rightHandRepulsor = true;
        leftBootPropulsor = true;
        rightBootPropulsor = true;
        attack = 5;
        

        //default values here   
    }

    public Armor(String primaryColor, String secondaryColor, int health, float generator, double generatorPercentage,double consumeHand,double consumeBoot, boolean leftHandRepulsor, boolean rightHandRepulsor, boolean rightBootPropulsor, boolean leftBootPropulsor, int resistance, int attack) {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.health = health;
        this.generator = generator;
        this.consumeBoot=consumeBoot;
        this.consumeHand = consumeHand;
        this.generatorPercentage = generatorPercentage;
        this.leftHandRepulsor = leftHandRepulsor;
        this.rightHandRepulsor = rightHandRepulsor;
        this.rightBootPropulsor = rightBootPropulsor;
        this.leftBootPropulsor = leftBootPropulsor;
        this.resistance = resistance;
        this.attack=attack;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public double getConsumeHand() {
        return consumeHand;
    }

    public void setConsumeHand(double consumeHand) {
        this.consumeHand = consumeHand;
    }

    public double getConsumeBoot() {
        return consumeBoot;
    }

    public void setConsumeBoot(double consumeBoot) {
        this.consumeBoot = consumeBoot;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

   

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getGenerator() {
        return generator;
    }

    public void setGenerator(float generator) {
        this.generator = generator;
    }

    public double getGeneratorPercentage() {
        return generatorPercentage;
    }

    public void setGeneratorPercentage(double generatorPercentage) {
        this.generatorPercentage = generatorPercentage;
    }
    

    public boolean isLeftHandRepulsor() {
        return leftHandRepulsor;
    }

    public void setLeftHandRepulsor(boolean leftHandRepulsor) {
        this.leftHandRepulsor = leftHandRepulsor;
    }

    public boolean isRightHandRepulsor() {
        return rightHandRepulsor;
    }

    public void setRightHandRepulsor(boolean rightHandRepulsor) {
        this.rightHandRepulsor = rightHandRepulsor;
    }

    public boolean isRightBootPropulsor() {
        return rightBootPropulsor;
    }

    public void setRightBootPropulsor(boolean rightBootPropulsor) {
        this.rightBootPropulsor = rightBootPropulsor;
    }

    public boolean isLeftBootPropulsor() {
        return leftBootPropulsor;
    }

    public void setLeftBootPropulsor(boolean leftBootPropulsor) {
        this.leftBootPropulsor = leftBootPropulsor;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
    

}
