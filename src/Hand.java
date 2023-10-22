import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

public class Hand {
    private List<Card> hand = new ArrayList<>();

    Hand(Deck deck)
    {
        setHand(deck);
    }

    public void setHand(Deck deck) {
        System.out.println("Shuffling... Shuffling... Shuffling...");
        deck.shuffleDeck();
        List<Card> hand = new ArrayList<>();

        for (int i=0; i<Constants.HAND_SIZE; i++)
        {
            hand.add(deck.dealCard());
        }
        this.hand = hand;
    }

    public List<Card> getHand(){
        return hand;
    }

    //Deal a specified number of cards from the deck by removing a card from the top of the deck
    static List<Card> dealHand(List<Card> deck, int numberOfCards) {
        if(deck == null || numberOfCards == 0){
            throw new IllegalArgumentException("Argument can't be null deck or numberOfCards");
        }
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            hand.add(deck.remove(0));
        }
        return hand;
    }

    //Check for same sequence in a hand
    public static boolean sameSequenceOfRanks(List<Card> hand){
        for (int i = 0; i < hand.size() - 1; i++) {
            if(hand.get(i).getRank().getValue() != hand.get(i + 1).getRank().getValue() + 1)
                return false;
        }
        return true;
    }

    //Check for same suit in a hand
    public static boolean sameSuit(List<Card> hand){
        for (Card c : hand) {
            if (!c.getSuit().equals(hand.get(0).getSuit()))
                return false;
        }
        return true;
    }

    //Group rank occurrences in a map
    public static HashMap<Rank, Integer> getRankOccurrences(List<Card> hand){
        HashMap<Rank, Integer> cardRankMap = new HashMap<>();

        for (Card card : hand) {
            cardRankMap.put(card.getRank(), cardRankMap.getOrDefault(card.getRank(), 0) + 1);
        }

        return cardRankMap;
    }

    // Evaluate the player's hand
    static HandStrenght evaluateHand(List<Card> hand) {
        if (isStraightFlush(hand)) {
            return HandStrenght.STRAIGHT_FLUSH;
        } else if (isFourOfAKind(hand)) {
            return HandStrenght.FOUR_OF_A_KIND;
        } else if (isFullHouse(hand)) {
            return HandStrenght.FULL_HOUSE;
        } else if (isFlush(hand)) {
            return HandStrenght.FLUSH;
        } else if (isStraight(hand)) {
            return HandStrenght.STRAIGHT;
        } else if (isThreeOfAKind(hand)) {
            return HandStrenght.THREE_OF_A_KIND;
        } else if (isTwoPair(hand)) {
            return HandStrenght.TWO_PAIR;
        } else if (isOnePair(hand)) {
            return HandStrenght.ONE_PAIR;
        } else {
            return HandStrenght.HIGH_CARD;
        }
    }

    //Check if a hand is straight flush i.e same sequence of ranks and same suit
    private static boolean isStraightFlush(List<Card> hand) {
        return (sameSequenceOfRanks(hand) && sameSuit(hand));
    }

    //Check if a hand is four of a kind
    private static boolean isFourOfAKind(List<Card> hand) {
        int quadrupole = 0;
        int noPair = 0;

        for (Map.Entry<Rank, Integer> entry : getRankOccurrences(hand).entrySet()) {
            if(entry.getValue().equals(4))
                quadrupole++;
            if(entry.getValue().equals(1))
                noPair++;
        }
        return (quadrupole == 1 && noPair == 1) || (quadrupole == 1 && noPair == 0);
    }

    //Check if a hand is a full house
    private static boolean isFullHouse(List<Card> hand) {
        if ((hand.get(0).getRank() == hand.get(1).getRank() && hand.get(2).getRank() == hand.get(4).getRank()) ||
                (hand.get(0).getRank() == hand.get(2).getRank() && hand.get(3).getRank() == hand.get(4).getRank())) {
            return true;
        }
        return false;
    }

    //Check if a hand is a flush
    private static boolean isFlush(List<Card> hand) {
        return (!sameSequenceOfRanks(hand) && sameSuit(hand));
    }

    //Check if a hand is a straight
    private static boolean isStraight(List<Card> hand) {
        return (sameSequenceOfRanks(hand) && !sameSuit(hand));
    }

    //Check if a hand is a three of a kind
    private static boolean isThreeOfAKind(List<Card> hand) {
        int triplet = 0;
        int noPair = 0;

        for (Map.Entry<Rank, Integer> entry : getRankOccurrences(hand).entrySet()) {
            if(entry.getValue().equals(3))
                triplet++;
            if(entry.getValue().equals(1))
                noPair++;
        }
        return (triplet == 1 && noPair == 2);
    }

    //Check if a hand is a two pair
    private static boolean isTwoPair(List<Card> hand) {
        if ((hand.get(0).getRank() == hand.get(1).getRank() && hand.get(2).getRank() == hand.get(3).getRank()) ||
                (hand.get(0).getRank() == hand.get(1).getRank() && hand.get(3).getRank() == hand.get(4).getRank()) ||
                (hand.get(1).getRank() == hand.get(2).getRank() && hand.get(3).getRank() == hand.get(4).getRank())) {
            return true;
        }
        return false;
    }

    //Check if a hand is a one pair
    private static boolean isOnePair(List<Card> hand) {
        int pair = 0;
        int noPair = 0;

        for (Map.Entry<Rank, Integer> entry : getRankOccurrences(hand).entrySet()) {
            if(entry.getValue().equals(2))
                pair++;
            if(entry.getValue().equals(1))
                noPair++;
        }
        return ( (pair == 1 && noPair == 3));
    }

    //Display hand
    public void displayHand()
    {
        System.out.println("Your hand: " + hand);
    }

    //Display hand strength
    public void displayStrength()
    {
        System.out.println("Your have: " + evaluateHand(hand));
    }
}
