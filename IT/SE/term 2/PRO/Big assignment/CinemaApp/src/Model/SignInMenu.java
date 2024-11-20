package Model;

import java.io.BufferedReader;
import java.io.FileReader;

public class SignInMenu {

    public SignInMenu() {
        loadData("");
    }


    public void loadData(String fileName) throws ParseException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 6) {
                    films.add(new Film(details[0], details[1], details[2], details[3],
                            MovieFormat.valueOf(details[4]), GenreFilm.valueOf(details[5])));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FilmList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayFilm() {

    }

    public void bookTicket() {

    }

    public void othersFunction() {

    }


}
