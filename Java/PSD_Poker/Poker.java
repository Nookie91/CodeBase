/*
*   Author: Nicholas Cook
*   Login: njcook
*   File: Poker.java
*   Purpose: Main function, Reads in input, checks it, creates hands and 
*            determines winner
*/


package poker;

public class Poker
{
    private static int numberOfPlayers;
    private static String[] cards;
    private static PokerHand[] hands;

// This is the main loop, it reads in the cards, checks to make sure the input
// is valid, create the hands and then determine the winner
    public static void main(String [] args)
    {
        cards = args;
        numberOfPlayers = 0;

        inputChecker();

        for(int i = 0; i < cards.length; i++)
        {
            cards[i] = cards[i].toUpperCase();
        } 

        numberOfPlayers = (cards.length / 5);
        createHands();
        determineWinner();      
    }

// This function Checks to make sure that the number of cards is devisible by 5
// It then checks to see if every card that is inputed is a valid card in both 
// digit and suite
    private static void inputChecker()
    {
        final String incorrectArgsLength = 
            "Error: wrong number of arguments; must be a multiple of 5";

        final String invalidCard = 
            "Error: invalid card name '%s'\n";

        final String validDigit = "23456789TJQKA";
        final String validSuite = "CDHS";

// For ease of checking this variable to hold an uppercase version of a card
        String tempCard; 

        if ((cards.length % 5) != 0)
        {
            System.out.println(incorrectArgsLength);
            System.exit(1);
        }

        for(String card: cards)
        {
            tempCard = card.toUpperCase();
            if (tempCard.length() != 2
                || !validDigit.contains(Character.toString(tempCard.charAt(0))) 
                || !validSuite.contains(Character.toString(tempCard.charAt(1))))
            {
                System.out.printf(invalidCard,card);
                System.exit(1);
            }
        }
    }


// This function takes the cards that are inputed and breaks them up into lots 
// of 5. This sets of five are then used to initialise a PokerHand object and
// is stored in an array. The object in initialisation then determines its own
// worth and the function prints out this out.
    private static void createHands()
    {
        hands = new PokerHand[numberOfPlayers];
        String[] currentHand = new String[5];

        for(int i = 0; i < numberOfPlayers; i++)
        {
            currentHand[0] = cards[i*5 + 0];
            currentHand[1] = cards[i*5 + 1];
            currentHand[2] = cards[i*5 + 2];
            currentHand[3] = cards[i*5 + 3];
            currentHand[4] = cards[i*5 + 4];

            hands[i] = new PokerHand(currentHand, i + 1); // add one to player number
            hands[i].printHand();
        }
    }

// This function is used to determine the winner or winners in case of a draw.
    private static void determineWinner()
    {
        int[] currentWinners = new int[numberOfPlayers];
        currentWinners[0] = 0;
        int comparison = 0;
        int numberOfWinners = 1;

        // This loop is used to iterate through the hands and 
        // determine which hand(s) are currently winning. To do so
        // it compares the current winning hand (first hand is winning by 
        // default) and stores which hand(s) are winning in an array.
        for(int j = 1; j < numberOfPlayers; j++)
        {
            comparison = compareHands(hands[currentWinners[0]],hands[j]);
            if (comparison == 2)
            {
                for(int i = 1; i < numberOfPlayers; i++)
                {
                    currentWinners[i] = -1;
                }
                currentWinners[0] = j;
                numberOfWinners = 1;
            }
            else if (comparison == 0)
            {
                currentWinners[numberOfWinners] = j;
                numberOfWinners ++;
            }
        }

        // This section prints out which hand(s) won or drew for first
        if (numberOfWinners > 1)
        {
            System.out.print("Players ");
            for (int i = 0; i < numberOfWinners ; i ++)
            {
                if (i == numberOfWinners - 1)
                {
                    System.out.print(" and ");
                }
                else if (i != 0)
                {
                    System.out.print(", ");
                }
                System.out.print(hands[currentWinners[i]].getPlayerNumber());
            }
            System.out.print(" draw.\n");
        }
        else
        {
            System.out.print("Player ");
            System.out.print(hands[currentWinners[0]].getPlayerNumber());
            System.out.print(" wins.\n");
        }
    }

// This function compares which hand has a greater value. It returns 2 if hand 2
// is greater, 1 if hand 1 is greater or 0 if the hands are equal. To do this
// It compares the hands rank, then the value of the more significant card is
// compared, the next card and then the highest card.
    private static int compareHands(PokerHand hand1, PokerHand hand2)
    {
        if (hand1.getHandRank() > hand2.getHandRank())
        {
            return 1;
        }
        else if (hand1.getHandRank() < hand2.getHandRank())
        {
            return 2;
        }
        else if (hand1.getHandValue()[0] > hand2.getHandValue()[0])
        {
            return 1;
        }
        else if (hand1.getHandValue()[0] < hand2.getHandValue()[0])
        {
            return 2;
        }
        else if (hand1.getHandValue()[1] > hand2.getHandValue()[1])
        {
            return 1;
        }
        else if (hand1.getHandValue()[1] < hand2.getHandValue()[1])
        {
            return 2;
        }

        for (int i = 0; i < 5; i++)
        {    
            if (hand1.getCardValue(i) > hand2.getCardValue(i))
            {
                return 1;
            }
            else if (hand1.getCardValue(i) < hand2.getCardValue(i))
            {
                return 2;
            }
        }
        return 0;
    }
}