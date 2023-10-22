import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeckTest {
    private Deck deck;
    private List<Card> cards;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDeck() {
        //Assert that the Deck class exists and not null
        assertEquals(deck.getClass(), Deck.class);
        assertFalse(deck.getClass().equals(null));
    }

    @Test
    public final void testCreateDeck() {
        //Assert that the size of the deck is 52 always
        assertEquals(deck.getDeck().size(), Constants.NUMBER_OF_DECKS);
        assertFalse(deck.getDeck().size() == 0);
    }

    @Test
    public final void testShuffleDeck() {
        List<Card> copyDeck = new ArrayList<Card>();
        //Do a deep copy
        copyDeck.addAll(deck.getDeck());
        deck.shuffleDeck();

        assertFalse(deck.getDeck().equals(copyDeck));
    }

    @Test
    public final void testDealCard() {
        Card topCard = deck.getDeck().get(deck.getDeck().size() - 1);
        Card bottomCard = deck.getDeck().get(0);
        Card dealCard = deck.dealCard();

        //Assert that the deal card is equal to the top card and not the bottom card
        assertTrue(dealCard.equals(topCard));
        assertFalse(dealCard.equals(bottomCard));
    }

    @Test
    public final void testGetDeck() {
        //Assert that the deck size is 52 always
        assertEquals(deck.getDeck().size(), Constants.NUMBER_OF_DECKS);
    }

}
