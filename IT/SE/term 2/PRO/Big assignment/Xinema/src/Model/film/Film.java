package Model.film;

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
        return String.format("%-10s | %-25s | %-15s | %-30s | %-20s | %-15s",
                idFilm, dangFilm.getDescription(), theLoaiFilm.getDescription(), title, producer, releaseDate);
    }

}
