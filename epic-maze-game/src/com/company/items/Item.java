package com.company.items;

import com.company.Position;

public interface Item {

    // ======== SETTERS ========
    public void setPosition(Position p);

    // getters
    public int getRow();
    public int getCol();
    public Position getPosition();

}
