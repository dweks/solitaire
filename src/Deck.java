import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	ArrayList<Card> allCards = new ArrayList<>();
	public Deck() throws Exception {
		generateDeck();
	}
	public void generateDeck() throws Exception {
		for(Suit suit : Suit.values()){
			for(int i = 1; i < 14; ++i) {
				allCards.add(new Card(new Value(i), suit));
			}
		}
	}

	public void shuffleDeck() {
		Collections.shuffle(allCards);
	}

	public Pile extractPile(int size) {
		int startIndex = allCards.size() - size;
		int endIndex = allCards.size() - 1;
		Pile newPile = new Pile(allCards.subList(startIndex, endIndex));
		allCards.subList(startIndex, endIndex).clear();
		return newPile;
	}

	public void printDeck() {
		for(Card card : allCards) {
			card.printCard();
			System.out.println();
		}
	}
}
