
package reportes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Derek
 */
public class escritor {
    public void escribirReporte(String texto, String path){
        FileWriter flw = null;
        
        try{
            flw = new FileWriter(path);
            BufferedWriter bfw = new BufferedWriter(flw);
            bfw.write(texto);
            bfw.close();
        }catch(IOException e){
            System.out.println("Error al escribir el archivo");
            e.printStackTrace();
        }finally{
            if(flw != null){
                try{
                    flw.close();
                }catch(IOException e){
                    System.out.println("Error al cerrar el archivo");
                    e.printStackTrace();
                }
            }
        }
    }
}
