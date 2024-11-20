package Model.film;

public enum MovieFormat {
    SHORT("Short Film"),
    LONG("Feature film"),
    F_TL("Documentary Film");

    private final String description;

    MovieFormat(String description) {
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
