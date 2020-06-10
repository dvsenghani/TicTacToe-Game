import java.util.Scanner;


public class TicTacToe
{
	private int cntr;
	private char posit[]=new char[10];
	private char playa;


	public static void main(String args[])
	{
		String choices;
		TicTacToe toe=new TicTacToe();
		do{
			toe.gameBoard();
			toe.players();
			System.out.println ("Would you like to players again (Enter 'yes')? ");
			Scanner sc =new Scanner(System.in);
			choices=sc.nextLine();
			System.out.println("choices value is "+choices);
		}while (choices.equals("yes"));


	}
	public void gameBoard()
	{

		char posDef[] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int uu;
		cntr = 0;
		playa = 'X';
		for (uu=1; uu<10; uu++) posit[uu]=posDef[uu];
		currBoard();


	}
	public String currBoard()
	{
		System.out.println( "\n\n" );
		System.out.println( "\n\n" );
		System.out.println( "\n\n\t\t" + posit [1] + " | " +posit [2]+ " | " +posit [3]);
		System.out.println( " \t\t | | " );
		System.out.println( " \t\t ___|____|___ " );
		System.out.println( "\n\n\t\t" +posit [4]+ " | " +posit [5]+ " | " +posit [6]);
		System.out.println( " \t\t | | " );
		System.out.println( " \t\t ___|____|___ " );
		System.out.println( "\n\n\t\t" +posit [7]+ " | " +posit [8]+ " | " +posit [9]);
		System.out.println( " \t\t | | " );
		System.out.println( " \t\t | | " );
		System.out.println( "\n\n" );
		return "currBoard";
	}

	public void players()
	{
		int sp;
		char empty = ' ';

		System.out.println( "Player " + getPlayas() +" will go first and be the letter 'X'" );

		do {
			currBoard();   

			System.out.println( "\n\n Player " + getPlayas() +" choose a posit." );

			boolean positTaken = true;
			while (positTaken) {
				System.out.println( "position is taken, please enter a valid space");
				Scanner sc =new Scanner (System.in);
				sp=sc.nextInt();
				positTaken = chckPosit(sp);
				if(positTaken==false)
					posit[sp]=getPlayas();
			}

			System.out.println( "Nice move." );

			currBoard();

			nxtPlaya();
		}while ( chckWin() == empty );

	}

	public char chckWin()
	{
		char winners = ' ';

		if (posit[1] == 'X' && posit[2] == 'X' && posit[3] == 'X') winners = 'X';
		if (posit[4] == 'X' && posit[5] == 'X' && posit[6] == 'X') winners = 'X';
		if (posit[7] == 'X' && posit[8] == 'X' && posit[9] == 'X') winners = 'X';
		if (posit[1] == 'X' && posit[4] == 'X' && posit[7] == 'X') winners = 'X';
		if (posit[2] == 'X' && posit[5] == 'X' && posit[8] == 'X') winners = 'X';
		if (posit[3] == 'X' && posit[6] == 'X' && posit[9] == 'X') winners = 'X';
		if (posit[1] == 'X' && posit[5] == 'X' && posit[9] == 'X') winners = 'X';
		if (posit[3] == 'X' && posit[5] == 'X' && posit[7] == 'X') winners = 'X';
		if (winners == 'X' )
		{System.out.println("Player1 wins the game." );
		return winners;
		}

		if (posit[1] == 'O' && posit[2] == 'O' && posit[3] == 'O') winners = 'O';
		if (posit[4] == 'O' && posit[5] == 'O' && posit[6] == 'O') winners = 'O';
		if (posit[7] == 'O' && posit[8] == 'O' && posit[9] == 'O') winners = 'O';
		if (posit[1] == 'O' && posit[4] == 'O' && posit[7] == 'O') winners = 'O';
		if (posit[2] == 'O' && posit[5] == 'O' && posit[8] == 'O') winners = 'O';
		if (posit[3] == 'O' && posit[6] == 'O' && posit[9] == 'O') winners = 'O';
		if (posit[1] == 'O' && posit[5] == 'O' && posit[9] == 'O') winners = 'O';
		if (posit[3] == 'O' && posit[5] == 'O' && posit[7] == 'O') winners = 'O';
		if (winners == 'O' )
		{
			System.out.println( "Player2 wins the game." );
			return winners; }

		for(int uu=1;uu<10;uu++)
		{
			if(posit[uu]=='X' || posit[uu]=='O')
			{
				if(uu==9)
				{
					char Draw='D';
					System.out.println(" Game is stalemate ");
					return Draw;
				}
				continue;
			}
			else
				break;

		}

		return winners;
	}

	public boolean chckPosit(int sp)
	{


		if (posit[sp] == 'X' || posit[sp] == 'O')
		{
			System.out.println("That posit is already taken, please choose another");
			return true;
		}
		else {
			return false;
		}
	}



	public void nxtPlaya()
	{
		if (playa == 'X')
			playa = 'O';
		else playa = 'X';

	}

	public String getTtl()
	{
		return "Tic Tac toe" ;
	}

	public char getPlayas()
	{
		return playa;
	}

}