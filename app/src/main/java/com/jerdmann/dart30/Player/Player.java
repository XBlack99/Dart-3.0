package com.jerdmann.dart30.Player;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Player {
    String name;
    int points;
    List<Integer> Thrown=new ArrayList<>();
    int personalTurn=-1;
    int roundsChecked;
    public Player(String name, int points,int justChecked) {
        this.name = name;
        this.points = points;
        this.roundsChecked=justChecked;
    }

}
