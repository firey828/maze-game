package com.company.items;

import com.company.Position;

public class Map implements Item {

    // ======== INSTANCE VARIABLES ========
    private Position _curPos;

    // ======== GETTERS ========
    public int getRow() {
        return _curPos.getRow();
    }
    public int getCol() {
        return _curPos.getCol();
    }
    public Position getPosition() {
        return _curPos;
    }

    // ======== SETTERS ========
    public void setPosition(Position p) {
        _curPos = p;
    }

    // ======== CONSTRUCTORS ========
    public Map(Position mapSpawnPoint) {
        _curPos = mapSpawnPoint;
    }
}