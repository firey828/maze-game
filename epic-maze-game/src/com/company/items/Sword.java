package com.company.items;

import com.company.Position;

public class Sword implements Item {

    // instance variables
    private Position _curPos;

    // public Position getPosition() { return _curPos;	}

    // constructors
    public Sword(Position swordSpawnPoint) {
        _curPos = swordSpawnPoint;
    }

    // setters
    public void setPosition(Position p) {
        _curPos = p;
    }

    // getters
    public int getRow() {
        return _curPos.getRow();
    }
    public int getCol() {
        return _curPos.getCol();
    }
    public Position getPosition() {
        return _curPos;
    }
}
