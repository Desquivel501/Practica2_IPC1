
package reportes;
import Controller.Controller;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import models.*;

/**
 *
 * @author Derek
 */
public class reporteEntrenador {
    
//    EntrenadorAsignado[] entrenadorAsignado;
    
    public void  reporteEntrenador(EntrenadorAsignado[] equipo, int largo) throws IOException{
        Controller controller = new Controller();
        escritor escritor = new escritor();
        Random rand = new Random();
        File file = new File("Reportes\\ReporteEntrenador\\home.html");
        
        
        String html;
        html= "<!DOCTYPE html>\n" +
                "<html style=\"font-size: 16px;\">\n" +
                "  <head>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"keywords\" content=\"Lista de Entrenadores, Nombre Entrenador #1, Nombre Entrenador #2, Nombre Entrenador #3, Nombre Entrenador #4, Nombre Entrenador #5\">\n" +
                "    <meta name=\"description\" content=\"\">\n" +
                "    <meta name=\"page_type\" content=\"np-template-header-footer-from-plugin\">\n" +
                "    <title>Home</title>\n" +
                "    <link rel=\"stylesheet\" href=\"nicepage.css\" media=\"screen\">\n" +
                "<link rel=\"stylesheet\" href=\"Home.css\" media=\"screen\">\n" +
                "    <script class=\"u-script\" type=\"text/javascript\" src=\"jquery.js\" defer=\"\"></script>\n" +
                "    <script class=\"u-script\" type=\"text/javascript\" src=\"nicepage.js\" defer=\"\"></script>\n" +
                "    <meta name=\"generator\" content=\"Nicepage 3.6.2, nicepage.com\">\n" +
                "    <link id=\"u-theme-google-font\" rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i\">\n" +
                "    \n" +
                "    \n" +
                "    \n" +
                "    <script type=\"application/ld+json\">{\n" +
                "		\"@context\": \"http://schema.org\",\n" +
                "		\"@type\": \"Organization\",\n" +
                "		\"name\": \"\",\n" +
                "		\"url\": \"index.html\"\n" +
                "}</script>\n" +
                "    <meta property=\"og:title\" content=\"Home\">\n" +
                "    <meta property=\"og:type\" content=\"website\">\n" +
                "    <meta name=\"theme-color\" content=\"#478ac9\">\n" +
                "    <link rel=\"canonical\" href=\"index.html\">\n" +
                "    <meta property=\"og:url\" content=\"index.html\">\n" +
                "  </head>\n" +
                "  <body data-home-page=\"Home.html\" data-home-page-title=\"Home\" class=\"u-body\"><header class=\"u-clearfix u-header u-image u-header\" id=\"sec-6573\" data-image-width=\"1920\" data-image-height=\"1200\"><div class=\"u-clearfix u-sheet u-valign-middle u-sheet-1\">\n" +
                "        <img src=\"images/PokemonLogo.png\" alt=\"\" class=\"u-image u-image-default u-image-1\" data-image-width=\"1280\" data-image-height=\"471\">\n" +
                "      </div></header>\n" +
                "    <section class=\"u-border-2 u-border-grey-75 u-clearfix u-gradient u-section-1\" id=\"sec-a7bd\">\n" +
                "      <div class=\"u-clearfix u-sheet u-valign-middle u-sheet-1\">\n" +
                "        <h1 class=\"u-text u-text-1\">Lista de Entrenadores</h1>\n" +
                "      </div>\n" +
                "    </section>\n" +
                "    <section class=\"u-clearfix u-palette-4-light-3 u-section-2\" id=\"sec-bb8c\">\n" +
                "      <div class=\"u-clearfix u-sheet u-sheet-1\">\n" +
                "        <div class=\"u-list u-repeater u-list-1\">\n";
                
                for (int i = 0; i < largo; i++) {
                    
                    int imagenEntrenador = rand.nextInt(39);
                    
                    html += 
                    "          <div class=\"u-border-2 u-border-grey-75 u-container-style u-list-item u-repeater-item\">\n" +
                    "            <div class=\"u-container-layout u-similar-container u-container-layout-1\"><span class=\"u-file-icon u-icon u-icon-rectangle u-text-palette-1-base u-icon-1\"><img src=\"images/"+imagenEntrenador+".png\" alt=\"\"></span>\n" +
                    "              <h2 class=\"u-text u-text-1\">" + equipo[i].getNombreEntrenador() + "</h2>\n" +
                    "              <ul class=\"u-text u-text-2\">\n";
                        
                        String linea = equipo[i].getNombrePokemon1();
                        html +=  " <li>" + linea + "</li>\n"; 
                        linea = equipo[i].getNombrePokemon2();
                        if(linea != null){html +=  " <li>" + linea + "</li>\n";}
                        linea = equipo[i].getNombrePokemon3();
                        if(linea != null){html +=  " <li>" + linea + "</li>\n";}
                        linea = equipo[i].getNombrePokemon4();
                        if(linea != null){html +=  " <li>" + linea + "</li>\n";}
                        linea = equipo[i].getNombrePokemon5();
                        if(linea != null){html +=  " <li>" + linea + "</li>\n";}
     

                    html+=
                    "              </ul>\n" +
                    "            </div>\n" +
                    "          </div>\n";
                }
                
                
                html +=
                "        </div>\n" +
                "      </div>\n" +
                "    </section>\n" +
                "    \n" +
                "    \n" +
                "    <footer class=\"u-align-left u-clearfix u-footer u-grey-80 u-footer\" id=\"sec-1345\"><div class=\"u-clearfix u-sheet u-valign-middle u-sheet-1\">\n" +
                "        <h3 class=\"u-align-center u-text u-text-1\">Hecho por: Derek Esquivel</h3>\n" +
                "      </div></footer>\n" +
                "  </body>\n" +
                "</html>";
        
        
         escritor.escribirReporte(html, "Reportes\\ReporteEntrenador\\home.html");
         
         if(!Desktop.isDesktopSupported()){
                System.out.println("No se pudo abrir el archivo automaticamente");
                System.out.println("El archivo esta disponible en: " + file.getAbsolutePath() );
            }
            
            System.out.println("El archivo esta disponible en: " + file.getAbsolutePath());
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()) desktop.open(file);
        

    }


}
