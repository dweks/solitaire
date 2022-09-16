import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try {
            Deck deck = new Deck();
            Collections.shuffle(deck.allCards);
            deck.printDeck();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
