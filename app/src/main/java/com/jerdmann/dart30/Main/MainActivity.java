package com.jerdmann.dart30.Main;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jerdmann.dart30.Game.Game;
import com.jerdmann.dart30.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int numberOfPlayer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final List<Integer> playerCountList = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            playerCountList.add(i);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner playerCount = findViewById(R.id.spinPlayerCount);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, playerCountList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerCount.setAdapter(arrayAdapter);
        playerCount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                numberOfPlayer = playerCountList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button playerConfirmBtn = findViewById(R.id.btn_playerCount);
        playerConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameIntent = new Intent(getApplicationContext(), Game.class);
                gameIntent.putExtra("com.jerdmann.Main", numberOfPlayer);
                startActivity(gameIntent);

            }
        });
    }
}
