package com.jerdmann.dart30.Game;

import android.annotation.SuppressLint;
import android.graphics.Color;

import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jerdmann.dart30.Player.Player;

import com.jerdmann.dart30.R;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class Game extends AppCompatActivity {

    private int numberOfPlayer;
    private int[] playerTextFields = {R.id.txtPlayer1, R.id.txtPlayer2, R.id.txtPlayer3, R.id.txtPlayer4, R.id.txtPlayer5,
            R.id.txtPlayer6, R.id.txtPlayer7, R.id.txtPlayer8};
    private int[] pointFields = {R.id.tvPoint1, R.id.tvPoint2, R.id.tvPoint3, R.id.tvPoint4, R.id.tvPoint5, R.id.tvPoint6,
            R.id.tvPoint7, R.id.tvPoint8};
    private List<Player> playerList = new ArrayList<>();
    private int round = 0;
    private int ranking=0;
    private String[] checkOut = {"checked", "1", "2 o. D1", "3 o. 1+D1", "4 o. D2", "5 o. 1+D2",
            "6 o. D3", "7 o. 1+D3", "8 o. D4", "9 o. 1+D4", "10 o. D5", "11 o. 1+D5", "12 o. D6", "13 o. 1+13", "14 o. D7",
            "15 o. 1+D7", "16 o. D8", "17 o. 1+D8", "18 o. D9", "19 o. 1+D8", "20 o. D10", "20+1 o. 1+D10",
            "20+2 o. 11+11 o. D11", "20+3 o. 12+11 o. 1+D11", "20+4 o. 12+12 o. D12", "20+5 o. SB o. D10+5",
            "13+13 o. 14+12 o. D13", "13+14 o. 1+D13", "14+14 o. 15+13 o. D14", "14+15 o. 20+9 o. 5+D12",
            "15+15 o. 16+14 o. D15", "15+16 o. 18+13 o. 17+D7", "16+16 o. 20+12 o. D16", "16+17 o. 20+13 o. D12+9",
            "17+17 o. 20+14 o. D17", "17+18 o. 16+19 o. 7+D14", "18+18 o. 19+17 o. D18", "18+19 o. 17+20 o. 17+D10",
            "13+SB o. 19+19 o. 20+18 o. D19", "14+SB o. 20+19 o. 11+D14", "15+SB o. 20+20 o. D20",
            "16+SB o. 1+D20 o. 3+D19", "17+SB o. 2+D20 o. 6+D18", "18+SB o. 3+D20 o. 11+D16", "19+SB o. 4+D20 o. 10+D17",
            "20+SB o. 5+D20  o. 7+D19", "6+D20 o. 8+D19", "7+D20 o. 15+D16", "8+D20 o. 16+D16", "9+D20 o. 17+D16",
            "10+D20 o. 18+D16 o. BE", "11+D20 o. 19+D16 o. 1+BE", "12+D20 o. 20+D16", "13+D20 o. 3+BE", "14+D20 o. 20+D17 o. 7+BE",
            "15+D20 o. 5+BE", "16+D20 o. 6+BE o. T16+D4", "17+D20 o. 7+BE", "18+D20 o. 8+BE", "19+D20 o. 9+BE",
            "20+D20 o. 10+BE", "T15+D8 o. T7+D20 o. 11+BE", "T10+D16 o. T13+D12 o. 12+BE", "T13+D12 o. T17+D6 o. 13+BE",
            "T16+D8 o. T14+D11 o. 14+BE", "T11+D16 o. T19+D4 o. 15+BE", "T10+D18 o. T18+D6 o. 16+BE",
            "T9 +D20 o. T7+D8 o. 17+BE", "T16+D10 o. T20+D4 o. BE+18", "T19+D6 o. 19+BE", "T18+D8 o. T20+D5 o. 20+BE",
            "T13+D16", "T16+D12 o. T20+D6", "T19+D8", "T14+D16", "T17+D12", "T20+D8 o. T16+D14", "T19+D10", "T18+D12",
            "T19+D11 o. T13+D20", "T20+D10 o. D20+D20", "T19+D12 o. T15+D18", "D8+D16 o. T14+D20 o. BE+17+D20", "T17+D16",
            "T20+D12", "T15+D20 o. T19+D14", "T18+D16", "T17+D18", "T20+D14", "T19+D16", "T20+D15 o. T18+D18",
            "T17+D20 o. SB+T16+D9", "T20+D16 o. SB+T17+D8", "T19+D18 o. SB+T18+D7",
            "T18+D20 o. SB+T19+D6", "T19+D19 o. SB+T20+D5", "T20+D18", "T19+D20", "T20+D19", "T19+10+D16 o. T19+6+D18",
            "T20+D20", "T20+9+D16 o. T17+BE", "T20+10+D16 o. T20+6+D18", "T19+6+D20 o. T19+10+D18", "T19+15+T16 o. T18+BE",
            "T20+13+D16", "T20+T10+BE", "T19+T10+D10 o. T19+BE", "T20+16+D16 o. T20+8+D20", "T20+9+D20", "T20+T10+D10 o.T20+BE",
            "T19+14+D20 o. T20+11+D20", "T20+T12+BE", "T19+16+D20", "T19+17+D20", "T20+15+D20 o. T19+18+D20",
            "T29+19+D20 o. T20+16+D20", "T19+20+D20 o. T20+17+D20", "T20+18+D20", "T19+T12+D13", "T20+20+D20",
            "T20+T11+D14 o. T17+T20+D5", "T18+T18+D7", "T19+T16+D9", "T20+T14+D11", "T18+T19+D7 o. T20+T15+D10",
            "T19+T19+D6", "T20+T17+D8", "T18+T14+D16 o. T20+T18+D7", "T19+T16+D12 o. T20+T19+D6", "T20+T20+D5",
            "T19+T14+D16 o. T20+T13+D16", "T20+T16+D12 o. SB+T19+BE", "T20+T19+D8", "T20+T16+D13", "T20+T17+D12 o. SB+T19+BE",
            "T20+T20+D8", "T20+T19+D10", "T20+T18+D12 o. T19+T19+D12", "T20+T13+D20 o. T20+T19+D11", "T20+T20+T10",
            "T20+T19+D12", "T20+T14+D20 o. T19+T19+D14", "T20+T17+D16 o. T19+T18+D16", "T20+T20+D12", "T20+T19+D14",
            "T20+T18+D16 o. T19+T19+D16", "T20+T17+D18 o. T19+T18+D18", "T20+T20+D14 o. T19+T17+D20", "T20+T19+D16",
            "T20+T18+D18 o. T19+T19+D18", "T20+T17+D20 o. T19+T18+D20", "T20+T20+D16", "T20+T19+D18", "T20+T18+D20",
            "T20+T19+D19", "T20+T20+T18", "T20+T19+D20", "T20+T20+D19", "kein Finish", "T20+T20+D20", "T20+T17+BE", "kein Finish",
            "kein Finish", "T20+T18+BE", "kein Finish", "kein Finish", "T20+T19+BE", "kein Finish", "kein Finish", "T20+T20+BE"};

    String[] rankingDisplay={"winner","2nd","3rd","4th","th"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            numberOfPlayer = savedInstanceState.getInt("numberOfPlayer");
            playerTextFields = savedInstanceState.getIntArray("playerTextFields");
            pointFields = savedInstanceState.getIntArray("pointFields");
            round = savedInstanceState.getInt("round");
            checkOut = savedInstanceState.getStringArray("checkOut");
            ranking=savedInstanceState.getInt("ranking");
            rankingDisplay=savedInstanceState.getStringArray("rankingDisplay");
            for (int i = 0; i < numberOfPlayer; i++) {
                Player newPlayer = new Player(savedInstanceState.getStringArrayList("playerListName").get(i),
                        savedInstanceState.getIntegerArrayList("playerListPoints").get(i),
                        savedInstanceState.getIntegerArrayList("playerListThrown"+i),
                        savedInstanceState.getIntegerArrayList("playerListTurn").get(i),
                        Objects.requireNonNull(savedInstanceState.getIntegerArrayList("playerListJustChecked")).get(i));
                playerList.add(newPlayer);
            }
        }
        setContentView(R.layout.activity_game);
        numberOfPlayer = (int) Objects.requireNonNull(getIntent().getExtras()).get("com.jerdmann.Main");
        for (int i = 7; i >= numberOfPlayer; i--) {
            findViewById(playerTextFields[i]).setVisibility(View.GONE);
            findViewById(pointFields[i]).setVisibility(View.GONE);
        }
        Button btnWinCondition = findViewById(R.id.btnWinCondition);
        final EditText txtWinCondition = findViewById(R.id.txtWinCondition);
        highlightPlayer();
        btnWinCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtWinCondition.getText().toString().equals("")) {
                    startGame(txtWinCondition);
                    txtWinCondition.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter win Conditon", Toast.LENGTH_LONG).show();
                }
            }
        });
        Button btnThrown = findViewById(R.id.btnThrown);
        final EditText txtThrown = findViewById(R.id.txtThrown);
        btnThrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtThrown.getText().toString().equals("")) {
                    game();
                    txtThrown.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter your points", Toast.LENGTH_LONG).show();
                }
            }
        });
        Button btnGoBack = findViewById(R.id.btn_back);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (round > 0) {
                    back();
                }
                System.out.println(ranking);
            }
        });
    }

    public void startGame(EditText txtWinCondition) {
        for (int i = 0; i < numberOfPlayer; i++) {
            EditText playerName = findViewById(playerTextFields[i]);
            playerList.add(new Player(playerName.getText().toString(), Integer.parseInt(txtWinCondition.getText().toString()),0));
            TextView pointDisplay = findViewById(pointFields[i]);
            pointDisplay.setText(txtWinCondition.getText().toString());
        }
    }

    @SuppressLint("SetTextI18n")
    public void game() {
        EditText txtThrown = findViewById(R.id.txtThrown);
        TextView tvPointField=findViewById(pointFields[0]);
        int thrown = Integer.parseInt(txtThrown.getText().toString());
        if(!tvPointField.getText().toString().equals("")) {
            if (thrown < 181) {
                if (playerList.get(round % numberOfPlayer).getPoints() - thrown >= 0) {
                    playerList.get(round % numberOfPlayer).getThrown().add(thrown);
                    playerList.get(round % numberOfPlayer).setPoints(playerList.get(round % numberOfPlayer).getPoints() - thrown);
                    playerList.get(round % numberOfPlayer).
                            setPersonalTurn(playerList.get(round % numberOfPlayer).getPersonalTurn() + 1);
                    TextView pointDisplay = findViewById(pointFields[round % numberOfPlayer]);
                    if (playerList.get(round % numberOfPlayer).getPoints() == 0 && ranking < 3) {
                        pointDisplay.setText(rankingDisplay[ranking]);
                        ranking++;
                    } else {
                        if (playerList.get(round % numberOfPlayer).getPoints() == 0) {
                            pointDisplay.setText((ranking + 1) + rankingDisplay[4]);
                            ranking++;
                        } else {
                            pointDisplay.setText("" + playerList.get(round % numberOfPlayer).getPoints());
                        }
                    }
                    boolean playerHasZero = true;
                    int i = 0;
                    do {
                        if (!(playerList.get((round + 1) % numberOfPlayer).getPoints() == 0)) {
                            playerList.get((round + 1) % numberOfPlayer).setRoundsChecked(playerList.get((round + 1) % numberOfPlayer).getRoundsChecked()+1);
                            playerHasZero = false;
                        } else {
                            round++;
                        }
                        i++;
                    } while (playerHasZero && i < numberOfPlayer);
                    round++;
                    highlightPlayer();
                } else {
                    round++;
                    highlightPlayer();
                    Toast.makeText(getApplicationContext(), "no Score", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "The Score was more than 180", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(getApplicationContext(), "Please enter win Conditon", Toast.LENGTH_LONG).show();
        }

    }

    @SuppressLint("SetTextI18n")
    public void back() {
        round--;
        if(playerList.get(round % numberOfPlayer).getPersonalTurn()!=-1) {
            playerList.get(round % numberOfPlayer).setPoints(playerList.get(round % numberOfPlayer).getPoints()
                    + playerList.get(round % numberOfPlayer).getThrown().get(playerList.get(round % numberOfPlayer).getPersonalTurn()));
            playerList.get(round % numberOfPlayer).setPersonalTurn(playerList.get(round % numberOfPlayer).getPersonalTurn() - 1);
            TextView pointDisplay = findViewById(pointFields[round % numberOfPlayer]);
            pointDisplay.setText("" + playerList.get(round % numberOfPlayer).getPoints());
        }
        highlightPlayer();
        if(playerList.get(round % numberOfPlayer).getRoundsChecked()==1){
            playerList.get(round % numberOfPlayer).setRoundsChecked(0);
            ranking--;
        }
    }

    @SuppressLint("SetTextI18n")
    public void highlightPlayer() {

        for (int i = 0; i < numberOfPlayer; i++) {
            TextView pointDisplay = findViewById(pointFields[i]);
            TextView tvCheckOut = findViewById(R.id.tvCheckOut);
            if (i == round % numberOfPlayer) {
                pointDisplay.setBackgroundColor(Color.rgb(175, 237, 192));
                if (!pointDisplay.getText().equals("") && playerList.get(i).getPoints() <= 170) {
                    tvCheckOut.setText("" + checkOut[playerList.get(i).getPoints()]);
                }
            } else {
                pointDisplay.setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numberOfPlayer", numberOfPlayer);
        outState.putIntArray("playerTextFields", playerTextFields);
        outState.putIntArray("pointFields", pointFields);
        outState.putInt("round", round);
        outState.putStringArray("checkOut", checkOut);
        outState.putInt("ranking", ranking);
        outState.putStringArray("rankingDisplay", rankingDisplay);
        ArrayList<String> playerListName = new ArrayList<>();
        ArrayList<Integer> playerListPoints = new ArrayList<>();
        ArrayList<Integer> playerListTurn = new ArrayList<>();
        ArrayList<ArrayList<Integer>> playerListThrown = new ArrayList<>();
        ArrayList<Integer> playerRoundsChecked=new ArrayList<>();
        for (Player player : playerList) {
            playerListName.add(player.getName());
            playerListPoints.add(player.getPoints());
            playerListTurn.add(player.getPersonalTurn());
            playerRoundsChecked.add(player.getRoundsChecked());
            playerListThrown.add((ArrayList<Integer>) player.getThrown());
        }
        outState.putStringArrayList("playerListName", playerListName);
        outState.putIntegerArrayList("playerListPoints", playerListPoints);
        outState.putIntegerArrayList("playerListTurn", playerListTurn);
        outState.putIntegerArrayList("playerRoundsChecked",playerRoundsChecked);
        for (int i = 0; i < playerList.size(); i++) {
            outState.putIntegerArrayList("playerListThrown" + i, playerListThrown.get(i));
        }
    }

}
