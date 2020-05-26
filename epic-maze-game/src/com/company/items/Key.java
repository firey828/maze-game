package com.company.items;

import com.company.Position;

public class Key implements Item {

    // ======== INSTANCE VARIABLES ========
    private Position _curPos;

    // ======== CONSTRUCTORS ========
    public Key(Position keySpawnPoint) {
        _curPos = keySpawnPoint;
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
