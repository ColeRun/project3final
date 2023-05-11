package edu.guilford;

import java.util.Random;

public class handgen {
    static String result;
    // attributes for a game of blackjack
    private int hand;
    private int card1;
    private int card2;
    private int card3;

    // method to generate a random hand
    public void generateHand() {
        Random rand = new Random();
        int hand = rand.nextInt(3);
        if (hand == 0) {
            card1 = rand.nextInt(10) + 1;
            card2 = rand.nextInt(10) + 1;
            card3 = rand.nextInt(10) + 1;
        } else if (hand == 1) {
            card1 = rand.nextInt(10) + 1;
            card2 = rand.nextInt(10) + 1;
            card3 = 0;
        } else if (hand == 2) {
            card1 = rand.nextInt(10) + 1;
            card2 = 0;
            card3 = 0;
        }
    }

    // method to get card 1
    public int getCard1() {
        return card1;
    }

    // method to get card 2
    public int getCard2() {
        return card2;
    }

    // method to get card 3
    public int getCard3() {
        return card3;
    }

    // method to play the game
    public static String playGame() {

        int n = 0;
        String[] playerwins = new String[1];
        handgen dealer = new handgen();
        handgen player = new handgen();
        int index = 0;
        while (n < 1) {
            dealer.generateHand();
            player.generateHand();
            // call to set dealer and player cards
            int dealerCard1 = dealer.getCard1();
            int dealerCard2 = dealer.getCard2();
            int dealerCard3 = dealer.getCard3();
            int playerCard1 = player.getCard1();
            int playerCard2 = player.getCard2();
            int playerCard3 = player.getCard3();

            // call to set dealer and player totals
            int dealerTotal = dealerCard1 + dealerCard2 + dealerCard3;
            int playerTotal = playerCard1 + playerCard2 + playerCard3;
            // call to set dealer and player busts
            boolean dealerBust = dealerTotal > 21;
            boolean playerBust = playerTotal > 21;
            // call to set dealer and player wins
            boolean dealerWin = dealerTotal > playerTotal;
            boolean playerWin = playerTotal > dealerTotal;
            // call to set dealer and player ties
            boolean dealerTie = dealerTotal == playerTotal;
            boolean playerTie = playerTotal == dealerTotal;

            // save the wins under an array

            // if statements to determine the winner
            result = "Dealer's cards: " + dealerCard1 + " " + dealerCard2 + " " + dealerCard3;
            result += "\n" + "Player's cards: " + playerCard1 + " " + playerCard2 + " " + playerCard3;
            // print the dealer and player totals
            result += "\n" + "Dealer's total: " + dealerTotal;
            result += "\n" + "Player's total: " + playerTotal;

            if (dealerBust && playerBust) {

                playerwins[index] = "Tie";
            } else if (dealerBust) {

                playerwins[index] = "Player";
            } else if (playerBust) {

                playerwins[index] = "Dealer";
            } else if (dealerWin) {

                playerwins[index] = "Dealer";
            } else if (playerWin) {

                playerwins[index] = "Player";

            } else if (dealerTie) {

                playerwins[index] = "Tie";

            }
            index += 1;
            n += 1;

        }
        // getter for result

        // toString method to print the array
        System.out.println("Results of the game \n" + java.util.Arrays.toString(playerwins));
        System.out.print(result);
        // return playerwins string
        String resultString = (result + "\n" + java.util.Arrays.toString(playerwins));
        return resultString;
    }
    // method to get the hand

}
