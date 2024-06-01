
public class Card {

    private final int number; // 숫자
    private final char suit; // 문양

    public Card(int number, char suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public char getSuit() {
        return suit;
    }

    public boolean equals(Card card) {
        if(this.number == card.getNumber() || this.suit == card.getSuit()) {
            return true;
        }
        return false;
    }
}
