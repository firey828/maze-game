package com.company.stages;

import com.company.Position;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;

import java.util.ArrayList;

public class Stage7 implements Stage {
    private boolean[][] _maze;
    private Position _start;
    private Position _end;

    private ArrayList<Position> _avi;

    private Player _levelSevenPlayer;
    private Minotaur _levelSevenMinotaur;
    private Rat _levelSevenRat;
    private Zombie _levelSevenZombie;

    private Item _levelSevenKey;
    private Item _levelSevenMap;
    private Item _levelSevenSword;
    private Item _levelSevenTorch;

    private static final int PLAYER_START_ROW = 2;
    private static final int PLAYER_START_COL = 0;
    private static final int PLAYER_END_ROW = 3;
    private static final int PLAYER_END_COL = 0;

    private static final int MINOTAUR_START_ROW = 7;
    private static final int MINOTAUR_START_COL = 6;

    private static final int RAT_START_ROW = 1;
    private static final int RAT_START_COL = 1;

    private static final int ZOMBIE_START_ROW = 1;
    private static final int ZOMBIE_START_COL = 4;

    public Stage7() {
        _maze = new boolean[][] {
                {true, true, true, true, true, true, true, true, true, true},
                {true, false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, false, false, false, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
                {true, true, true, true, true, true, true, true, true, true},
        };
        StageMethods _sm = new StageMethods();
        _start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
        _end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
        _avi = _sm.getAvailablePositions(_maze);
        _levelSevenPlayer = new Player(_start, _end);
        _levelSevenMinotaur = new Minotaur(_sm.rr(_avi));
        _levelSevenRat = new Rat(_sm.rr(_avi));
        _levelSevenZombie = new Zombie(_sm.rr(_avi));
        _levelSevenKey = new Key(_sm.rr(_avi));
        _levelSevenMap = new Map(_sm.rr(_avi));
        _levelSevenSword = new Sword(_sm.rr(_avi));
        _levelSevenTorch = new Torch(_sm.rr(_avi));
    }

    public Position getStart() {
        return _start;
    }

    public Position getEnd() {
        return _end;
    }

    public boolean playerIsAtEnd() {
        return _levelSevenPlayer.amIAt(_end);
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
        return _levelSevenPlayer;
    }

    public Minotaur getMyMinotaur() {
        return _levelSevenMinotaur;
    }

    public Rat getMyRat() {
        return _levelSevenRat;
    }

    public Zombie getMyZombie() { return _levelSevenZombie; }

    public Key getMyKey() { return (Key) _levelSevenKey; }

    public Map getMyMap() { return (Map) _levelSevenMap; }

    public Sword getMySword() { return (Sword) _levelSevenSword; }

    public Torch getMyTorch() { return (Torch) _levelSevenTorch; }

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