package com.example.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int player_count  = 0, cross_count = 0, circle_count = 0, view_id = 0, max_view_id = 2131165300, index = 0;
    private static boolean game_end = false;
    private static int array[] = new int[9];

    private boolean check(View v) {
        TextView score_0 = (TextView) findViewById(R.id.score_1);
        TextView score_1 = (TextView) findViewById(R.id.score_2);


        for (int i = 0, j = 1, k = 2; k < 9; i += 3, j += 3, k += 3) {

            if (array[i] == 1 && array[j] == 1 && array[k] == 1) {
                score_1.setText(R.string.score_won);
                score_0.setText(R.string.score_loss);
                return true;
            }
            if (array[i] == 0 && array[j] == 0 && array[k] == 0) {
                score_0.setText(R.string.score_won);
                score_1.setText(R.string.score_loss);
                return true;
            }
        }

        for (int i = 0, j = 3, k = 6; k < 9; i++, j++, k++) {

            if (array[i] == 1 && array[j] == 1 && array[k] == 1) {
                score_1.setText(R.string.score_won);
                score_0.setText(R.string.score_loss);
                return true;
            }
            if (array[i] == 0 && array[j] == 0 && array[k] == 0) {
                score_0.setText(R.string.score_won);
                score_1.setText(R.string.score_loss);
                return true;
            }
        }

        for (int i = 0, j = 4, k = 8; k >= 6; i += 2, k -= 2){
            if (array[i] == 1 && array[j] == 1 && array[k] == 1) {
                score_1.setText(R.string.score_won);
                score_0.setText(R.string.score_loss);
                return true;
            }
            if (array[i] == 0 && array[j] == 0 && array[k] == 0) {
                score_0.setText(R.string.score_won);
                score_1.setText(R.string.score_loss);
                return true;
            }
        }
        return  false;
    }

    public void drop(View view){

        ImageView i = (ImageView)view;
        view_id = i.getId() ;

        if(player_count == 0){
            for (int a = 0; a < 9 ; a++)
                array[a] = -1;
        }

        if (i.isDirty() == false && player_count < 9 && game_end == false) {

            if (player_count % 2 == 0) {
                i.setImageResource(R.drawable.circle);
                circle_count++;
                index = -(max_view_id - view_id - 8);
                array[index] = 0;
            }
            else {
                i.setImageResource(R.drawable.cross);
                cross_count++;
                index = -(max_view_id - view_id - 8);
                array[index] = 1;
            }
            player_count++;
            game_end = check(view);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
