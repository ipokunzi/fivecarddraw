import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    //List of deck of cards
    private List<Card> deck = new ArrayList<Card>();

    Deck(){
        createDeck();
    }

    //Create a deck of 52 cards
    public void createDeck(){
        ArrayList<Card> deck = new ArrayList<Card>();
        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                deck.add( new Card(rank, suit) );//create cards
            }
        }
        this.deck = deck;
    }
    //Shuffle the deck
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    //Deal one card from the top of the deck
    //Return null if the deck is empty.
    public Card dealCard(){
        return deck.isEmpty() ? null : deck.remove(deck.size()-1);
    }

    //Get deck of cards
    public List<Card> getDeck(){
        return deck;
    }

}
