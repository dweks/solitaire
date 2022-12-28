import java.util.Vector;

public class Tableau extends Pile {
	public Tableau(Vector<Card> cards){
		super(cards);
	}

	public void revealLast() {
		cards.get(cards.size() - 1).revealCard();
	}

	public void hideLast() {
		cards.get(cards.size() - 1).hideCard();
	}

	public Vector<Card> extractCards(int startIndex){
		if(cards.size() == 0)
			return null;
		Vector<Card> hold = new Vector<>(cards.subList(startIndex, cards.size()));
		cards.subList(startIndex, cards.size()).clear();
		return hold;
	}

	public void appendCards(Vector<Card> cards) {
		this.cards.addAll(cards);
	}

}