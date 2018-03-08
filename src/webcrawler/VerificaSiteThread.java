package webcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author alunomobile
 */
public class VerificaSiteThread implements Runnable {

    String url;

    public VerificaSiteThread(String site) {
        this.url = site;
    }

    @Override
    public void run() {

        try {
            Document doc = Jsoup.connect(url).get();
            Elements titles = doc.select("title");

            System.out.println("\n" + url + ": " + "(" + titles.size() + ")");
            for (Element title : titles) {
                System.out.println(" * title: " + title.attr("abs:href") + "(" + (title.text()) + ")");
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
