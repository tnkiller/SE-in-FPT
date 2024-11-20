
package Model.customer;

public enum CustomerLevel {
    BRONZE("Bronze"),
    GOLD("Gold"),
    PLATINUM("Platinum");

    private final String description;

    CustomerLevel(String description) {
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
