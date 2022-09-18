import java.util.ArrayList;
import java.util.List;

public class Pile{
	protected ArrayList<Card> allCards = new ArrayList<>();
	public Pile(List<Card> cards) {
		allCards.addAll(cards);
	}

	public int size() { return this.allCards.size(); }
	public void revealLast() { allCards.get(allCards.size() - 1).revealCard(); }
	public Card getLast() { return this.allCards.get(allCards.size() - 1); }
	public void appendOne(Card card) { allCards.add(card); }
	public void appendMany(Pile pile) { allCards.addAll(pile.allCards); }

	public Pile extractMany(int startIndex){
		int endIndex = this.allCards.size() - 1;
		Pile newPile = new Pile((ArrayList<Card>) this.allCards.subList(startIndex, endIndex));
		this.allCards.subList(startIndex, endIndex).clear();
		return newPile;
	}

	// For testing
	public void printPile() {
		for(Card card : allCards) {
			card.printCard();
			System.out.println();
		}
	}

}
