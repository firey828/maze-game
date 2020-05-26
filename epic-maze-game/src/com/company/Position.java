package com.company;

import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;

public class Position {

    private int _row;
    private int _col;

    public int getRow() { return _row; }
    public int getCol() { return _col; }

    public Position(int r, int c) {
        _row = r;
        _col = c;
    }

    public Position oneRight() {
        return new Position(_row, _col + 1);
    }

    public Position oneLeft() {
        return new Position(_row, _col - 1);
    }

    public Position oneUp() {
        return new Position(_row - 1, _col);
    }

    public Position oneDown() {
        return new Position(_row + 1, _col);
    }

    public String toString() {
        return "row: " + _row + " col: " + _col;
    }

    /*public boolean samePosAs(Position theOtherOne) {
        return this.getRow() == theOtherOne.getRow() && this.getCol() == theOtherOne.getCol();
    }*/

    public boolean samePosAs(Position theOtherOne) {
        boolean samePos = false;

        if((this.getRow() == theOtherOne.getRow())
                && (this.getCol() == theOtherOne.getCol())){
            samePos = true;
        }

        return samePos;
    }
}
