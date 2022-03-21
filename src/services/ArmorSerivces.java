/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Armor;
import entities.Enemy;
import entities.Radar;
import static java.lang.Integer.parseInt;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 *
 * @author kurco
 */
public class ArmorSerivces {

    Scanner read = new Scanner(System.in);
    Armor a1 = new Armor();
    Enemy e = new Enemy();

    public int convertToInt(Armor a1) {
        String armourValue = Double.toString(a1.getGenerator());

        String[] toStringArray = armourValue.split("E", 2);
        int StrToNum = (int) Math.ceil(Double.parseDouble(toStringArray[0]));
        return StrToNum;

    }
public boolean checkAllRepairOption(boolean [] repairOptions){
int repairDevicesChance =0;
    for( boolean device : repairOptions){
    if(device == false){
    repairDevicesChance = repairDevicesChance + 1;
    }
    }
return repairDevicesChance > 0;
}
    public void devicesState(Armor a1) {
        System.out.println("Repulsor mano derecha funcionando " + a1.isRightHandRepulsor());
        System.out.println("Repulsor mano izquierda funcionando " + a1.isLeftHandRepulsor());
        System.out.println("Propulsor bota izquierda funcionando " + a1.isLeftBootPropulsor());
        System.out.println("Propulsor bota derecha funcionando " + a1.isRightBootPropulsor());
    }

    public void notWorkingDeviceMsg() {
        System.out.println("DISPOSITIVOS NO FUNCIONANDO");
    }

    public void armorState(Armor a1) {
        System.out.println("Estado de la armadura");
        System.out.println("Dureza armadura " + a1.getResistance() + " HB ");
        System.out.println("Color primario " + a1.getPrimaryColor());
        System.out.println("Color secundario " + a1.getSecondaryColor());

        System.out.println("Porcentaje del generador " + a1.getGeneratorPercentage() + " % ");
        System.out.println("valor del  generador en unidad float " + a1.getGenerator());
        System.out.println("valor del  generador en unidad double " + (double) a1.getGenerator());
        System.out.println("valor del  generador en fracciones  " + convertToInt(a1) + "/4");
        devicesState(a1);
    }

    public int move(Armor a1, double boot, double hand, String typeOfMove) {

        int timeAction;
        System.out.println("cuanto tiempo en segundos desea " + typeOfMove);
        timeAction = read.nextInt();

        float percentageToSubstrac = (float) (a1.getGenerator() * (boot + hand));

        a1.setGenerator(a1.getGenerator() - (percentageToSubstrac * timeAction));
        a1.setGeneratorPercentage(Math.floor((double) a1.getGenerator() * 100 / Float.MAX_VALUE));
        return timeAction;
    }

    public boolean randomFunc(boolean initialValue, int percentage, boolean switchValue) {
        int randomValue = (int) Math.round(Math.random() * 10);
        if (randomValue <= percentage) {
            return switchValue;
        } else {
            return initialValue;
        }
    }

    public boolean randomFunc(int percentage, boolean switchValue) {
        int randomValue = (int) Math.round(Math.random() * 10);
        if (randomValue <= percentage) {
            return switchValue;
        } else {
            return !switchValue;
        }
    }

    public boolean checkDevices(boolean device1, boolean device2, boolean device3, boolean device4) {
        return device1 == true && device2 == true && device3 == true && device4 == true;
    }

    public boolean checkDevices(boolean device1, boolean device2) {
        return device1 == true && device2 == true;
    }
    boolean[] checkRepairChance = {true, true, true, true};

    public boolean repair() {
        int centinel = 0;
        int randomNum = 0;
        do {
            randomNum = (int) Math.ceil(Math.random() * 10);

            centinel++;
        } while (centinel <= 3);
        if (randomNum <= 4) {
            System.out.println("ELEMENTO REPARADO");
        } else {
            System.out.println("ELEMENTO DAÑADO YA NO PUEDE REPARARSE");
        }
        return randomNum <= 4;

    }

    public String repairMenuOptions(String str, int number) {
        return number + " reparar " + str;

    }

    public String repairOption() {
        String option = "";
        System.out.println("dispositivos rotos que desea hacer ?");
        System.out.println("'r' para repararlos");
        System.out.println("'b' para volver atras");
        option = read.next();
        return option;
    }
    boolean searchSwitch = true;
    int numberOfEnemies = 0;
    int betweenOneAndTen = (int) (Math.ceil(Math.random() * 10));
    Enemy[] enemies = new Enemy[betweenOneAndTen];
    Attack at1 = new Attack();

    ;
          
    public void actions(Armor a1) {

        String option = "";
        while (!option.equals("q")) {
            System.out.println("que accion desea realizar?");
            System.out.println("w para caminar");
            System.out.println("r para correr");
            System.out.println("p para propulsarse");
            System.out.println("f para volar");
            System.out.println("a para atacar con los guantes");
            System.out.println("c para rastrear enemigos");
            System.out.println("q para volver al menu anterior");

            option = read.next();

            switch (option) {

                case "w":
                    System.out.println("opcion elegida 'caminar'");
                    if (checkDevices(a1.isLeftBootPropulsor(), a1.isRightBootPropulsor())) {
                        move(a1, a1.getConsumeBoot() * 1, a1.getConsumeBoot() * 1, "caminar");
                        a1.setLeftBootPropulsor(randomFunc(3, false));
                        a1.setRightBootPropulsor(randomFunc(3, false));
                    } else {
                        notWorkingDeviceMsg();
                    }
                    armorState(a1);

                    break;
                case "r":

                    System.out.println("opcion elegida 'correr'");
                    if (checkDevices(a1.isLeftBootPropulsor(), a1.isRightBootPropulsor())) {
                        move(a1, a1.getConsumeBoot() * 4, a1.getConsumeHand() * 2, "correr");
                        a1.setLeftBootPropulsor(randomFunc(a1.isLeftBootPropulsor(), 3, false));
                        a1.setRightBootPropulsor(randomFunc(a1.isRightBootPropulsor(), 3, false));
                    } else {
                        notWorkingDeviceMsg();
                    }
                    armorState(a1);

                    break;
                case "p":

                    System.out.println("opcion elegida 'propulsarse'");
                    if (checkDevices(a1.isLeftBootPropulsor(), a1.isRightBootPropulsor())) {
                        move(a1, a1.getConsumeBoot() * 3, a1.getConsumeBoot() * 3, "propulsarse");
                        a1.setLeftBootPropulsor(randomFunc(a1.isLeftBootPropulsor(), 3, false));
                        a1.setRightBootPropulsor(randomFunc(a1.isRightBootPropulsor(), 3, false));
                        System.out.println("dispositivos funcionando = " + checkDevices(a1.isLeftBootPropulsor(), a1.isRightBootPropulsor(), a1.isLeftHandRepulsor(), a1.isRightHandRepulsor()));
                    } else {
                        notWorkingDeviceMsg();
                    }
                    armorState(a1);

                    break;
                case "f":

                    System.out.println("opcion elegida 'volar'");
                    if (checkDevices(a1.isLeftBootPropulsor(), a1.isRightBootPropulsor(), a1.isLeftHandRepulsor(), a1.isRightHandRepulsor())) {
                        move(a1, a1.getConsumeBoot() * 6, a1.getConsumeHand() * 4, "volar");

                        a1.setLeftBootPropulsor(randomFunc(a1.isLeftBootPropulsor(), 3, false));
                        a1.setRightBootPropulsor(randomFunc(a1.isRightBootPropulsor(), 3, false));
                        a1.setLeftHandRepulsor(randomFunc(a1.isLeftHandRepulsor(), 3, false));
                        a1.setRightHandRepulsor(randomFunc(a1.isRightHandRepulsor(), 3, false));
                        System.out.println("dispositivos funcionando = " + checkDevices(a1.isLeftBootPropulsor(), a1.isRightBootPropulsor(), a1.isLeftHandRepulsor(), a1.isRightHandRepulsor()));
                    } else {

                        notWorkingDeviceMsg();
                    }

                    armorState(a1);

                    break;
                case "a":
                    if(checkAllRepairOption(checkRepairChance)){
                        System.out.println("DISPOSITIVOS ROTOS YA NO SE PUEDE CONTINUAR");
                        System.exit(0);
                        break;
                    }
                    if (!searchSwitch) {
                        if (checkDevices(a1.isLeftBootPropulsor(), a1.isRightHandRepulsor())) {
                            System.out.println("opcion elegida 'atacar con los guantes'");

                            int attackTime = move(a1, a1.getConsumeHand() * 3, a1.getConsumeHand() * 3, "atacar con los guantes");
                            a1.setLeftHandRepulsor(randomFunc(a1.isLeftHandRepulsor(), 3, false));
                            a1.setRightHandRepulsor(randomFunc(a1.isRightHandRepulsor(), 3, false));

                            Enemy returnedEnemy = at1.findEnemy(at1.selectEnemyFunction(), enemies, attackTime);
                            devicesState(a1);
                            System.out.println("returned" + returnedEnemy);
                            if (returnedEnemy != null) {
                                if (at1.checkDefeatedEnemy(returnedEnemy)==true) {
                                   if(at1.checkDefeatedEnemies(enemies) || checkAllRepairOption(checkRepairChance)){
                                       if(at1.checkDefeatedEnemies(enemies)){
                                            System.out.println("ENEMIGOS DERROTADOS FIN DEL JUEGO");
                                       }
                                       else{
                                           System.out.println("DISPOSITIVOS ROTOS FIN DEL JUEGO");
                                       }
                                       
                                    System.exit(0);
                                   }
                                   
                                   
                                }

                            } else {
                                continue;

                            }

                        } else {
                            notWorkingDeviceMsg();
                        }
                    } else {
                        System.out.println("realizar scanner de enemigos");
                    }
                    armorState(a1);

                    break;
                case "c":

                    System.out.println("utilizando radar para buscar enemigos");

                    EnemyService es = new EnemyService();
                    Radar r1 = new Radar();
                    RadarService rs = new RadarService();
                    System.out.println("generando radar");

//                    rs.showRadar(r1);
                    if (searchSwitch == true) {
                        for (int i = 0; i < betweenOneAndTen; i++) {
                            enemies[i] = new Enemy();


                            r1.setRadarPosition(true, enemies[i].getPosition()[0], enemies[i].getPosition()[1], enemies[i].getPosition()[2]);

                            numberOfEnemies++;
                        }

                        searchSwitch = false;
                    }

                    rs.showRadar(r1);
                    for (int i = 0; i < numberOfEnemies; i++) {

                        es.showEnemy(enemies[i]);

                    }
                    System.out.println("Elementos encontrados");
                    System.out.println("numero de enemigos " + numberOfEnemies);
                    break;

                case "q":
                    System.out.println("ha salido del menu");

                    break;
                default:
                    System.out.println("opcion incorrecta");
                    break;

            }
        }
      

    }

    public void initialMenu(Armor a1) {

        String option = "";
        while (!option.equals("q")) {
            System.out.println("Seleccion menu");
            System.out.println("a realizar acciones");
            System.out.println("s scannear dispositivos");
            System.out.println("q salir ");

            option = read.next();
           
            switch (option) {
                case "a":
                    System.out.println("opcion elegida 'acciones'");
                    actions(a1);
                    break;
                case "s":
                    System.out.println("opcion elegida 'scannear'");
                    if (checkDevices(a1.isLeftBootPropulsor(), a1.isRightBootPropulsor(), a1.isLeftHandRepulsor(), a1.isRightHandRepulsor())) {
                        System.out.println("dispositivos funcionando correctamente");

                    } else {

                        switch (repairOption()) {
                            case "r":

                                String repairMenuSelection = "";
                                while (!repairMenuSelection.equals("b")) {
                                    devicesState(a1);
                                    System.out.println("menu de reparacion");
                                    System.out.println(repairMenuOptions("bota izquierda", 1));
                                    System.out.println(repairMenuOptions("bota derecha", 2));
                                    System.out.println(repairMenuOptions("mano izquierda", 3));
                                    System.out.println(repairMenuOptions("mano derecha", 4));
                                    System.out.println("b salir del menu");
                                    ;

                                    repairMenuSelection = read.next();
                                    switch (repairMenuSelection) {
                                        case "1":
                                            if (a1.isLeftBootPropulsor() == false && checkRepairChance[0] == true) {
                                                a1.setLeftBootPropulsor(repair());
                                                checkRepairChance[0] = false;
                                            } else if (checkRepairChance[0] == false && a1.isLeftBootPropulsor() == false) {
                                                System.out.println("YA SE INTENTO REPARAR ESTE DISPOSITIVO");
                                            } else if (a1.isLeftBootPropulsor()) {
                                                System.out.println("DISPOSITIVO FUNCIONANDO");
                                            }
                                            break;
                                        case "2":

                                            if (a1.isRightBootPropulsor() == false && checkRepairChance[1] == true) {
                                                a1.setRightBootPropulsor(repair());
                                                checkRepairChance[1] = false;
                                            } else if (checkRepairChance[1] == false && a1.isRightBootPropulsor() == false) {
                                                System.out.println("YA SE INTENTO REPARAR ESTE DISPOSITIVO");
                                            } else if (a1.isRightBootPropulsor()) {
                                                System.out.println("DISPOSITIVO FUNCIONANDO");
                                            }
                                            break;
                                        case "3":

                                            if (a1.isLeftHandRepulsor() == false && checkRepairChance[2] == true) {
                                                a1.setLeftHandRepulsor(repair());
                                                checkRepairChance[2] = false;
                                            } else if (checkRepairChance[2] == false && a1.isLeftHandRepulsor() == false) {
                                                System.out.println("YA SE INTENTO REPARAR ESTE DISPOSITIVO");
                                            } else if (a1.isLeftHandRepulsor()) {
                                                System.out.println("DISPOSITIVO FUNCIONANDO");
                                            }
                                            break;
                                        case "4":

                                            if (a1.isRightHandRepulsor() == false && checkRepairChance[3] == true) {
                                                a1.setRightHandRepulsor(repair());

                                                checkRepairChance[3] = false;
                                            } else if (checkRepairChance[3] == false && a1.isRightHandRepulsor() == false) {
                                                System.out.println("YA SE INTENTO REPARAR ESTE DISPOSITIVO");
                                            } else if (a1.isRightHandRepulsor()) {
                                                System.out.println("DISPOSITIVO FUNCIONANDO");
                                            }
                                            break;

                                        case "b":
                                            System.out.println("volviendo al menu anterior");
                                            break;
                                        default:
                                            System.out.println("opcion incorrecta");

                                    }

                                }

                                break;
                            case "b":
                                System.out.println("volviendo al menu anterior");
                                break;
                            default:
                                System.out.println("opcion incorrecta");

                        }
                    }
                    break;
                case "q":
                    System.out.println("opcion elegida 'salir'");

                    break;
                default:
                    System.out.println("opcion incorrecta");

            }
        }
    }

}
