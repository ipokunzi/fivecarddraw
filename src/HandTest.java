import org.junit.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
public class HandTest {
    private Hand hand;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        hand = new Hand(new Deck());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void testHand() {
        assertEquals(hand.getClass(), Hand.class);
        assertFalse(hand.getClass().equals(null));
    }

    @Test
    public final void testSetHand() {
        assertFalse(hand.getHand().isEmpty());
        assertEquals(hand.getHand().size(), 5);
    }

    @Test
    public final void testGetHand() {
        assertEquals(hand.getHand().size(), Constants.HAND_SIZE);
        assertFalse(hand.getHand().size() == 0);
    }

    @Test
    public void testHandForDuplicates(){
        Set<Card> uniqueCards = new HashSet<>();
        boolean duplicate = false;
        for (Card card : hand.getHand()) {
            if (uniqueCards.contains(card)) {
                duplicate = true; // Duplicate found
            }
            uniqueCards.add(card);
        }

        assertFalse(duplicate);
    }

    @Test
    public void testSameSuit(){
        assertTrue(Hand.sameSuit(List.of(new Card[]{
                new Card(Rank.TEN, Suit.CLUBS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.QUEEN, Suit.CLUBS),
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.ACE, Suit.CLUBS),
        })));
    }

    @Test
    public void testSameSequenceOfRanks(){
        assertTrue(Hand.sameSequenceOfRanks(List.of(new Card[]{
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.EIGHT, Suit.CLUBS),
                new Card(Rank.SEVEN, Suit.CLUBS),
                new Card(Rank.SIX, Suit.CLUBS),
                new Card(Rank.FIVE, Suit.CLUBS),
        })));
    }

    @Test
    public void testEvaluateStraightFlush(){
        assertEquals(HandStrenght.STRAIGHT_FLUSH, Hand.evaluateHand(List.of(new Card[]{
                new Card(Rank.QUEEN, Suit.HEARTS),
                new Card(Rank.JACK, Suit.HEARTS),
                new Card(Rank.TEN, Suit.HEARTS),
                new Card(Rank.NINE, Suit.HEARTS),
                new Card(Rank.EIGHT, Suit.HEARTS),
        })));
    }

    @Test
    public void testEvaluateFourOfAKind(){
        assertEquals(HandStrenght.FOUR_OF_A_KIND, Hand.evaluateHand(List.of(new Card[]{
                new Card(Rank.NINE, Suit.CLUBS),
                new Card(Rank.NINE, Suit.SPADES),
                new Card(Rank.NINE, Suit.DIAMONDS),
                new Card(Rank.NINE, Suit.HEARTS),
                new Card(Rank.JACK, Suit.HEARTS),
        })));
    }

    @Test
    public void testEvaluateFullHouse() {
        assertEquals(HandStrenght.FULL_HOUSE, Hand.evaluateHand(List.of(new Card[]{
                new Card(Rank.THREE, Suit.CLUBS),
                new Card(Rank.THREE, Suit.SPADES),
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.SIX, Suit.CLUBS),
                new Card(Rank.SIX, Suit.HEARTS),
        })));
    }

    @Test
    public void testEvaluateFlush() {
        assertEquals(HandStrenght.FLUSH, Hand.evaluateHand(List.of(new Card[]{
                new Card(Rank.KING, Suit.CLUBS),
                new Card(Rank.TEN, Suit.CLUBS),
                new Card(Rank.SEVEN, Suit.CLUBS),
                new Card(Rank.SIX, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.CLUBS),
        })));

    }

    @Test
    public void testEvaluateStraight    () {
        assertEquals(HandStrenght.STRAIGHT, Hand.evaluateHand(List.of(new Card[]{
                new Card(Rank.SEVEN, Suit.CLUBS),
                new Card(Rank.SIX, Suit.SPADES),
                new Card(Rank.FIVE, Suit.SPADES),
                new Card(Rank.FOUR, Suit.HEARTS),
                new Card(Rank.THREE, Suit.HEARTS),
        })));
    }

    @Test
    public void testEvaluateThreeOfAKind    () {
        assertEquals(HandStrenght.THREE_OF_A_KIND, Hand.evaluateHand(List.of(new Card[]{
                new Card(Rank.TWO, Suit.DIAMONDS),
                new Card(Rank.TWO, Suit.SPADES),
                new Card(Rank.TWO, Suit.CLUBS),
                new Card(Rank.KING, Suit.SPADES),
                new Card(Rank.SIX, Suit.HEARTS),
        })));
    }

    @Test
    public void testEvaluateTwoPair() {
        assertEquals(HandStrenght.TWO_PAIR, Hand.evaluateHand(List.of(new Card[]{
                new Card(Rank.JACK, Suit.HEARTS),
                new Card(Rank.JACK, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.CLUBS),
                new Card(Rank.FOUR, Suit.SPADES),
                new Card(Rank.NINE, Suit.HEARTS),
            })));
    }

    @Test
    public void testEvaluateOnePair() {
            assertEquals(HandStrenght.ONE_PAIR, Hand.evaluateHand(List.of(new Card[]{
                    new Card(Rank.FOUR, Suit.HEARTS),
                    new Card(Rank.FOUR, Suit.SPADES),
                    new Card(Rank.KING, Suit.SPADES),
                    new Card(Rank.TEN, Suit.DIAMONDS),
                    new Card(Rank.FIVE, Suit.SPADES),
            })));
    }

    @Test
    public void testEvaluateHighCard() {
        assertEquals(HandStrenght.HIGH_CARD, Hand.evaluateHand(List.of(new Card[]{
                new Card(Rank.KING, Suit.HEARTS),
                new Card(Rank.JACK, Suit.HEARTS),
                new Card(Rank.EIGHT, Suit.CLUBS),
                new Card(Rank.SEVEN, Suit.DIAMONDS),
                new Card(Rank.FOUR, Suit.SPADES),
        })));
    }
}
