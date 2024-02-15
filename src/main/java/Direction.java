// WOW LOOK AT THIS GREAT EXAMPLE OF COHESION
// ALL OF THE STUFF FOR DIRECTION IS IN THIS ONE PLACE
// IT IS CLEARLY ALL RELATED TO EACH OTHER AND HAS A SINGLE RESPONSIBILITY
// IT IS SO NICE YAY

public enum Direction {
    N("North"),
    S("South"),
    E("East"),
    W("West"),
    U("Up"),
    D("Down");

    private final String fullName;
    private Direction(String fullName) {
        this.fullName = fullName;
    }
    public String getFullName() {
        return fullName;
    }

    // Method to get the opposite direction
    public Direction getOpposite() {
        switch (this) {
            case N:
                return S;
            case S:
                return N;
            case E:
                return W;
            case W:
                return E;
            case U:
                return D;
            case D:
                return U;
            default:
                throw new IllegalArgumentException("Invalid direction: " + this);
        }
    }
}