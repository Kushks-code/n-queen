/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void queensc2d(boolean board[][],int tpc,int tc,int row ,int col,String ans)
    {
        if(tpc==tc)
        {
            System.out.println(ans);
            return;
        }
        
        if(col==board[1].length)
        {
            queensc2d(board,tpc,tc,row+1,0,ans);
            return;
        }
        
        if(row==board.length)
        {
            return;
        }
        
        
        
        board[row][col]=true;
        queensc2d(board,tpc+1,tc,row,col+1,ans+"queen"+":B:"+row+":"+col+"\t");
        board[row][col]=false;
        queensc2d(board,tpc,tc,row,col+1,ans);
        board[row][col]=false;
        
    }
    
      public static void queensc2dkill(boolean board[][],int tpc,int tc,int row ,int col,String ans)
    {
        if(tpc==tc)
        {
            System.out.println(ans);
            return;
        }
        
        if(col==board[1].length)
        {
            queensc2dkill(board,tpc,tc,row+1,0,ans);
            return;
        }
        
        if(row==board.length)
        {
            return;
        }
        
        
        if(isitsafe(board,row,col))
        {
        board[row][col]=true;
        queensc2dkill(board,tpc+1,tc,row,col+1,ans+"queen"+":B:"+row+":"+col+"\t");
        board[row][col]=false;
        }
        queensc2dkill(board,tpc,tc,row,col+1,ans);
        board[row][col]=false;
        
    }
    
    public static boolean isitsafe(boolean board[][],int row, int col)
    {
        int r=row-1;
        int c=col;
        
        while(r>=0)
        {
            if(board[r][c]==true)
            return false;
            --r;
        }
        
        r=row;
        c=col-1;
        
        while(c>=0)
        {
            if(board[r][c]==true)
            return false;
            --c;
            
        }
        
        c=col-1;r=row-1;
        
        while(r>=0&&c>=0)
        {
            if(board[r][c])
            return false;
            
            r--;
            c--;
        }
        
        r=row-1;
        c=col+1;
         while(r>=0&&c<board[0].length)
        {
            if(board[r][c])
            return false;
            
            r--;
            c++;
        }
        return true;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	//	queensc2d(new boolean[2][2],0,2,0,0," ");
		queensc2dkill(new boolean[3][4],0,3,0,0," ");
	}
}
