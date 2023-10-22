public class Card implements Comparable<Card> {
    // suit and rank variables
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        if(rank == null || suit == null){
            throw new IllegalArgumentException("Argument can't be null rank or suit");
        }
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }
    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card other) {
        return this.rank.ordinal() - other.rank.ordinal();
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}