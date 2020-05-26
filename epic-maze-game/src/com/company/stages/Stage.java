package com.company.stages;

import com.company.Position;
import com.company.entities.*;
import com.company.items.*;

public interface Stage {
    public Position getStart();
    public Position getEnd();
    public boolean[][] getMaze();
    public boolean isWall(int r, int c);
    public boolean isWall(Position p);
    public Player getMyPlayer();
    public boolean playerIsAtEnd();

    public Minotaur getMyMinotaur();
    public Rat getMyRat();
    public Zombie getMyZombie();

    public Key getMyKey();
    public Map getMyMap();
    public Sword getMySword();
    public Torch getMyTorch();

    public boolean isInBounds(Position p);
}
