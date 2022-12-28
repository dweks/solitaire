import java.util.Vector;

public class Foundation extends Pile{
	public int filledCapacity = 0;
	public Foundation(Vector<Card> cards) {
		super(cards);
	}

	public Card peekTopCard(){
		return cards.get(cards.size() - 1);
	}

	public String printTopCard(){
		return cards.get(cards.size() - 1).getShortCardString();
	}

	public Card extractTopCard(){
		Card hold = cards.get(cards.size() - 1);
		cards.remove(cards.size() - 1);
		filledCapacity -= 1;
		return hold;
	}

	public void appendCard(Card card) throws IllegalMove {
		if(cards.isEmpty() && !card.isAce())
			throw new IllegalMove("Foundation piles must start with an ACE.");
		filledCapacity += 1;
		cards.add(card);
	}
}