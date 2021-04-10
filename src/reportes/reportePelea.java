
package reportes;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import models.ResultadoPelea;
import Controller.Controller;

/**
 *
 * @author Derek
 */
public class reportePelea {
    public void reportarPelea(ResultadoPelea[] resultado, int largo) throws IOException{
        Controller controller = new Controller();
        escritor escritor = new escritor();
        Random rand = new Random();
        File file = new File("Reportes\\ReporteCombates\\Home.html");
        String html;
        
        html =  "<!DOCTYPE html>\n" +
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
                "  <body class=\"u-body\"><header class=\"u-clearfix u-header u-image u-header\" id=\"sec-6573\" data-image-width=\"1920\" data-image-height=\"1200\"><div class=\"u-clearfix u-sheet u-valign-middle u-sheet-1\">\n" +
                "        <img src=\"images/PokemonLogo.png\" alt=\"\" class=\"u-image u-image-default u-image-1\" data-image-width=\"1280\" data-image-height=\"471\">\n" +
                "      </div></header>\n" +
                "    <section class=\"u-border-2 u-border-grey-75 u-clearfix u-gradient u-section-1\" id=\"sec-a7bd\">\n" +
                "      <div class=\"u-clearfix u-sheet u-valign-middle u-sheet-1\">\n" +
                "        <h1 class=\"u-text u-text-1\">Listado de Combates</h1>\n" +
                "      </div>\n" +
                "    </section>\n" +
                "    <section class=\"u-clearfix u-palette-4-light-3 u-section-2\" id=\"sec-bb8c\">\n" +
                "      <div class=\"u-clearfix u-sheet u-sheet-1\">\n" +
                "        <div class=\"u-list u-repeater u-list-1\">\n";
                
                for (int i = 0; i < largo; i++) {
                    int numero = rand.nextInt(3);
                    String gymName = "gym"+ numero;
                    String ganadorName = "";
                    
                    String pokemon1Name = resultado[i].getNombrePokemon1().toLowerCase();
                    String pokemon1Path = "Reportes\\ReportePokemon\\images\\"+pokemon1Name+".png";
                    File image = new File(pokemon1Path);
                    if (image.isFile() != true) {
                        pokemon1Name = "unknown";
                    }  
                    
                    String pokemon2Name = resultado[i].getNombrePokemon2().toLowerCase();
                    String pokemon2Path = "Reportes\\ReportePokemon\\images\\"+pokemon2Name+".png";
                    File image2 = new File(pokemon2Path);
                    if (image2.isFile() != true) {
                        pokemon2Name = "unknown";
                    }  
                    
                    if (resultado[i].getNombrePokemon1() == resultado[i].getGanador() ) {
                        ganadorName = pokemon1Name;
                    }else if(resultado[i].getNombrePokemon2() == resultado[i].getGanador()){
                        ganadorName = pokemon2Name;
                    }
                    
                    
                    html += "          <div class=\"u-border-2 u-border-grey-75 u-container-style u-list-item u-repeater-item\">\n" +
                            "            <div class=\"u-container-layout u-similar-container u-valign-top u-container-layout-1\">\n" +
                            "              <h2 class=\"u-align-left u-text u-text-1\">Combate #" + (i+1) + "</h2>\n" +
                            "              <h3 class=\"u-align-center u-text u-text-2\">Lugar: Gimasio de " + resultado[i].getNombreGimnasio() +"</h3>\n" +
                            "              <img src=\"images/" + gymName +".png\" alt=\"\" class=\"u-image u-image-default u-preserve-proportions u-image-1\" data-image-width=\"120\" data-image-height=\"94\">\n" +
                            "              <h3 class=\"u-align-center u-text u-text-3\">" + resultado[i].getNombrePokemon1() + "</h3>\n" +
                            "              <h3 class=\"u-align-center u-text u-text-4\">" + resultado[i].getNombrePokemon2() + "</h3><span class=\"u-file-icon u-icon u-icon-rectangle u-text-palette-1-base u-icon-1\"><img src=\"images/" + pokemon2Name + ".png\" alt=\"\"></span><span class=\"u-file-icon u-icon u-icon-rectangle u-icon-2\"><img src=\"images/" + pokemon1Name +".png\" alt=\"\"></span>\n" +
                            "              <h2 class=\"u-align-center u-text u-text-5\">VS​.</h2>\n" +
                            "              <div class=\"u-border-3 u-border-palette-1-base u-line u-line-horizontal u-line-1\"></div>\n" +
                            "              <h1 class=\"u-align-center u-text u-text-6\">Ganador:</h1><span class=\"u-file-icon u-icon u-icon-rectangle u-text-palette-1-base u-icon-3\"><img src=\"images/" + ganadorName +".png\" alt=\"\"></span>\n" +
                            "              <h3 class=\"u-align-center u-text u-text-7\">" + resultado[i].getGanador().toUpperCase() + "</h3>\n" +
                            "            </div>\n" +
                            "          </div>\n";
        
                }
                
                html += "        </div>\n" +
                        "      </div>\n" +
                        "    </section>\n" +
                        "    \n" +
                        "    \n" +
                        "    <footer class=\"u-align-left u-clearfix u-footer u-grey-80 u-footer\" id=\"sec-1345\"><div class=\"u-clearfix u-sheet u-valign-middle u-sheet-1\">\n" +
                        "        <h3 class=\"u-align-center u-text u-text-1\">Hecho por: Derek Esquivel</h3>\n" +
                        "      </div></footer>\n" +
                        "  </body>\n" +
                        "</html>";
        
        
        escritor.escribirReporte(html, "Reportes\\ReporteCombates\\Home.html");
         
         if(!Desktop.isDesktopSupported()){
                System.out.println("No se pudo abrir el archivo automaticamente");
                System.out.println("El archivo esta disponible en: " + file.getAbsolutePath() );
            }
            
            System.out.println("El archivo esta disponible en: " + file.getAbsolutePath());
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()) desktop.open(file);
        
    }
}
