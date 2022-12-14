package com.haghpanah.rockpaprescissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    ImageView imgOpponent,imgPlayer , imgRock,imgPaper,imgScissors,btnRestart;
    TextView txtOpponentScore,txtGame,txtPlayerScore;
    int playerScore=0,opponentScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setupView();
        imgOpponent.setVisibility(View.INVISIBLE);
        imgPlayer.setVisibility(View.INVISIBLE);


        View.OnClickListener gameSelectionOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgOpponent.setVisibility(View.VISIBLE);
                imgPlayer.setVisibility(View.VISIBLE);
                int playerSelection = 0;
                switch (view.getId()) {

                    case R.id.imgRock:
                        imgPlayer.setImageResource(R.drawable.rock);
                        playerSelection = 1;
                        break;

                    case R.id.imgPaper:
                        imgPlayer.setImageResource(R.drawable.paper);
                        playerSelection = 2;
                        break;

                    case R.id.imgScissor:
                        imgPlayer.setImageResource(R.drawable.scissors);
                        playerSelection = 3;
                        break;
                }

                Random random = new Random();
                int opponentSelection = random.nextInt(4);
                switch (opponentSelection){
                    case 1:
                        imgOpponent.setImageResource(R.drawable.rock);

                        break;
                    case 2:
                        imgOpponent.setImageResource(R.drawable.paper);

                        break;
                    case 3:
                        imgOpponent.setImageResource(R.drawable.scissors);
                        break;
                }

                switch (CheckWinner(playerSelection,opponentSelection)){
                    case 0: txtGame.setText("تساوی");
                        break;
                    case 1: playerScore++;
                        txtGame.setText("بردی :)");
                        break;
                    case 2:opponentScore++;
                        txtGame.setText("باختی :(");
                        break;
                }

                txtPlayerScore.setText(""+playerScore);
                txtOpponentScore.setText(""+opponentScore);



            }
        };

        imgPaper.setOnClickListener(gameSelectionOnClick);
        imgRock.setOnClickListener(gameSelectionOnClick);
        imgScissors.setOnClickListener(gameSelectionOnClick);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerScore=0;
                opponentScore=0;
                txtPlayerScore.setText("0");
                txtOpponentScore.setText("0");
                imgOpponent.setVisibility(View.INVISIBLE);
                imgPlayer.setVisibility(View.INVISIBLE);
                txtGame.setText("");
            }
        });

    }



    private int CheckWinner (int playerSelection,int opponentSelection){
        if (opponentSelection==playerSelection) return 0;
        switch (playerSelection){
            case 1:{
                if (opponentSelection==2) return 2;
                else if(opponentSelection==3) return 1;
            }
            case 2:{
                if (opponentSelection==1) return 1;
                else if(opponentSelection==3) return 2;
            }
            case 3:{
                if (opponentSelection==1) return 2;
                else if(opponentSelection==2) return 1;
            }
            default:return 0;
        }

    }

    private void setupView (){
        imgOpponent = findViewById(R.id.imgOpponent);
        imgPaper = findViewById(R.id.imgPaper);
        imgRock = findViewById(R.id.imgRock);
        imgPlayer = findViewById(R.id.imgPlayer);
        imgScissors = findViewById(R.id.imgScissor);
        btnRestart = findViewById(R.id.btnRestart);
        txtGame = findViewById(R.id.txtGameSituation);
        txtOpponentScore = findViewById(R.id.txtOpponentScore);
        txtPlayerScore = findViewById(R.id.txtPlayerScore);
    }
}