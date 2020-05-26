package com.company.stages;

import com.company.Position;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;

import java.util.ArrayList;

public class Stage3 implements Stage {
    // ======== INSTANCE VARIABLES ========
    private boolean[][] _maze;
    private Position _start;
    private Position _end;
    private ArrayList<Position> _avi;
    private Player _levelThreePlayer;
    private Minotaur _levelThreeMinotaur;
    private Rat _levelThreeRat;
    private Zombie _levelThreeZombie;
    private Item _levelThreeKey;
    private Item _levelThreeMap;
    private Item _levelThreeSword;
    private Item _levelThreeTorch;

    // ======== CONSTANTS ========
    private static final int PLAYER_START_ROW = 0;
    private static final int PLAYER_START_COL = 1;
    private static final int PLAYER_END_ROW = 3;
    private static final int PLAYER_END_COL = 0;
    private static final int MINOTAUR_START_ROW = 7;
    private static final int MINOTAUR_START_COL = 6;
    private static final int RAT_START_ROW = 1;
    private static final int RAT_START_COL = 1;
    private static final int ZOMBIE_START_ROW = 1;
    private static final int ZOMBIE_START_COL = 4;

    // ======== GETTERS ========
    public boolean[][] getMaze() {
        return _maze;
    }
    public Position getStart() {
        return _start;
    }
    public Position getEnd() {
        return _end;
    }
    public Player getMyPlayer() {
        return _levelThreePlayer;
    }
    public Minotaur getMyMinotaur() {
        return _levelThreeMinotaur;
    }
    public Rat getMyRat() {
        return _levelThreeRat;
    }
    public Zombie getMyZombie() { return _levelThreeZombie; }
    public Key getMyKey() { return (Key) _levelThreeKey; }
    public Map getMyMap() { return (Map) _levelThreeMap; }
    public Sword getMySword() { return (Sword) _levelThreeSword; }
    public Torch getMyTorch() { return (Torch) _levelThreeTorch; }

    // ======== SETTERS ========
    public void setPlayerIsEnded(boolean b) {

    }

    // ======== CONSTRUCTORS ========
    public Stage3() {
        _maze = new boolean[][] {
                {true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
                {false, false, true, false, false, false, true, true, true, false, true, true, true, true, true, false, true, true, true, false, false, false, true, false, true},
                {true, false, true, false, true, false, true, true, true, true, false, true, false, true, false, true, true, true, true, false, true, false, true, false, true},
                {true, false, true, false, false, false, true, true, true, true, true, false, true, false, true, true, true, true, true, false, false, false, true, false, true},
                {true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
                {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}
        };
        StageMethods _sm = new StageMethods();
        _start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
        _end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
        _avi = _sm.getAvailablePositions(_maze);
        _levelThreePlayer = new Player(_start, _end);
        _levelThreeMinotaur = new Minotaur(_sm.rr(_avi));
        _levelThreeRat = new Rat(_sm.rr(_avi));
        _levelThreeZombie = new Zombie(_sm.rr(_avi));
        _levelThreeKey = new Key(_sm.rr(_avi));
        _levelThreeMap = new Map(_sm.rr(_avi));
        _levelThreeSword = new Sword(_sm.rr(_avi));
        _levelThreeTorch = new Torch(_sm.rr(_avi));
    }

    public boolean playerIsAtEnd() {
        return _levelThreePlayer.amIAt(_end);
    }

    public boolean isWall(int r, int c) {
        return _maze[r][c];
    }

    public boolean isWall(Position p) {
        if (isInBounds(p)) {
            return _maze[p.getRow()][p.getCol()];
        } else {
            return true;
        }
    }

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