package com.company.stages;

import com.company.Position;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StageMethods {
    public StageMethods() {

    }

    public ArrayList<Position> getAvailablePositions(boolean[][] board) {
        ArrayList<Position> n = new ArrayList <Position>(0);
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (!board[x][y]) {
                    n.add(new Position(x, y));
                }
            }
        }
        return n;
    }

    public Position rr(ArrayList<Position> p) {
        return p.get((int)(Math.random() * p.size()));
    }
}
