/*
*   Author: Nicholas Cook
*   Login: njcook
*   File: PokerHand.java
*   Purpose: This is the Object Class to store a poker hand. On initialisation
*            determines the hands worth and stores it.
*/


package poker; 

public class PokerHand
{
    private String[] hand = new String[5];
    private int player;


    private static final String validDigit = "23456789TJQKA";
    private static final String[] outputDigits = 
            {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

// Default the hand type to High Card.
    private HandType handType = HandType.HIGHCARD;
// Array to store the value of card multiples
    private char[] multiplesOf = new char[2];

// This is the object constructor. Reads in the cards, sorts the hand by card
// value and then determines the hands worth
    public PokerHand(String[] hand, int player)
    {
        for(int i = 0; i < 5; i++)
        {
            this.hand[i] = hand[i];
        }
        
        this.player = player;
        sortHand();
        judgeHand();
    }

// Public method to get cards Rank. Rank being four of a kind, straight, etc.
    public int getHandRank()
    {
        return handType.getNumVal();
    }

// Public method to return value of multiples in a hand.
// The more significant value is stored in 0.
    public int[] getHandValue()
    {
        int[] cards = new int[2];
        cards[0] = validDigit.indexOf(multiplesOf[0]);
        cards[1] = validDigit.indexOf(multiplesOf[1]);
        return cards;
    }

// Public method to return player number
    public int getPlayerNumber()
    {
        return player;
    }

// Public method to get the value of a specific card
    public int getCardValue(int card)
    {
        return validDigit.indexOf(hand[card].charAt(0));
    }

// This function is called to sort the cards in a hand so that the highest value
// card comes first. This is a linear sort of complexity n-squared. 
// This function compares two elements and if the second card is greater,
// flips their position utilising a temporary variable to hold one of the cards
    private void sortHand()
    {
        String temporarySwitch;
        boolean changeMade = true;

        while (changeMade)
        {
            changeMade = false;
            for (int j = 0; j < hand.length  - 1; j++)
            {
                if (validDigit.indexOf(hand[j].charAt(0)) 
                    < validDigit.indexOf(hand[j + 1].charAt(0)))
                {
                    temporarySwitch = hand[j];
                    hand[j] = hand[j+1];
                    hand[j + 1] = temporarySwitch;
                    changeMade = true;
                }
            }
        }
    }

// This function is a public method to print out the worth of the hand on
// function uses a switch using the handtype and the cards in stored in the 
// multiples array
    public void printHand()
    {
        System.out.printf("Player %d: ",player);
        switch (handType)
        {
            case STRAIGHTFLUSH:
                System.out.printf("%s-high straight flush\n",
                    outputDigits[validDigit.indexOf(hand[0].charAt(0))]);
                break;

            case FOUROFAKIND:
                System.out.printf("Four %ss\n",
                    outputDigits[validDigit.indexOf(multiplesOf[0])]);
                break;

            case FULLHOUSE:
                System.out.printf("%ss full of %ss\n",
                    outputDigits[validDigit.indexOf(multiplesOf[0])],
                    outputDigits[validDigit.indexOf(multiplesOf[1])]);
                break;

            case FLUSH:
                System.out.printf("%s-high flush\n",
                    outputDigits[validDigit.indexOf(hand[0].charAt(0))]);
                break;

            case STRAIGHT:
                System.out.printf("%s-high straight\n",
                    outputDigits[validDigit.indexOf(hand[0].charAt(0))]);
                break;

            case THREEOFAKIND:
                System.out.printf("Three %ss\n",
                    outputDigits[validDigit.indexOf(multiplesOf[0])]);
                break;

            case TWOPAIR:
                System.out.printf("%ss over %ss\n",
                    outputDigits[validDigit.indexOf(multiplesOf[0])],
                    outputDigits[validDigit.indexOf(multiplesOf[1])]);
                break;

            case ONEPAIR:
                System.out.printf("Pair of %ss\n",
                    outputDigits[validDigit.indexOf(multiplesOf[0])]);
                break;

            case HIGHCARD:
                System.out.printf("%s-high\n",
                    outputDigits[validDigit.indexOf(hand[0].charAt(0))]);
                break;

            default:
                break;
        }

    }

// This Private funcion is called in the construction of a PokerHand in order 
// to determine the worth of  the hand. 
    private void judgeHand()
    {
        boolean flush = false;
        boolean straight = false;
        int count = 0;
        // This array holds the value of any fours, trips or pairs in order of 
        // significance. They are initialised as zero so that their worth can
        // be checked later. (Two pair or full house)
        multiplesOf[0] = '0';
        multiplesOf[1] = '0';

        // These two functions are called to determine if the hand is a flush
        // or/and flush. They are called later.
        flush = determineFlush();
        straight = determineStraight();


        // This loop iterates thorugh the sorted hand, comparing the card value
        // of two adjacent cards. If they are equal it keeps a running count 
        // to determine if it is pair, trips or a four of a kind.
        for (int i = 0; i < 4; i++)
        {
            if (hand[i].charAt(0) == hand[i+ 1].charAt(0))
            {
                count ++;
            }
            // If a pair is not equal, or are equal but you are looking at the 
            // last cards. The following if statement, checks the count 
            // and updates the cards rank and the multiples array accordingly
            if (hand[i].charAt(0) != hand[i+ 1].charAt(0) || 
                    (hand[i].charAt(0) == hand[i+ 1].charAt(0) && i == 3))
            {
                if (count >= 3) // Check for four of a kind
                {
                    multiplesOf[0] = hand[i].charAt(0);
                    handType = HandType.FOUROFAKIND;                    
                }
                else if (count == 2) // Check for trips
                {
                    // Check if a pair already exists. If so a trip has more 
                    // significance so rearrange the multiples array. 
                    if (multiplesOf[0] != '0')
                    {
                        multiplesOf[1] = multiplesOf[0];
                        multiplesOf[0] = hand[i].charAt(0);
                        handType = HandType.FULLHOUSE;
                    }
                    else
                    {
                        multiplesOf[0] = hand[i].charAt(0);
                        handType = HandType.THREEOFAKIND;
                    }
                }
                else if (count == 1) // Check for a Pair
                {
                    // check if a triple already exists
                    if (multiplesOf[0] != '0' 
                        && handType == HandType.THREEOFAKIND) 
                    {
                        
                        multiplesOf[1] = hand[i].charAt(0);
                        handType = HandType.FULLHOUSE;
                    }
                    // check if a pair already exists
                    else if (multiplesOf[0] != '0') 
                    {
                        multiplesOf[1] = hand[i].charAt(0);
                        handType = HandType.TWOPAIR;
                    }
                    else
                    {
                        multiplesOf[0] = hand[i].charAt(0);
                        handType = HandType.ONEPAIR;
                    }   
                }
                count = 0;
            }
        }

        // Finally determine if a straigh and/or flush exists
        if (straight == true && flush && true)
        {
            handType = HandType.STRAIGHTFLUSH;
        }
        else if (straight == true)
        {
            handType = HandType.STRAIGHT;
        }
        else if (flush == true)
        {
            handType = HandType.FLUSH;
        }
    }

// A private function to determine if all the suites of each card match
    private boolean determineFlush()
    {
        for(int i = 0; i < 4; i ++)
        {
            if (hand[i].charAt(1) != hand[i+ 1].charAt(1))
            {
                return false;
            }
        }
        return true;
    }

// A private function to determine if a straight exists. Because the hand has 
// been sorted. Can check if each card descends by one each time.
    private boolean determineStraight()
    {
        for(int i = 0; i < 4; i ++)
        {
            if (validDigit.indexOf(hand[i].charAt(0)) 
                != validDigit.indexOf(hand[i+ 1].charAt(0)) - 1)
            {
                return false;
            }
        }
        return true;
    }
}