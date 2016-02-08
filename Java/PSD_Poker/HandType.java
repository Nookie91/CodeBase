package poker;

// Enum to hand the types of hands possible and their rankings amoung each other
private static enum HandType 
{
    STRAIGHTFLUSH(8), FOUROFAKIND(7), 
    FULLHOUSE(6), FLUSH(5),
    STRAIGHT(4), THREEOFAKIND(3), 
    TWOPAIR(2), ONEPAIR(1), HIGHCARD(0);
    
    private int numVal;
    
    HandType(int numVal)
    {
        this.numVal = numVal;
    }
    
    public int getNumVal()
    {
        return numVal;
    }
};