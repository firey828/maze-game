package com.company.items;

import com.company.Position;

public interface Item {

    // ======== GETTERS ========
    public int getRow();
    public int getCol();
    public Position getPosition();

    // ======== SETTERS ========
    public void setPosition(Position p);
}
