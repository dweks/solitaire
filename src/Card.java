public class Card {
    protected Value value;
    protected Suit suit;
    protected String color;
    protected boolean revealed;

    public Card(Value value, Suit suit){
        this.value = value;
        this.suit = suit;
        if(this.suit == Suit.DIAMOND || this.suit == Suit.HEART)
            this.color = "-";
        else
            this.color = "|";
        this.revealed = false;
    }

    public void revealCard() {
        revealed = true;
    }
    public void hideCard() {
        revealed = false;
    }

    public String getCardString() {
        if(revealed) {
            String maybeSpace = "";
            if (value.asString().length() == 1)
                maybeSpace = " ";
//            return color + maybeSpace + value.asString() + " " + getSuitString();
            return maybeSpace + value.asString() + color + " " + getSuitString();
        } else {
            return "#####";
        }
    }
    public String getShortCardString() {
        String maybeSpace = "";
        revealed = true;
        if (value.asString().length() == 1)
            maybeSpace = " ";
        return maybeSpace + value.asString() + getSuitString();
    }

    public String getSuitString() {
        switch (suit) {
            case DIAMOND -> {return "d";}
            case CLUB -> {return "c";}
            case HEART -> {return "h";}
            case SPADE -> {return "s";}
        }
        return null;
    }

    // This card is an ace (only relevant for being first card on foundation)
    public boolean isAce() {
        return value.asString() == "A";
    }
    // This card's value is above the destination card's value
    public boolean isOneAbove(int destinationValue){
        return value.asNumber() == destinationValue - 1;
    }

    // This card may be placed on top of destination tableau
    public boolean compatibleTableau(Card destination){
        return isOneAbove(destination.value.asNumber()) && color != destination.color;
    }

    // This card may be placed on top of destination foundation
    public boolean compatibleFoundation(Card destination){
        return isOneAbove(destination.value.asNumber()) && suit == destination.suit;
    }
}