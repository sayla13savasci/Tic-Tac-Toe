import java.util.Scanner;

public class Tic_tac_toe{
	
	public static char [][] matrix =
	{
		{' ',' ',' '},
		{' ',' ',' '},
		{' ',' ',' '},
	};

	Scanner scan;
	int row,column;

	public static void main(String[] args){

		Tic_tac_toe tic=new Tic_tac_toe();
		char done;
		System.out.println("This is the game of Tic tac toe");
		System.out.println("You will be playing against the computer.");
		done=' ';
		do
		{
			tic.display();
			tic.player();
			done=tic.check();

			if(done!=' ')
				break;
			tic.computer();	

			done=tic.check();
		}
		while(done==' ');
		if(done=='X')
			System.out.println("Player won");	
		else
			System.out.println("You lose");

		tic.display();	
	}
	//{
		//System.out.println("Block");
			//int i,j;
			//for(i=0;i<3;i++){
				//for(j=0;j<3;j++){
					//matrix[i][j]=' ';
				//}
			//}
	//}
	public void display(){
		int t;
		for(t=0;t<3;t++){
			System.out.print(matrix[t][0]+" | "+matrix[t][1]+"| "+matrix[t][2]);
			if(t!=2){
				System.out.println();
				System.out.println("--|--|--");
			}
		}
		System.out.println();
	}
	public void player(){
		
		scan=new Scanner(System.in);
		System.out.println("Enter row and column");
		row=Integer.parseInt(scan.nextLine());
		column=Integer.parseInt(scan.nextLine());
		row--;
		column--;
		if(matrix[row][column]!=' ')
		{
			System.out.println("Invalid move, try again.");
			player();
		}
		else
		{
			matrix[row][column]='X';
		}
	}
	public void computer(){
		int i=0,j=0;
		for(i=0;i<3;i++){
			for(j=0;j<3;j++){
				if(matrix[i][j]==' ')
					break;
			}
			if(matrix[i][j]==' ')
				break;
		}
		if((i*j)==9){
			System.out.println("Draw");
			System.exit(0);
		}
		else
			matrix[i][j]='0';
	}
	public char check(){
		int i;
		for(i=0;i<3;i++){
			if(matrix[i][0]==matrix[i][1] && matrix[i][0]==matrix[i][2])
				return matrix[i][0];
		}
		for(i=0;i<3;i++){
			if(matrix[0][i]==matrix[1][i] && matrix[0][i]==matrix[2][i])
				return matrix[0][i];
		}
		for(i=0;i<3;i++){
			if(matrix[0][0]==matrix[1][1] && matrix[1][1]==matrix[2][2])
				return matrix[0][0];
		}
		for(i=0;i<3;i++){
			if(matrix[0][2]==matrix[1][1] && matrix[1][1]==matrix[2][0])
				return matrix[0][2];
		}
		return ' ';
	}
}