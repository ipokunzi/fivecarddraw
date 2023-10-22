public enum Suit {
    CLUBS("C", 1),
    DIAMONDS("D", 2),
    HEARTS("H", 3),
    SPADES("S", 4);

    private final String key;
    private final Integer value;

    Suit(String key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
