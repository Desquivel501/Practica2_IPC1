package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import models.*;
import reportes.*;
import java.io.Serializable;

/**
 *
 * @author Derek
 */
public class Controller implements Serializable{
    
    Pokemon[] pokemon;
    Entrenadores[] entrenador;
    Pokeball[] pokeball;
    Pokemon_Pokeball[] asignarPokemon;
    Alimentos[] alimento;
    Gimnasios[] gimnasio;
    Pokeball_Entrenador[] asignarPokeball;
    EntrenadorAsignado[] equipo;
    Pelea[] pelear;
    Asignar_Alimento[] asignarAlimento;
    ActividadComida[] comidaAsignada;
    ResultadoPelea[] resultadoPelea;

    int contPkmn;
    int contEnt;
    int contPkb;
    int contAsPkmn;
    int contAl;
    int contGim;
    int contAsPkb;
    int contPel;
    int contAsAl;
    int contEquipo;
    
    public Controller(){ //se inizializan todas las arrays de objetos y los contadores
        pokemon = new Pokemon[150];
        entrenador = new Entrenadores[25];
        pokeball = new Pokeball[150];
        asignarPokemon = new Pokemon_Pokeball[150];
        alimento = new Alimentos[15];
        gimnasio = new Gimnasios[25];
        asignarPokeball = new Pokeball_Entrenador[150];
        equipo = new EntrenadorAsignado[25];
        pelear = new Pelea[150];
        asignarAlimento = new Asignar_Alimento[150];
        comidaAsignada = new ActividadComida[150];
        resultadoPelea = new ResultadoPelea[150];
        contEnt = 0;
        contGim = 0;
        contPkmn = 0;
        contPkb = 0;
        contAsPkmn = 0;
        contAl = 0;
        contAsPkb = 0;
        contPel = 0;
        contAsAl = 0;
        contEquipo = 0;
    }
    
    public Pokemon[] guardarPokemon(String path) throws IOException{
        BufferedReader br = null;        
        try{
            File archivo = new File(path);
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            linea = br.readLine();
            
            while (linea != null) {
                String[] parametros = linea.split(",");
                String capturado = parametros[5].toLowerCase();
                String estado = parametros[6].toLowerCase();
                
                switch(capturado){ //Convierte los valores de capturado y del estado a boolean
                    case "capturado":parametros[5]= "true";
                        break;
                    case "salvaje":parametros[5] = "false";
                        break;
                    default:parametros[5]= "false";
                        break;
                }
                switch(estado){
                    case "vivo":parametros[6]= "true";
                        break;
                    case "muerto":parametros[6] = "false";
                        break;
                    default:parametros[6]= "false";
                        break;
                }
                //Crea un nuevo objeto de la clase Pokemon
                pokemon[contPkmn] = new Pokemon(Integer.parseInt(parametros[0]),parametros[1],parametros[2],Double.parseDouble(parametros[3]),
                                            Double.parseDouble(parametros[4]),Boolean.parseBoolean(parametros[5]),Boolean.parseBoolean(parametros[6]));
                contPkmn++;
                linea = br.readLine();
            }
        }catch(IOException e){
            System.out.println("IOException error");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("Exception error");
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close(); 
            }
        }
        return pokemon;
    }
    
    public void mostrarPokemon(){
        System.out.println("ID\tTIPO\tNOMBRE\t\tVIDA\t\tATAQUE\t\tCAPTURADO\t\tESTADO");
        System.out.println("");
        for (int i = 0; i<contPkmn; i++){
            System.out.println(this.pokemon[i].getId() + "\t" + this.pokemon[i].getTipo() + "\t" +
                                this.pokemon[i].getNombre() + "\t\t" +this.pokemon[i].getVida()+ "\t\t" +
                                this.pokemon[i].getAtaque() + "\t\t" + this.pokemon[i].isCapturado() + "\t\t" +
                                this.pokemon[i].isEstado());
        }
    }
    
    public Entrenadores[] guardarEntrenador(String path) throws IOException{
        BufferedReader br = null;        
        try{
            File archivo = new File(path);
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            linea = br.readLine();
            
            while (linea != null) {
                String[] parametros = linea.split(",");
                entrenador[contEnt] = new Entrenadores(Integer.parseInt(parametros[0]),parametros[1]); //Crea un objeto de Entrenadores
                contEnt++;
                linea = br.readLine();
            }
        }catch(IOException e){
            System.out.println("IOException error");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("Exception error");
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close(); 
            }
        }
        return entrenador;
    }
    
    public void mostrarEntrenador(){
        System.out.println("ID\tNOMBRE");
        System.out.println("");
        for (int i = 0; i<contEnt; i++){
            System.out.println(this.entrenador[i].getId() + "\t" + this.entrenador[i].getNombre());
        }
    }
    
    public Pokeball[] guardarPokeball(String Path) throws IOException{
        BufferedReader br = null;
        try{
            File archivo = new File(Path);
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            linea = br.readLine();
            
            while (linea != null) {
                String[] parametros = linea.split(",");
                //Crea un objeto de Pokeball
                pokeball[contPkb] = new Pokeball(Integer.parseInt(parametros[0]),parametros[1]);
                contPkb++;
                linea = br.readLine();
            }
        }catch(IOException e){
            System.out.println("IOException error");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("Exception error");
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close(); 
            }
        }
        return pokeball;
    }

    public void mostrarPokeball(){
        System.out.println("ID\tTIPO");
        System.out.println("");
        for (int i = 0; i<contPkb; i++){
            System.out.println(this.pokeball[i].getId() + "\t" + this.pokeball[i].getTipo());
        }
    }
    
    public Pokemon_Pokeball[] guardarAsignacionPokemon(String path) throws IOException{
        BufferedReader br = null;           
        try{
            File archivo = new File(path);
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            linea = br.readLine();
            
            while (linea != null) {
                String[] parametros = linea.split(",");
                //Guarda la asignacion de pokemon a en un objetos
                asignarPokemon[contAsPkmn] = new Pokemon_Pokeball((contAsPkmn+1),Integer.parseInt(parametros[0]),Integer.parseInt(parametros[1]));
                contAsPkmn++;
                linea = br.readLine();
            }
        }catch(IOException e){
            System.out.println("IOException error");
            e.printStackTrace();
        }catch(NumberFormatException e){
            System.out.println("Exception error");
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close(); 
            }
        }
        return asignarPokemon;
    }
    
    public void mostrarAsignacionPokemon(){
        System.out.println("ID\tTIPO\tPokemon");
        System.out.println("");
        for (int i = 0; i<contAsPkmn; i++){
            //llama a los objetos originales para tener el valor del nombre del pokemon y tipo de pokeball
            System.out.println(this.asignarPokemon[i].getIdAsignacion() + "\t" + this.pokeball[this.asignarPokemon[i].getIdPokeball()-1].getTipo()
                                + "\t" + this.pokemon[this.asignarPokemon[i].getIdPokemon()-1].getNombre());
            this.pokemon[this.asignarPokemon[i].getIdPokemon()-1].setCapturado(true);
        }

    }
    
    public Alimentos[] guardarAlimentos(String Path) throws IOException{
        BufferedReader br = null;
        int rowsLength =0;
        try{
            File archivo = new File(Path);
            br = new BufferedReader(new FileReader(archivo));
            
            String linea = br.readLine();
            linea = br.readLine();
            
            while (linea != null) {
                rowsLength++;
                String[] parametros = linea.split(",");
                alimento[contAl] = new Alimentos(Integer.parseInt(parametros[0]),parametros[1],Double.parseDouble(parametros[2]));
                contAl++;
                linea = br.readLine();
            }
        }catch(IOException e){
            System.out.println("IOException error");
            e.printStackTrace();
        }catch(NumberFormatException e){
            System.out.println("Exception error");
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close(); 
            }
        }
        return alimento;
    }
    
    public void mostrarAlimentos(){
        System.out.println("ID\tNombre\tVida");
        System.out.println("");
        for (int i = 0; i<contAl; i++){
            System.out.println(this.alimento[i].getId() + "\t" + this.alimento[i].getNombre() + "\t" + this.alimento[i].getVida());
        }
    }
    
    public Gimnasios[] guardarGimnasios(String Path) throws IOException{
        BufferedReader br = null;        
        try{
            File archivo = new File(Path);
            br = new BufferedReader(new FileReader(archivo));
            
            String linea = br.readLine();
            linea = br.readLine();
            
            while (linea != null) {
                String[] parametros = linea.split(",");
                gimnasio[contGim] = new Gimnasios(Integer.parseInt(parametros[0]),parametros[1]);
                contGim++;
                linea = br.readLine();
            }
        }catch(IOException e){
            System.out.println("IOException error");
            e.printStackTrace();
        }catch(NumberFormatException e){
            System.out.println("Exception error");
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close(); 
            }
        }
        return gimnasio;
    }
     
    public void mostrarGimnasios(){
        System.out.println("ID\tNombre");
        System.out.println("");
        for (int i = 0; i<contGim; i++){
            System.out.println(this.gimnasio[i].getId() + "\t" + this.gimnasio[i].getNombre());
        }
    }
     
    public Pokeball_Entrenador[] guardarAsignacionPokeball(String path) throws IOException{
        BufferedReader br = null;        
        try{
            File archivo = new File(path);
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            linea = br.readLine();
            
            while (linea != null) {
                String[] parametros = linea.split(",");
                //Guarda la asignacion de pokeball a su respectivo entrenador
                asignarPokeball[contAsPkb] = new Pokeball_Entrenador((contAsPkb+1),Integer.parseInt(parametros[0]),Integer.parseInt(parametros[1]));
                contAsPkb++;
                linea = br.readLine();
            }

        }catch(IOException e){
            System.out.println("IOException error");
            e.printStackTrace();
        }catch(NumberFormatException e){
            System.out.println("Exception error");
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close(); 
            }
        }
        return asignarPokeball;
    }
     
    public void mostrarAsignacionPokeball(){
        System.out.println("ID\tENTRENADOR\tPOKEBALL\tPOKEMON");
        System.out.println("");
        for (int i = 0; i<contAsPkb; i++){
            //llama a los objetos originales para tener el valor del nombre del entrenador, nombre del pokemon y tipo de pokeball
            System.out.println(this.asignarPokeball[i].getIdAsignacion() + "\t" + this.entrenador[this.asignarPokeball[i].getIdEntrenador()-1].getNombre()
                                + "\t" + this.pokeball[this.asignarPokemon[this.asignarPokeball[i].getIdPokeball()-1].getIdPokeball()-1].getTipo()
                                + "\t" + this.pokemon[this.asignarPokemon[this.asignarPokeball[i].getIdPokeball()-1].getIdPokemon()-1].getNombre());
            this.pokemon[this.asignarPokemon[this.asignarPokeball[i].getIdPokeball()-1].getIdPokemon()-1].setCapturado(true);
        }
    }
    
    public Pelea[] guardarPelea(String Path) throws IOException{
        BufferedReader br = null;       
        try{
            File archivo = new File(Path);
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            linea = br.readLine();
            
            while (linea != null) {
                String[] parametros = linea.split(",");
                //Guarda la pelea
                pelear[contPel] = new Pelea(Integer.parseInt(parametros[0]),Integer.parseInt(parametros[1]),Integer.parseInt(parametros[2]));
                contPel++;
                linea = br.readLine();
            }
        }catch(IOException e){
            System.out.println("IOException error");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("Exception error");
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close(); 
            }
        }
        return pelear;
    }
    
    public void mostrarPelea(){ //Ejecuta la pelea con los pokemon asignados
        
        for (int i = 0; i<contPel; i++){
            String ganador = "";
            Pokemon pokemon1 = this.pokemon[this.pelear[i].getIdPokemon1()-1];
            Pokemon pokemon2 = this.pokemon[this.pelear[i].getIdPokemon2()-1];
            
            System.out.println("Pelea #" + (i+1));
            System.out.println("Lugar: Gimnasio de " + this.gimnasio[this.pelear[i].getGimnasio()-1].getNombre());
            System.out.println("");
            System.out.println(pokemon1.getNombre().toUpperCase() + " VS " + pokemon2.getNombre().toUpperCase() + "!!!");
            System.out.println("");
            
            if(pokemon1.getVida() !=0 && pokemon2.getVida() !=0){
                boolean fin = false;
                while(pokemon1.getVida() > 0 && pokemon2.getVida() >0  && fin == false){
                    for (int j = 0; j < 3; j++) {
                        System.out.println(pokemon1.getNombre() + " ataca! ");
                        pokemon2.setVida(pokemon2.getVida() - pokemon1.getAtaque());
                        System.out.println(pokemon2.getNombre() + " recibe " + String.format("%.2f",pokemon1.getAtaque()) + " puntos de daño ");
                        System.out.println("");
                        
                        if(pokemon2.getVida() <0){fin = true; j=3;} //Si el pokemon se debilita aqui concluye la pelea
                        
                        if(fin == false){
                            System.out.println(pokemon2.getNombre() + " ataca! ");
                            pokemon1.setVida(pokemon1.getVida() - pokemon2.getAtaque());
                            System.out.println(pokemon1.getNombre() + " recibe " + String.format("%.2f",pokemon2.getAtaque()) + " puntos de daño ");
                            System.out.println("");
                        }
                        if(pokemon1.getVida() <0){fin = true; j=3;} //Si el pokemon se debilita aqui concluye la pelea
                    }
                    fin = true;
                    
                    if(pokemon1.getVida() > pokemon2.getVida()){ //Imprimee el ganador del combate, el que tenga mas vida gana
                        if(pokemon2.getVida()<=0){System.out.println(pokemon2.getNombre() + " ya no puede continuar.");} //Mensaje unico si el pokemon se debilita a media pelea
                        System.out.println("El ganador es: " + pokemon1.getNombre().toUpperCase() + "!");
                        ganador = pokemon1.getNombre();
                        if(pokemon2.getVida()<0){pokemon2.setVida(0.0);}
                        pokemon2.setEstado(false);

                    }else if(pokemon1.getVida() < pokemon2.getVida()){
                        if(pokemon1.getVida()<=0){System.out.println(pokemon1.getNombre() + " ya no puede continuar.");}//Mensaje unico si el pokemon se debilita a media pelea
                        System.out.println("El ganador es: " + pokemon2.getNombre().toUpperCase() + "!");
                        ganador = pokemon2.getNombre();
                        if(pokemon1.getVida()<0){pokemon1.setVida(0.0);}
                        pokemon1.setEstado(false);
                    }
                }
            }else{//Si uno de los pokemon no tiene vida el otro gana por descalificacion
                if (pokemon1.getVida() == 0) {
                    System.out.println(pokemon1.getNombre() +" esta debilitado, por lo que no puede combatir.");
                    System.out.println("El ganador es: " + pokemon2.getNombre().toUpperCase() + "!");
                    ganador = pokemon2.getNombre();
                }else if(pokemon2.getVida() == 0){
                    System.out.println(pokemon2.getNombre() +" esta debilitado, por lo que no puede combatir.");
                    System.out.println("El ganador es: " + pokemon1.getNombre().toUpperCase() + "!");
                    ganador = pokemon1.getNombre();
                }
            }
            System.out.println("");
            System.out.println("");
            System.out.println("=============================================================");
            System.out.println("");
            System.out.println("");
            
            //Guarda el resultado de la pelea para el reporte
            resultadoPelea[i] = new ResultadoPelea(this.gimnasio[this.pelear[i].getGimnasio()-1].getNombre(), pokemon1.getNombre(), pokemon2.getNombre() ,ganador);
        }
    }
    
    public  Asignar_Alimento[] guardarAsignacionAlimento(String path) throws IOException{
        BufferedReader br = null;   
        try{
            File archivo = new File(path);
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            linea = br.readLine();
            
            while (linea != null) {
                String[] parametros = linea.split(",");
                asignarAlimento[contAsAl] = new Asignar_Alimento((contAsAl+1), Integer.parseInt(parametros[0]), Integer.parseInt(parametros[1]));
                contAsAl++;
                linea = br.readLine();
            }
            
            
        }catch(IOException e){
            System.out.println("IOException error");
            e.printStackTrace();
        }catch(NumberFormatException e){
            System.out.println("Exception error");
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close(); 
            }
        }
        return asignarAlimento;
    }
    
    public void mostrarAsignacionAlimento(){
        System.out.println("ID\tALIMENTO\tPOKEMON");
        System.out.println("");
        for (int i = 0; i<contAsAl; i++){
            System.out.println(this.asignarAlimento[i].getIdActividad() + "\t" + this.alimento[this.asignarAlimento[i].getIdAlimento()-1].getNombre() + "\t" +
                                this.pokemon[this.asignarAlimento[i].getIdPokemon()-1].getNombre());
            
            //Modifica el estado de los pokemon segun la asignacion realizada
            this.pokemon[this.asignarAlimento[i].getIdPokemon()-1].setVida(this.pokemon[this.asignarAlimento[i].getIdPokemon()-1].getVida() + 
                                                                            this.alimento[this.asignarAlimento[i].getIdAlimento()-1].getVida());
            if(this.pokemon[this.asignarAlimento[i].getIdPokemon()-1].getVida() != 0.0){this.pokemon[this.asignarAlimento[i].getIdPokemon()-1].setEstado(true);}
        }
    }

    public void reporteEntrenador() throws IOException{ //Sepera los pokemon en equipos
        reporteEntrenador reportarEquipo = new reporteEntrenador();
        
        for (int i = 0; i < contAsPkb; i++) {
            int[] equipoProvicional = new int[5];
            int idProvisional = this.asignarPokeball[i].getIdEntrenador();
            int contP = 0;
            
            for (int j = 0; j < contAsPkb; j++) {
                if(this.asignarPokeball[j].getIdEntrenador() == idProvisional){
                    equipoProvicional[contP] =  this.asignarPokeball[j].getIdPokeball();
                    contP++;
                }
                if(contP==5){j=100000;}
            } 
            switch(contP){
                case 1:
                    equipo[contEquipo] = new EntrenadorAsignado((contEquipo+1), this.entrenador[this.asignarPokeball[i].getIdEntrenador()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[0]-1].getIdPokemon()-1].getNombre(),
                                                        null,null,null,null);
                    break;
                case 2:
                    equipo[contEquipo] = new EntrenadorAsignado((contEquipo+1), this.entrenador[this.asignarPokeball[i].getIdEntrenador()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[0]-1].getIdPokemon()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[1]-1].getIdPokemon()-1].getNombre(),
                                                        null,null,null);
                    break;
                case 3:
                    equipo[contEquipo] = new EntrenadorAsignado((contEquipo+1), this.entrenador[this.asignarPokeball[i].getIdEntrenador()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[0]-1].getIdPokemon()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[1]-1].getIdPokemon()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[2]-1].getIdPokemon()-1].getNombre(),
                                                        null, null);
                    break;
                case 4:
                    equipo[contEquipo] = new EntrenadorAsignado((contEquipo+1), this.entrenador[this.asignarPokeball[i].getIdEntrenador()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[0]-1].getIdPokemon()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[1]-1].getIdPokemon()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[2]-1].getIdPokemon()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[3]-1].getIdPokemon()-1].getNombre(),null);
                    break;                   
                case 5:
                    equipo[contEquipo] = new EntrenadorAsignado((contEquipo+1), this.entrenador[this.asignarPokeball[i].getIdEntrenador()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[0]-1].getIdPokemon()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[1]-1].getIdPokemon()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[2]-1].getIdPokemon()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[3]-1].getIdPokemon()-1].getNombre(),
                                                        this.pokemon[this.asignarPokemon[equipoProvicional[4]-1].getIdPokemon()-1].getNombre());
                    break; 
                default:
                    break;
            }
            i = i+contP-1;
            contEquipo++;
        }
        reportarEquipo.reporteEntrenador(equipo,contEquipo);
    }
    
    public void reportePokemonSalvaje() throws IOException{ //Colecta solo los pokemon salvajes para el reporte
        reportePokemonSalvaje reportarPkmn = new reportePokemonSalvaje();
        String[] pokemonSalvaje = new String[contPkmn];
        int cont = 0;
        for (int i = 0; i < contPkmn; i++) {
            if (this.pokemon[i].isCapturado() == false) {
                pokemonSalvaje[cont] = this.pokemon[i].getNombre();
                cont++;
            }
        }
        reportarPkmn.reportePokemon(pokemonSalvaje,cont);
    }
    
    public void reporteTopPokemon() throws IOException{ 
        reporteTopPokemon reporte = new reporteTopPokemon();
        double[][] pokemonTemp = new double[contPkmn][2];
        String[] pokemonTop = new String[5];
        int cont = 0;
        for (int i = 0; i < contPkmn; i++) {
            pokemonTemp[i][0] = this.pokemon[i].getId();
            pokemonTemp[i][1] = this.pokemon[i].getAtaque();
            cont++;
        }
        double aux,aux2;
        for (int i = 0; i < pokemonTemp.length - 1; i++) { //Bubble sort para obtener los pokemon con mas ataque
            for (int j = 0; j < pokemonTemp.length - i - 1; j++) {
                if (pokemonTemp[j + 1][1] > pokemonTemp[j][1]) {
                    aux = pokemonTemp[j + 1][1];
                    aux2 = pokemonTemp[j + 1][0];
                    pokemonTemp[j + 1][1] = pokemonTemp[j][1];
                    pokemonTemp[j + 1][0] = pokemonTemp[j][0];
                    pokemonTemp[j][1] = aux;
                    pokemonTemp[j][0] = aux2;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            int id = (int)pokemonTemp[i][0];
            pokemonTop[i] = this.pokemon[id-1].getNombre();
        }
        
        for (String x : pokemonTop){
                System.out.print(x + " ");
           System.out.println();
        }
        
        reporte.reportePokemon(pokemonTop);
    }
    
    public void reporteTopComidas() throws IOException{
        reporteTopAlimento reporte = new reporteTopAlimento();
        double[][] alimentoTemp = new double[contAl][2];
        String[] aliementoTop = new String[5];
        int cont = 0;
        for (int i = 0; i < contAl; i++) {
            alimentoTemp[i][0] = this.alimento[i].getId();
            alimentoTemp[i][1] = this.alimento[i].getVida();
            cont++;
        }
        double aux,aux2;
        for (int i = 0; i < alimentoTemp.length - 1; i++) {//Bubble sort para obtener los alimentos con mas vida
            for (int j = 0; j < alimentoTemp.length - i - 1; j++) {
                if (alimentoTemp[j + 1][1] > alimentoTemp[j][1]) {
                    aux = alimentoTemp[j + 1][1];
                    aux2 = alimentoTemp[j + 1][0];
                    alimentoTemp[j + 1][1] = alimentoTemp[j][1];
                    alimentoTemp[j + 1][0] = alimentoTemp[j][0];
                    alimentoTemp[j][1] = aux;
                    alimentoTemp[j][0] = aux2;
                }
            }
        }
        if(contAl>5){cont = 5;}
        else{cont = contAl;}
        for (int i = 0; i < cont; i++) {
            int id = (int)alimentoTemp[i][0];
            aliementoTop[i] = this.alimento[id-1].getNombre();
        }
        reporte.reporteTopAlimento(aliementoTop);
    }
   
    public void reporteComidas() throws IOException{ //Reporte de loas asignaciones de comida a los pokemon
        reporteAlimentos reportar = new reporteAlimentos();
        for (int i = 0; i < contAsAl; i++) {
            comidaAsignada[i] = new ActividadComida(this.alimento[this.asignarAlimento[i].getIdAlimento()-1].getNombre(), 
                                                    this.pokemon[this.asignarAlimento[i].getIdPokemon()-1].getNombre(),
                                                    String.format("%.2f", this.alimento[this.asignarAlimento[i].getIdAlimento()-1].getVida()));
        
//            System.out.println(comidaAsignada[i].getNombreAlimento() + " " + comidaAsignada[i].getNombrePokemon() + " " + comidaAsignada[i].getVidaAgregada());
        }
        reportar.reporteAlimentos(comidaAsignada,contAsAl);
    }
    
    public void reportePelea() throws IOException{
        reportePelea reportar = new reportePelea();
        reportar.reportarPelea(this.resultadoPelea, contPel);
    }
    
    public void save() throws FileNotFoundException, IOException{ //Serializacion de todos los objetos
        try{
            ObjectOutputStream pokemonSave = new ObjectOutputStream(new FileOutputStream("Saves\\pokemonSave.txt"));
            pokemonSave.writeObject(this.pokemon);
            pokemonSave.close();
            
            ObjectOutputStream asignarPokemonSave = new ObjectOutputStream(new FileOutputStream("Saves\\asignarPokemonSave.txt"));
            asignarPokemonSave.writeObject(this.asignarPokemon);
            asignarPokemonSave.close();

            ObjectOutputStream entrenadorSave = new ObjectOutputStream(new FileOutputStream("Saves\\entrenadorSave.txt"));
            entrenadorSave.writeObject(this.entrenador);
            entrenadorSave.close();

            ObjectOutputStream pokeballSave = new ObjectOutputStream(new FileOutputStream("Saves\\pokeballSave.txt"));
            pokeballSave.writeObject(this.pokeball);
            pokeballSave.close();

            ObjectOutputStream alimentoSave = new ObjectOutputStream(new FileOutputStream("Saves\\alimentoSave.txt"));
            alimentoSave.writeObject(this.alimento);
            alimentoSave.close();

            ObjectOutputStream gimnasioSave = new ObjectOutputStream(new FileOutputStream("Saves\\gimnasioSave.txt"));
            gimnasioSave.writeObject(this.gimnasio);
            gimnasioSave.close();

            ObjectOutputStream asignarPokeballSave = new ObjectOutputStream(new FileOutputStream("Saves\\asignarPokeballSave.txt"));
            asignarPokeballSave.writeObject(this.asignarPokeball);
            asignarPokeballSave.close();

            ObjectOutputStream pelearSave = new ObjectOutputStream(new FileOutputStream("Saves\\pelearSave.txt"));
            pelearSave.writeObject(this.pelear);
            pelearSave.close();

            ObjectOutputStream asignarAlimentoSave = new ObjectOutputStream(new FileOutputStream("Saves\\asignarAlimentoSave.txt"));
            asignarAlimentoSave.writeObject(this.asignarAlimento);
            asignarAlimentoSave.close();

            ObjectOutputStream resultadoPeleaSave = new ObjectOutputStream(new FileOutputStream("Saves\\resultadoPeleaSave.txt"));
            resultadoPeleaSave.writeObject(this.resultadoPelea);
            resultadoPeleaSave.close();
            
            System.out.println("Partida guardada correctamente");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ha ocurrido un error al cargar la partida");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ha ocurrido un error al cargar la partida");
        }
    }
    
    public void load() throws FileNotFoundException, IOException, ClassNotFoundException{ //Deserializacion de todos los objetos
        try{
            ObjectInputStream pokemonLoad = new ObjectInputStream(new FileInputStream("Saves\\pokemonSave.txt"));
            this.pokemon = (Pokemon[]) pokemonLoad.readObject();
            for (Pokemon pokemon1 : this.pokemon) {
                if (pokemon1 == null) {break;}
                contPkmn++;
            }
            ObjectInputStream asignarPokemonLoad = new ObjectInputStream(new FileInputStream("Saves\\asignarPokemonSave.txt"));
            this.asignarPokemon = (Pokemon_Pokeball[]) asignarPokemonLoad.readObject();
            for (Pokemon_Pokeball asignarPokemon1 : this.asignarPokemon) {
                if (asignarPokemon1 == null) {break;}
                contAsPkmn++;
            }
            ObjectInputStream entrenadorLoad = new ObjectInputStream(new FileInputStream("Saves\\entrenadorSave.txt"));
            this.entrenador =  (Entrenadores[]) entrenadorLoad.readObject();
            for (Entrenadores entrenador1 : this.entrenador) {
                if (entrenador1 == null) {break;}
                contEnt++;
            }
            ObjectInputStream pokeballLoad = new ObjectInputStream(new FileInputStream("Saves\\pokeballSave.txt"));
            this.pokeball =   (Pokeball[]) pokeballLoad.readObject();
            for (Pokeball pokeball1 : this.pokeball) {
                if (pokeball1 == null) {break;}
                contPkb++;
            }
            ObjectInputStream alimentoLoad = new ObjectInputStream(new FileInputStream("Saves\\alimentoSave.txt"));
            this.alimento = (Alimentos[]) alimentoLoad.readObject();
            for (Alimentos alimento1 : this.alimento) {
                if (alimento1 == null) {break;}
                contAl++;
            }
            ObjectInputStream gimnasioLoad = new ObjectInputStream(new FileInputStream("Saves\\gimnasioSave.txt"));
            this.gimnasio = (Gimnasios[]) gimnasioLoad.readObject();
            for (Gimnasios gimnasio1 : this.gimnasio) {
                if (gimnasio1 == null) {break;}
                contGim++;
            }
            ObjectInputStream asignarPokeballLoad = new ObjectInputStream(new FileInputStream("Saves\\asignarPokeballSave.txt"));
            this.asignarPokeball = (Pokeball_Entrenador[]) asignarPokeballLoad.readObject();
            for (Pokeball_Entrenador asignarPokeball1 : this.asignarPokeball) {
                if (asignarPokeball1 == null) {break;}
                contAsPkb++;
            }
            ObjectInputStream pelearLoad = new ObjectInputStream(new FileInputStream("Saves\\pelearSave.txt"));
            this.pelear = (Pelea[]) pelearLoad.readObject();
            for (Pelea pelear1 : this.pelear) {
                if (pelear1 == null) {break;}
                contPel++;
            }
            ObjectInputStream asignarAlimentoLoad = new ObjectInputStream(new FileInputStream("Saves\\asignarAlimentoSave.txt"));
            this.asignarAlimento = (Asignar_Alimento[]) asignarAlimentoLoad.readObject();
            for (Asignar_Alimento asignarAlimento1 : this.asignarAlimento) {
                if (asignarAlimento1 == null) {break;}
                contAsAl++;
            }
            ObjectInputStream resultadoPeleaLoad = new ObjectInputStream(new FileInputStream("Saves\\resultadoPeleaSave.txt"));
            this.resultadoPelea = (ResultadoPelea[]) resultadoPeleaLoad.readObject();
            for (ResultadoPelea resultadoPelea1 : this.resultadoPelea) {
                if (resultadoPelea1 == null) {break;}
                contAsAl++;
            }
            
            System.out.println("Partida cargada exitosamente");
            
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Ha ocurrido un error al cargar la partida");
            e.printStackTrace();
        }
    }
    
    public void borrar() throws FileNotFoundException{ //Borra archivos de serializacion
        try{
            PrintWriter ps = new PrintWriter("Saves\\pokemonSave.txt");
            ps.close();
            PrintWriter aps = new PrintWriter("Saves\\asignarPokemonSave.txt");
            aps.close();
            PrintWriter es = new PrintWriter("Saves\\entrenadorSave.txt");
            es.close();
            PrintWriter pbs = new PrintWriter("Saves\\pokeballSave.txt");
            pbs.close();
            PrintWriter as = new PrintWriter("Saves\\alimentoSave.txt");
            as.close();
            PrintWriter gs = new PrintWriter("Saves\\gimnasioSave.txt");
            gs.close();
            PrintWriter apbs = new PrintWriter("Saves\\asignarPokeballSave.txt");
            apbs.close();
            PrintWriter pls = new PrintWriter("Saves\\pelearSave.txt");
            pls.close();
            PrintWriter aas = new PrintWriter("Saves\\asignarAlimentoSave.txt");
            aas.close();
            PrintWriter rps = new PrintWriter("Saves\\resultadoPeleaSave.txt");
            rps.close();
            System.out.println("Partida borrada correctamente");
        }catch(FileNotFoundException e){
            System.out.println("Ha ocurrido un error al borrar la partida");
            e.printStackTrace();
        }
    }
}
