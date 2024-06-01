import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards; // 카드 전체 52장

    public Deck() {
        setCards();
    }

    /**
     * 카드 셋팅
     * 숫자 : 1~13, 문양 : 하트('H'), 다이아('D'), 클로바('C'), 스페이드('S')
     */
    private void setCards() {
        cards = new ArrayList<>();
        char[] suits = {'H', 'D', 'C', 'S'};
        for (int i = 0; i < 52; i++) {
            cards.add(new Card(((i % 13) + 1), suits[i / 13]));
        }
    }

    /**
     * 카드 뽑기
     */
    public Card draw() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    /**
     * 카드 개수 리턴
     */
    public int cardsLength() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }
}
