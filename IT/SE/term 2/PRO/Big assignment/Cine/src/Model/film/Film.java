package Model.film;

import View.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Film {
    private String idFilm;
    private String title;
    private String producer;
    private String releaseDate;
    private MovieFormat dangFilm;
    private GenreFilm theLoaiFilm;

    public Film(String id, String title, String producer, String releaseDate, MovieFormat dangFilm, GenreFilm theLoaiFilm) {
        this.idFilm = id;
        this.title = title;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.dangFilm = dangFilm;
        this.theLoaiFilm = theLoaiFilm;
    }

    public Film() {
    }

    public Film(String idFilm) {
        this.idFilm = idFilm;
    }

    // Getters and setters
    public String getIdFilm() {
        return idFilm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public MovieFormat getDangFilm() {
        return dangFilm;
    }

    public void setDangFilm(MovieFormat dangFilm) {
        this.dangFilm = dangFilm;
    }

    public GenreFilm getTheLoaiFilm() {
        return theLoaiFilm;
    }

    public void setTheLoaiFilm(GenreFilm theLoaiFilm) {
        this.theLoaiFilm = theLoaiFilm;
    }

    // Override toString method
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String header = String.format("%-10s | %-25s | %-15s | %-30s | %-20s | %-15s\n",
                "Film ID", "Film Format", "Genre", "Title", "Producer", "Release Date");

        String separator = new String(new char[header.length()]).replace("\0", "-") ;

        String row = null;
        try {
            row = String.format("%-10s | %-25s | %-15s | %-30s | %-20s | %-15s",
                    idFilm,
                    dangFilm.getDescription(),
                    theLoaiFilm.getDescription(),
                    title,
                    producer,
                    Validation.changeDateToString(Validation.changeStringToDate(getReleaseDate())));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return   row + "\n" + separator;
    }

}
