import java.util.Vector;

abstract public class Pile{
	protected Vector<Card> cards = new Vector<>();
	public Pile(Vector<Card> cards) {
		this.cards.addAll(cards);
	}

	public String printCertainCard(int index) {
		return cards.get(index).getCardString();
	}

	public int size() {
		return cards.size();
	}
}