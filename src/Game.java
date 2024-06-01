import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {

    public void startGame() {
        Deck deck = new Deck(); // 덱 셋팅
        Dealer dealer = new Dealer(deck); // 딜러에게 덱 넘겨주기
        Player[] players = getPlayers(); // 플레이어 셋팅
        List<String> winner = new ArrayList<>();

        shuffleAndDistribute(dealer, players);
        Card card = deck.draw(); // 바닥에 놓을 카드
        System.out.println("처음 카드 : " + card.getSuit() + " " + card.getNumber());

        int turn = 0;
        outer: while (deck.cardsLength() > 0) { // 전체 카드 수가 0이 되면 종료
            List<Card> playerCards = players[turn].getCards(); // 현재 플레이어의 전체 카드 조회
            Iterator<Card> iterator = playerCards.iterator();
            boolean cardMatched = false;
            while (iterator.hasNext()) { // 플레이어 가진 카드 처음부터 끝까지 순서대로 탐색
                Card playerCard = iterator.next();
                if(playerCard.equals(card)) { // 바닥에 놓여진 카드와 플레이어의 카드가 일치
                    System.out.println(players[turn].getName() + "가 제출한 카드 : " + card.getSuit() + " " + card.getNumber());
                    card = playerCard; // 플레이어가 가진 카드로 놓여져 있는 카드 교체
                    iterator.remove(); // 플레이어의 카드 1개 감소
                    cardMatched = true;
                    if(playerCards.isEmpty()) { // 플레이어의 카드 수가 0이 되면 종료
                        winner.add(players[turn].getName()); // 승리자의 이름 발표를 위해 플레이어 이름 저장
                        break outer;
                    }
                    break;
                }
            }

            if(!cardMatched) { // 일치하는 카드가 없을 경우
                playerCards.add(deck.draw());
                finishIfDeckEmpty(deck, players, winner);
            }

            printPlayerCards(players, turn, deck);

            turn++;
            turn %= players.length;
        }

        dealer.notifyWinner(winner);
        printPlayerCards(players);
    }

    /**
     * 게임 종료 시 플레이어 별 남은 카드 개수 출력
     */
    private void printPlayerCards(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getName() + " : " + players[i].cardsLength() + " | ");
        }
        System.out.println();
    }

    /**
     *  플레이어 별 남은 카드 개수 출력 
     */
    private void printPlayerCards(Player[] players, int turn, Deck deck) {
        System.out.println("현재 덱 개수 : "  + deck.cardsLength() + " | " + players[turn].getName() + "'s turn");
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getName() + " : " + players[i].cardsLength() + " | ");
        }
        System.out.println(); System.out.println();
    }

    /**
     * 덱 섞기, 플레이어에게 덱 나눠주기
     */
    private void shuffleAndDistribute(Dealer dealer, Player[] players) {
        dealer.shuffle(); // 덱 섞기
        dealer.distributeCards(players); // 플레이어에게 덱 나눠주기
    }

    /**
     * 덱 개수가 0개인 경우 게임 종료
     */
    private void finishIfDeckEmpty(Deck deck, Player[] players, List<String> winner) {
        if(deck.cardsLength() == 0){
            int min = players[0].cardsLength();
            for (int i = 1; i < players.length; i++) {
                if(min > players[i].cardsLength())
                    min = players[i].cardsLength();
            }

            for (int i = 0; i < players.length; i++) {
                if(min == players[i].cardsLength()) {
                    winner.add(players[i].getName());
                }
            }
        }
    }

    /**
     * 플레이어 수 정하기
     * 플레이어 이름 정하기
     */
    private Player[] getPlayers() {
        Player[] players = new Player[4];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player" + (i+1));
        }
        return players;
    }
}
