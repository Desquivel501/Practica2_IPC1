
package practica2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import Controller.Controller;
import java.io.File;
import models.*;
import reportes.*;

/**
 *
 * @author Derek
 */
public class Game {
    Pokemon[] pokemon;
    Entrenadores[] entrenador;
    Pokeball[] pokeball;
    EntrenadorAsignado[] entrenadorAsignado;
    public static boolean firstRun = false;
    
    public void menu() throws IOException, InterruptedException, FileNotFoundException, ClassNotFoundException{
        Scanner scan = new Scanner(System.in);
        Controller controller = new Controller();
        reporteEntrenador reporte = new reporteEntrenador();
        boolean run = true;

        while(run == true){
            System.out.println("=============CENTRO POKEMON==============");
            System.out.println("|| 1. CARGAR POKEMON                   ||");
            System.out.println("|| 2. CARGAR ENTRENADOR                ||");
            System.out.println("|| 3. CARGAR POKEBALL                  ||"); 
            System.out.println("|| 4. CARGAR GIMNASIO                  ||");
            System.out.println("|| 5. CARGAR ALIMENTOS                 ||");
            System.out.println("|| 6. ASIGNAR POKEMON A SU POKEBALL    ||");
            System.out.println("|| 7. ASIGNAR POKEBALL A ENTRENADOR    ||");
            System.out.println("|| 8. ASIGNAR COMIDA                   ||");
            System.out.println("|| 9. COMBATE POKEMON!                 ||");
            System.out.println("|| 10. GENERAR REPORTES                ||");
            System.out.println("|| 11. GUARDAR // CARGAR PARTIDA       ||");
            System.out.println("|| 12. SALIR                           ||");
            System.out.println("=========================================");
            int menu = scan.nextInt();
            scan.nextLine();
            boolean cont = true;

            switch(menu) {
                case 1: 
                    System.out.println("Ingrese la ruta del archivo");
                    String pathPkmn = scan.nextLine();
                    File filePkmn = new File(pathPkmn);
                    
                    if(filePkmn.isFile()){
                        controller.guardarPokemon(pathPkmn);
                        controller.mostrarPokemon();
                    }else{
                        System.out.println("El archivo ingresado no existe");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese la ruta del archivo");
                    String pathEn = scan.nextLine();
                    File fileEn = new File(pathEn);
                    if(fileEn.isFile()){
                        controller.guardarEntrenador(pathEn);
                        controller.mostrarEntrenador();
                    }else{
                        System.out.println("El archivo ingresado no existe");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese la ruta del archivo");
                    String pathPkb = scan.nextLine();
                    File filePkb = new File(pathPkb);
                    if(filePkb.isFile()){
                        controller.guardarPokeball(pathPkb);
                        controller.mostrarPokeball();
                    }else{
                        System.out.println("El archivo ingresado no existe");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese la ruta del archivo");
                    String pathGim = scan.nextLine();
                    File fileGim = new File(pathGim);
                    if(fileGim.isFile()){
                        controller.guardarGimnasios(pathGim);
                        controller.mostrarGimnasios();
                    }else{
                        System.out.println("El archivo ingresado no existe");
                    }

                    break;
                    
                case 5:
                    System.out.println("Ingrese la ruta del archivo");
                    String pathAl = scan.nextLine();
                    File fileAl = new File(pathAl);
                    if(fileAl.isFile()){
                        controller.guardarAlimentos(pathAl);
                        controller.mostrarAlimentos();
                    }else{
                        System.out.println("El archivo ingresado no existe");
                    }
                    break;
                    
                case 6:
                    System.out.println("Ingrese la ruta del archivo");
                    String pathAsPkmn = scan.nextLine();
                    File fileAsPkmn = new File(pathAsPkmn);
                    if(fileAsPkmn.isFile()){
                        controller.guardarAsignacionPokemon(pathAsPkmn);
                        controller.mostrarAsignacionPokemon();
                    }else{
                        System.out.println("El archivo ingresado no existe");
                    }
                    break;
                    
                case 7:
                    System.out.println("Ingrese la ruta del archivo");
                    String pathAsPkb = scan.nextLine();
                    File fileAsPkb = new File(pathAsPkb);
                    if(fileAsPkb.isFile()){
                        controller.guardarAsignacionPokeball(pathAsPkb);
                        controller.mostrarAsignacionPokeball();
                    }else{
                        System.out.println("El archivo ingresado no existe");
                    }
                        break;
                        
                case 8:
                    System.out.println("Ingrese la ruta del archivo");
                    String pathAsAl = scan.nextLine();
                    File fileAsAl = new File(pathAsAl);
                    if(fileAsAl.isFile()){
                        controller.guardarAsignacionAlimento(pathAsAl);
                        controller.mostrarAsignacionAlimento();
                    }else{
                        System.out.println("El archivo ingresado no existe");
                    }
                    break;
                    
                case 9:
                    System.out.println("Ingrese la ruta del archivo");
                    String pathPel = scan.nextLine();
                    File filePel = new File(pathPel);
                    if(filePel.isFile()){
                        controller.guardarPelea(pathPel);
                        controller.mostrarPelea();
                    }else{
                        System.out.println("El archivo ingresado no existe");
                    }
                    break;
                    
                case 10:
                    System.out.println("=================MENU=================");
                    System.out.println("| 1. REPORTE ENTRENADOR              |");
                    System.out.println("| 2. REPORTE POKEMON SALVAJE         |");
                    System.out.println("| 3. REPORTE DE COMIDAS              |");
                    System.out.println("| 4. REPORTE DE COMBATES             |");
                    System.out.println("| 5. REPORTE TOP POKEMON             |");
                    System.out.println("| 6. REPORTE TOP ALIMENTOS           |");
                    System.out.println("| 7. SALIR                           |");
                    System.out.println("======================================");
                    int menuReporte = scan.nextInt();
                    scan.nextLine();
                    
                    switch (menuReporte) {
                        case 1:
                            controller.reporteEntrenador();
                            break;
                        case 2:
                            controller.reportePokemonSalvaje();
                            
                            break;
                        case 3:
                            controller.reporteComidas();
                            break;
                            
                        case 4:
                            controller.reportePelea();
                            break;
                       
                        case 5:
                            controller.reporteTopPokemon();
                            break;
                        
                        case 6:
                            controller.reporteTopComidas();
                            break;
                        
                        case 7:
                            run=false;
                            break;
                            
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }

                    break;
                    
                case 11:
                    System.out.println("=================MENU=================");
                    System.out.println("| 1. CARGAR PARTIDA                  |");
                    System.out.println("| 2. GUARDAR PARTIDA                 |");
                    System.out.println("| 3. BORRAR PARTIDAS GUARDADAS       |");
                    System.out.println("| 4. SALIR                           |");
                    System.out.println("======================================");
                    int menuSerializacion = scan.nextInt();
                    scan.nextLine();
                    
                    switch (menuSerializacion) {
                        case 1:
                            controller.load();
                            break;
                        
                        case 2:
                            System.out.println("Esto sobreescribira la partida gaurdada anterior");
                            System.out.println("¿Desea continuar? Y/N");
                            String guardarPartida = scan.nextLine().toUpperCase();
                    
                            switch (guardarPartida) {
                                case "Y":
                                    controller.save();
                                    System.out.println("");
                                    break;  

                                case "N":;
                                    System.out.println("Guardado abortado");
                                    System.out.println("");
                                    break;

                                default:
                                    System.out.println("Opcion no valida");
                                    System.out.println("");
                                    break;
                            }
                            
                            break;
                        
                        case 3:
                            System.out.println("Esto borrara la partida guardada de manera permanente");
                            System.out.println("¿Esta seguro que sesea continuar? Y/N");
                            String borrarPartida = scan.nextLine().toUpperCase();
                    
                            switch (borrarPartida) {
                                case "Y":
                                    controller.borrar();
                                    
                                    break;  

                                case "N":;
                                    System.out.println("Borrado abortado");
                                    System.out.println("");
                                    break;

                                default:
                                    System.out.println("Opcion no valida");
                                    System.out.println("");
                                    break;
                            }
                            break;
                        
                        case 4:
                            run = false;
                            break;
                            
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }

                    break; 
                    
                case 12:
                    run = false;
                    cont=false;
                    System.out.println("¡Hasta Pronto!");
                    break;
                
                default:
                    System.out.println("Opcion no valida");
                    break;

            }

            while (cont==true) {
                System.out.println("¿Desea realizar otra operacion? Y/N");
                //scan.nextLine();
                String continuar = scan.nextLine().toUpperCase();
                firstRun = true;
                    
                switch (continuar) {
                    case "Y":
                        run = true;
                        cont = false;
                        System.out.println(); 
                        break;  
                    
                    case "N":
                        run = false;
                        cont = false;
                        System.out.println("¡Hasta Pronto!");
                        break;
                            
                    default:
                        System.out.println("Opcion no valida");
                        System.out.println("");
                        break;
                }
            }
            scan.reset();
        }
    }
}
