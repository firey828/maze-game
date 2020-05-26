package com.company.items;

import com.company.Position;

public interface Item {

    // ======== SETTERS ========
    public void setPosition(Position p);

    // ======== GETTERS ========
    public int getRow();
    public int getCol();
    public Position getPosition();

}
