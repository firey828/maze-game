package com.company.items;

import com.company.Position;

public interface Item {

    // setters
    public void setPosition(Position p);

    // getters
    public int getRow();
    public int getCol();
    public Position getPosition();

}
