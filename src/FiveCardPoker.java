public class FiveCardPoker {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand hand = new Hand(deck);

        // Evaluate and display the player's hand
        hand.displayHand();
        hand.displayStrength();

    }

}