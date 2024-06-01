import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {

    private Deck deck;

    public Dealer(Deck deck) {
        this.deck = deck;
    }

    /**
     * 카드 섞기
     */
    public void shuffle() {
        Collections.shuffle(deck.getCards());
    }

    /**
     * 플레이어에게 카드 나눠주기
     */
    public void distributeCards(Player[] players) {
        List<Card> cards = deck.getCards();
        for (int i = 0; i < players.length; i++) {
            ArrayList<Card> playerCard = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                playerCard.add(cards.get(0));
                cards.remove(0);
            }
            players[i].setCards(playerCard);
        }
    }

    /**
     * 승자 알려주기
     */
    public void notifyWinner(List<String> names) {
        System.out.println("----------------");
        for (String name : names) {
            System.out.println("승리자 : " + name);
        }
        System.out.println("----------------");
    }
}
