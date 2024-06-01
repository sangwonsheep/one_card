import java.util.List;

public class Player {

    private final String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
    }

    /**
     * 카드 개수 리턴
     */
    public int cardsLength() {
        return cards.size();
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
