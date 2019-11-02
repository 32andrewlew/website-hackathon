import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
//import components.xmltree.XMLTree;

public class energy {

    public static void header(SimpleWriter x) {
        x.println("<html>");
        x.println("<ul>");
    }

    public static void closer(SimpleWriter x) {
        x.println("<ul>");
        x.println("</html>");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(
                "/Users/andrew/Documents/just zip things/workspace/osu_energy/src/HackathonConfig.csv"));
        scanner.useDelimiter(",");
        //SimpleReader in = new SimpleReader1L();
        SimpleWriter outhtml = new SimpleWriter1L("main.html");
        SimpleWriter heating_water = new SimpleWriter1L("heating_water.html");
        SimpleWriter chilled_water = new SimpleWriter1L("chilled_water.html");
        SimpleWriter steam = new SimpleWriter1L("steam.html");
        header(heating_water);
        header(chilled_water);
        header(steam);
        header(outhtml);
        String current = "";

        while (scanner.hasNext()) {
            current = "" + scanner.next();
            current = current.substring(1, current.length() - 1);
            if (current.equals("Steam")) {
                steam.println("<li>" + scanner.next() + "</li>");
            } else if (current.equals("Chilled Water ")) {
                chilled_water.println("<li>" + scanner.next() + "</li>");
            } else if (current.equals("Heating Hot Water")) {
                heating_water.println("<li>" + scanner.next() + "</li>");
            }

        }
        closer(heating_water);
        closer(chilled_water);
        closer(steam);
        outhtml.println("<a href=heating_water.html> Heating water</a>");
        outhtml.println("<a href=chilled_water.html> Chilled water</a>");
        outhtml.println("<a href=steam.html> Steam</a>");
        closer(outhtml);
        scanner.close();
        outhtml.close();
    }

}