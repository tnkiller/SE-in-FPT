package Model.film;

public enum GenreFilm {
    HD("Action"),
    HA("Comedy"),
    KD("Horrified"),
    KHVT("Science Fiction"),
    TC("Romance"),
    PL("Adventure"),
    TH("Thriller"),
    MYS("Mystery"),
    DR("Drama"),
    CA("Cartoon"),
    FA("Fantasy");



    private final String description;

    GenreFilm(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}

