import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardTest {
    private static Card card;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        card = new Card(Rank.ACE, Suit.DIAMONDS);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void testCard() {
        Assert.assertEquals(card.getClass(), Card.class);
        assertFalse(card.getClass().equals(null));
    }

    @Test
    public final void testGetRank() {
        Assert.assertEquals(card.getRank(), Rank.ACE);
        assertFalse(card.getRank().equals(Rank.THREE));
    }

    @Test
    public final void testGetSuit() {
        Assert.assertEquals(card.getSuit(), Suit.DIAMONDS);
        assertFalse(card.getSuit().equals(Suit.SPADES));
    }

    @Test
    public final void testToString() {
        assertTrue(card.toString().equals("ACE of DIAMONDS"));
        assertFalse(card.toString().equals("ACE of SPADES"));
    }

    @Test
    public final void testCompareTo() {
        Assert.assertEquals(card.compareTo(card), 0);
        assertFalse(card.compareTo(card) == 1);
    }

}