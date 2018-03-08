package webcrawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.text.Document;
import sun.applet.Main;

/**
 *
 * @author Jean
 */
public class WebCrawler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String arquivo = "texte.txt";

        File file = new File(WebCrawler.class.getResource(arquivo).getFile());
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String textoLinha = scanner.nextLine();
            
            Thread VerificaArquivo = new Thread(new VerificaSiteThread(textoLinha), textoLinha);
            VerificaArquivo.start();
        }

    }

}