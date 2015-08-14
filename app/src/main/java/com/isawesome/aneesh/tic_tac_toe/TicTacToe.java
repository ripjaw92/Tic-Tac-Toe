package com.isawesome.aneesh.tic_tac_toe;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TicTacToe extends ActionBarActivity {
    int turn = 1;
    double [][]board =new double[][]
    {{0,0,0},
     {0,0,0},
     {0,0,0}};
    double x = 0;
    double y = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tic_tac_toe, menu);
        return true;
    }
    public void onClick(View view){
    Button button =(Button) findViewById(view.getId());
        TextView TV = (TextView) findViewById(R.id.T2);
    if(button.getText()==""){

        if(turn%2==1) {
            button.setText("X");
            turn++;
            x = ((Integer.parseInt(view.getResources().getResourceName(view.getId()).substring( view.getResources().getResourceName(view.getId()).length()-1 )) - 1) / 3);
            Math.floor(x);
            y = (Integer.parseInt(view.getResources().getResourceName(view.getId()).substring( view.getResources().getResourceName(view.getId()).length()-1 )) - 1)%3;
            board[(int)x][(int)y]=1;
            if(rowCheck(board, 1)){
                TV.setText("Player X has won!");
            }
            else if(turn==10){TV.setText("It's a tie!");}
        }
        else {
            button.setText("O");
            turn++;
            x = ((Integer.parseInt(view.getResources().getResourceName(view.getId()).substring( view.getResources().getResourceName(view.getId()).length()-1 )) - 1) / 3);
            Math.floor(x);
            y = (Integer.parseInt(view.getResources().getResourceName(view.getId()).substring( view.getResources().getResourceName(view.getId()).length()-1 )) - 1)%3;
            board[(int)x][(int)y]=2;
           if(rowCheck(board, 2)){
                TV.setText("Player O has won!");
            }
        }
    }
    else{

    }

    }
    public void reset(View view){
        turn =1;
        for (int i = 0; i<3;i++){
            for (int j = 0; j<3;j++){
                board[i][j]=0;
            }    
        }
        x=0;
        y=0;
        TextView TV=(TextView) findViewById(R.id.T2);
        Button B1=(Button) findViewById(R.id.B1);
        Button B2=(Button) findViewById(R.id.B2);
        Button B3=(Button) findViewById(R.id.B3);
        Button B4=(Button) findViewById(R.id.B4);
        Button B5=(Button) findViewById(R.id.B5);
        Button B6=(Button) findViewById(R.id.B6);
        Button B7=(Button) findViewById(R.id.B7);
        Button B8=(Button) findViewById(R.id.B8);
        Button B9=(Button) findViewById(R.id.B9);
        TV.setText("");
        B1.setText("");
        B2.setText("");
        B3.setText("");
        B4.setText("");
        B5.setText("");
        B6.setText("");
        B7.setText("");
        B8.setText("");
        B9.setText("");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean rowCheck(double[][]board, int check)
    {
        boolean x = false;
        /*
        0,0 0,1 0,2
        1,0 1,1 1,2
        2,0 2,1 2,2
        */
        if(board[1][1]==check&&( (board[0][0]==check&&board[2][2]==check) || (board[0][1]==check&&board[2][1]==check) || (board[2][0]==check&&board[0][2]==check) || (board[1][0]==check&&board[1][2]==check) ) ){
            x = true;
        }
        else if(board[0][0]==check&&( (board[0][1]==check&&board[0][2]==check) || (board[1][0]==check&&board[2][0]==check) ) ){
            x = true;
        }
        else if(board[2][2]==check&&( (board[2][1]==check&&board[2][0]==check) || (board[1][2]==check&&board[0][2]==check) ) ){
            x = true;
        }

        return x;
    }

}
