package com.company.stages;

import com.company.Position;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;

import java.util.ArrayList;

public class TestStage implements Stage {
    // ======== INSTANCE VARIABLES ========
    private boolean[][] _maze;
    private Position _start;
    private Position _end;
    private Player _levelOnePlayer;
    private Minotaur _levelOneMinotaur;
    private Rat _levelOneRat;
    private Zombie _levelOneZombie;
    private Item _levelOneKey;
    private Item _levelOneMap;
    private Item _levelOneSword;
    private Item _levelOneTorch;

    // ======== CONSTANTS ========
    private static final int PLAYER_START_ROW = 0;
    private static final int PLAYER_START_COL = 8;
    private static final int PLAYER_END_ROW = 9;
    private static final int PLAYER_END_COL = 1;
    private static final int MINOTAUR_START_ROW = 7;
    private static final int MINOTAUR_START_COL = 6;
    private static final int RAT_START_ROW = 1;
    private static final int RAT_START_COL = 1;
    private static final int ZOMBIE_START_ROW = 1;
    private static final int ZOMBIE_START_COL = 4;

    // ======== GETTERS ========
    public Position getStart() {
        return _start;
    }
    public Position getEnd() {
        return _end;
    }
    public Player getMyPlayer() {
        return _levelOnePlayer;
    }
    public Minotaur getMyMinotaur() {
        return _levelOneMinotaur;
    }
    public Rat getMyRat() {
        return _levelOneRat;
    }
    public boolean[][] getMaze() {
        return _maze;
    }
    public Zombie getMyZombie() { return _levelOneZombie; }
    public Key getMyKey() { return (Key) _levelOneKey; }
    public Map getMyMap() { return (Map) _levelOneMap; }
    public Sword getMySword() { return (Sword) _levelOneSword; }
    public Torch getMyTorch() { return (Torch) _levelOneTorch; }

    // ======== SETTERS ========
    public void setPlayerIsEnded(boolean b) {

    }
    // ======== CONSTRUCTORS ========
    public TestStage() {
        _maze = new boolean[][] {
                {true,  true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
                {true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
                {true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
                {true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
                {true,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
                {true,  false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
                {true,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
                {true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
                {true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true},
                {true, 	false, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true}
        };
        _start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
        _end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
        _levelOnePlayer = new Player(_start, _end);
        _levelOneMinotaur = new Minotaur(new Position(MINOTAUR_START_ROW, MINOTAUR_START_COL));
        _levelOneRat = new Rat(new Position(RAT_START_ROW, RAT_START_COL));
        _levelOneZombie = new Zombie(new Position(ZOMBIE_START_ROW, ZOMBIE_START_COL));
        _levelOneKey = new Key(new Position(2, 2));
        _levelOneMap = new Map(new Position(3, 3));
        _levelOneSword = new Sword(new Position(4, 4));
        _levelOneTorch = new Torch(new Position(5, 5));
    }

    /*
     * Returns the status of the in-bounds square located at _maze[r][c]. isWall(Position) implements this same
     * functionality and more, so it would be more efficient to simply use that. However, nobody said this was
     * an efficient program, and I never said I was an efficient programmer, so here we all are.
     */
    public boolean isWall(int r, int c) {
        return _maze[r][c];
    }

    /*
     * Returns true if a call of amIAt() from this Stage's Player returns true; false otherwise
     */
    public boolean playerIsAtEnd() {
        return _levelOnePlayer.amIAt(_end);
    }

    /*
     * Returns the status of the presumably in-bounds Position p. (true if it is a wall, false otherwise.)
     * If p is NOT in bounds, we will just say it's a wall (after all, for all practical purposes except
     * those of the game's graphics, it is.)
     */
    public boolean isWall(Position p) {
        if (isInBounds(p)) {
            return _maze[p.getRow()][p.getCol()];
        } else {
            return true;
        }
    }

    /*
     * Exactly what's written on the tin. Returns true if the Position p is wtihin the bounds of our current
     * _maze, false otherwise.
     */
    public boolean isInBounds(Position p) {
        int r = p.getRow();
        int c = p.getCol();
        if (r > _maze.length - 1) {
            return false;
        } else if (r < 0) {
            return false;
        } else if (c > _maze[0].length - 1) {
            return false;
        } else if (c < 0) {
            return false;
        } else {
            return true;
        }
    }
}