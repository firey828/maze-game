package com.company.stages;

import com.company.Position;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;

import java.util.ArrayList;

public class Stage6 implements Stage {
    private boolean[][] _maze;
    private Position _start;
    private Position _end;

    private ArrayList<Position> _avi;

    private Player _levelSixPlayer;
    private Minotaur _levelSixMinotaur;
    private Rat _levelSixRat;
    private Zombie _levelSixZombie;

    private Item _levelSixKey;
    private Item _levelSixMap;
    private Item _levelSixSword;
    private Item _levelSixTorch;

    private static final int PLAYER_START_ROW = 0;
    private static final int PLAYER_START_COL = 10;
    private static final int PLAYER_END_ROW = 20;
    private static final int PLAYER_END_COL = 36;

    private static final int MINOTAUR_START_ROW = 7;
    private static final int MINOTAUR_START_COL = 6;

    private static final int RAT_START_ROW = 1;
    private static final int RAT_START_COL = 1;

    private static final int ZOMBIE_START_ROW = 1;
    private static final int ZOMBIE_START_COL = 4;

    public Stage6() {
        _maze = new boolean[][] {
                {true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, true, true, true, true, true, true, true, true, true, false, false, false, false, false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, true},
                {true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, true, false, true, false, true, false, true, false, true, true, true, true, true, true, true, true, true, false, false, false, false, false, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true},
                {true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, true, false, true, false, true, false, true, false, false, false, false, false, false, false, true, true, true, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, true, false, true, false, true},
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, false, true, false, true, true, true, true, true, true, true, false, true, true, true, false, false, false, false, false, true, false, true, true, true, false, true, true, true, false, true, false, true, false, true},
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, true, false, true, false, false, false, false, false, true, false, false, false, true, true, true, false, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, true},
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, false, false, false, false, false, true, false, true, true, true, true, true, false, false, false, false, false, true, false, true, false, true, true, true, true, true, true, true, false, true, false, true},
                {true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, true, true, true, true, true, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, true, false, true},
                {true, false, true, true, true, false, true, false, false, false, false, false, false, false, true, true, true, true, true, false, true, true, true, false, false, false, false, false, true, false, true, true, true, true, true, false, false, false, false, false, true, false, true, false, true, false, false, false, false, false, false, false, true, false, true},
                {true, false, false, false, true, false, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, true, false, true},
                {true, true, true, true, true, false, true, false, true, false, true, true, true, false, true, true, true, true, true, true, true, false, true, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, false, false, false, false, false, false, false, true, false, true},
                {true, true, true, false, false, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, true},
                {true, true, true, false, true, false, true, true, true, true, true, false, true, false, false, false, false, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, true, true, true, true, true, true, true, true, true, false, true},
                {true, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, true},
                {true, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, true, false, true},
                {true, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true},
                {true, true, true, true, true, true, true, true, true, true, true, false, true, false, false, false, false, false, true, true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
                {true, true, true, true, true, true, true, true, true, false, false, false, true, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, true},
                {true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, false, true, false, true, true, true, true, true, false, true, false, true},
                {true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, true, true, true, false, false, false, true, true, true, true, true, false, false, false, true},
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
        };
        StageMethods _sm = new StageMethods();
        _start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
        _end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
        _avi = _sm.getAvailablePositions(_maze);
        _levelSixPlayer = new Player(_start, _end);
        _levelSixMinotaur = new Minotaur(_sm.rr(_avi));
        _levelSixRat = new Rat(_sm.rr(_avi));
        _levelSixZombie = new Zombie(_sm.rr(_avi));
        _levelSixKey = new Key(_sm.rr(_avi));
        _levelSixMap = new Map(_sm.rr(_avi));
        _levelSixSword = new Sword(_sm.rr(_avi));
        _levelSixTorch = new Torch(_sm.rr(_avi));
    }

    public Position getStart() {
        return _start;
    }

    public Position getEnd() {
        return _end;
    }

    public boolean playerIsAtEnd() {
        return _levelSixPlayer.amIAt(_end);
    }

    public boolean[][] getMaze() {
        return _maze;
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

    public Player getMyPlayer() {
        return _levelSixPlayer;
    }

    public Minotaur getMyMinotaur() {
        return _levelSixMinotaur;
    }

    public Rat getMyRat() {
        return _levelSixRat;
    }

    public Zombie getMyZombie() { return _levelSixZombie; }

    public Key getMyKey() { return (Key) _levelSixKey; }

    public Map getMyMap() { return (Map) _levelSixMap; }

    public Sword getMySword() { return (Sword) _levelSixSword; }

    public Torch getMyTorch() { return (Torch) _levelSixTorch; }

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

    public void setPlayerIsEnded(boolean b) {

    }
}