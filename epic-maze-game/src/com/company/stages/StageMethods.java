package com.company.stages;

import com.company.Position;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StageMethods {

    // ======== CONSTRUCTORS ========
    public StageMethods() {

    }

    /*
     * Returns an ArrayList of all Positions corresponding to elements on the board that
     * do not contain walls.
     */
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

    /*
     * Returns a randomly-selected Position contained within the provided list of Positions.
     */
    public Position rr(ArrayList<Position> p) {
        return p.get((int)(Math.random() * p.size()));
    }
}