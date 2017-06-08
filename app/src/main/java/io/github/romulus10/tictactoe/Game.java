package io.github.romulus10.tictactoe;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    private static boolean current_player;
    private static Vibrator vibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        current_player = true;
        vibe = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    public void setText(View view) {
        Button button = (Button) view;
        if (button.getText().toString().equals("")) {
            if (current_player) {
                button.setText("X");
            } else {
                button.setText("O");
            }
            current_player = !current_player;
        } else {
            Context context = getApplicationContext();
            CharSequence text = "That space is already taken.";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();
            vibe.vibrate(100);
        }
        this.checkForWin(view);
    }

    public void checkForWin(View view) {
        boolean win = false;
        char winner = 'Z';
        char[][] board = new char[3][3];
        try {
            board[0][0] = ((Button) findViewById(R.id.button2)).getText().toString().toCharArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.d("TIC TAC TOE", "ArrayIndexOutOfBounds");
        }
        try {
            board[0][1] = ((Button) findViewById(R.id.button3)).getText().toString().toCharArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.d("TIC TAC TOE", "ArrayIndexOutOfBounds");
        }
        try {
            board[0][2] = ((Button) findViewById(R.id.button4)).getText().toString().toCharArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.d("TIC TAC TOE", "ArrayIndexOutOfBounds");
        }
        try {
            board[1][0] = ((Button) findViewById(R.id.button5)).getText().toString().toCharArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.d("TIC TAC TOE", "ArrayIndexOutOfBounds");
        }
        try {
            board[1][1] = ((Button) findViewById(R.id.button6)).getText().toString().toCharArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.d("TIC TAC TOE", "ArrayIndexOutOfBounds");
        }
        try {
            board[1][2] = ((Button) findViewById(R.id.button7)).getText().toString().toCharArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.d("TIC TAC TOE", "ArrayIndexOutOfBounds");
        }
        try {
            board[2][0] = ((Button) findViewById(R.id.button8)).getText().toString().toCharArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.d("TIC TAC TOE", "ArrayIndexOutOfBounds");
        }
        try {
            board[2][1] = ((Button) findViewById(R.id.button9)).getText().toString().toCharArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.d("TIC TAC TOE", "ArrayIndexOutOfBounds");
        }
        try {
            board[2][2] = ((Button) findViewById(R.id.button10)).getText().toString().toCharArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.d("TIC TAC TOE", "ArrayIndexOutOfBounds");
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {
                win = true;
                winner = 'X';
            } else if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {
                win = true;
                winner = 'O';
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') {
                win = true;
                winner = 'X';
            } else if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O') {
                win = true;
                winner = 'O';
            }
        }
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            win = true;
            winner = 'X';
        } else if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
            win = true;
            winner = 'O';
        }

        if (win) {
            Context context = getApplicationContext();
            CharSequence text = winner + " wins!";
            int duration = Toast.LENGTH_LONG;
            Toast.makeText(context, text, duration).show();
        }
    }
}
