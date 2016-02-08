
public class CheckerChecker
{
    public static boolean checkerCorrect = true;
	public static void main(String [] args)
	{
	    
	    int i, j;
	    
	    Checker newChecker = new Checker(true);
	    
	    newChecker = new Checker(true);
	    checkIndividual(newChecker,true,1,1);
	    
	    newChecker = new Checker(false);
	    checkIndividual(newChecker,false,1,1);
	    
	    newChecker = new Checker(true,1,1);
	    checkIndividual(newChecker,true,1,1);
	    
	    newChecker = new Checker(false,1,1);
	    checkIndividual(newChecker,false,1,1);
	    
	    for(i=1;i<=8;i++)
	    {
	        for(j=1;j<=8;j++)
	        {
	            newChecker = new Checker(false,i,j);
	            if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1))
	            {
	                checkIndividual(newChecker,false,i,j);
	                checkMove(newChecker);
	            }
	            else
	            {
	                checkIndividual(newChecker,false,1,1);
	            }
	            
	            newChecker = new Checker(true,i,j);
	            if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1))
	            {
	                checkIndividual(newChecker,true,i,j);
	            }
	            else
	            {
	                checkIndividual(newChecker,true,1,1);
	            }
	            
	        }
	    }
	    
	    if( checkerCorrect == true)
	    {
	        System.out.println("CORRECT");
	    }
	    else
	    {
	        System.out.println("BUG");
	    }
	    
	    
	    
	
	}
	
	private static void checkIndividual(Checker testChecker, boolean isRed, int theoreticalRow, int theoreticalColumn)
	{
	    if( testChecker.isRed() == isRed && testChecker.getRow() == theoreticalRow && testChecker.getColumn() == theoreticalColumn)
	    {
	        
	    }
	    else
	    {
	        checkerCorrect = false;
	    }
	}
	
	private static void checkMove(Checker testChecker)
	{
	    int k,l;
	    Checker moveChecker = new Checker(false);
	    for(k=-2;k<=2;k++)
	    {
	        for(l = -2;l<=2;l++)
	        {
                moveChecker = new Checker(false,testChecker.getRow(),testChecker.getColumn());
                moveChecker.move(k,l);
                if((l!= -1 && l!= 1) || k!= 1)
                {
                    checkIndividual(moveChecker,false,testChecker.getRow(),testChecker.getColumn());
                    
                }
                else if(l == -1 && testChecker.getColumn() == 1)
                {
                    checkIndividual(moveChecker,false,testChecker.getRow(),testChecker.getColumn());
                    
                }
                else if(l == 1 && testChecker.getColumn() == 8)
                {
                    checkIndividual(moveChecker,false,testChecker.getRow(),testChecker.getColumn());
                    
                }
                else if(k == 1 && testChecker.getRow() == 8)
                {
                    checkIndividual(moveChecker,false,testChecker.getRow(),testChecker.getColumn());
                }
                else
                {
                    checkIndividual(moveChecker,false,testChecker.getRow()+k,testChecker.getColumn()+l);
                } 
                
                
                moveChecker = new Checker(true,testChecker.getRow(),testChecker.getColumn());
                moveChecker.move(k,l);
                if((l!= -1 && l!= 1) || k!= -1)
                {
                    checkIndividual(moveChecker,true,testChecker.getRow(),testChecker.getColumn());
                }
                else if(l == -1 && testChecker.getColumn() == 1)
                {
                    checkIndividual(moveChecker,true,testChecker.getRow(),testChecker.getColumn());
                }
                else if(l == 1 && testChecker.getColumn() == 8)
                {
                    checkIndividual(moveChecker,true,testChecker.getRow(),testChecker.getColumn());
                }
                else if(k == -1 && testChecker.getRow() == 1)
                {
                    checkIndividual(moveChecker,true,testChecker.getRow(),testChecker.getColumn());
                }
                else
                {
                    checkIndividual(moveChecker,true,testChecker.getRow()+k,testChecker.getColumn()+l);
                }   	        
	        }
	    }
	    
	}
}
