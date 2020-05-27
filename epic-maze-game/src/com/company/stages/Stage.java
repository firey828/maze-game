package com.company.stages;

import com.company.Position;
import com.company.entities.*;
import com.company.items.*;

public interface Stage {

    // ======== GETTERS ========
    public Position getStart();
    public Position getEnd();
    public boolean[][] getMaze();
    public Player getMyPlayer();
    public Minotaur getMyMinotaur();
    public Rat getMyRat();
    public Zombie getMyZombie();
    public Key getMyKey();
    public Map getMyMap();
    public Sword getMySword();
    public Torch getMyTorch();

    /*
     * Returns true if a call of amIAt() from the Stage's Player returns true; false otherwise
     */
    public boolean playerIsAtEnd();

    /*
     * Returns the status of the in-bounds square located at _maze[r][c]. isWall(Position) implements this same
     * functionality and more, so it would be more efficient to simply use that. However, nobody said this was
     * an efficient program, and I never said I was an efficient programmer, so here we all are.
     */
    public boolean isWall(int r, int c);

    /*
     * Returns the status of the presumably in-bounds Position p. (true if it is a wall, false otherwise.)
     * If p is NOT in bounds, we will just say it's a wall (after all, for all practical purposes except
     * those of the game's graphics, it is.)
     */
    public boolean isWall(Position p);

    /*
     * Exactly what's written on the tin. Returns true if the Position p is wtihin the bounds of our current
     * _maze, false otherwise.
     */
    public boolean isInBounds(Position p);
}