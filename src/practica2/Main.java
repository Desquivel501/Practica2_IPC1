
package practica2;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Derek
 */
public class Main {

    
    public static void main(String[] args) throws IOException, InterruptedException, FileNotFoundException, ClassNotFoundException {

        Game newGame = new Game();
        newGame.menu();
    }
}
