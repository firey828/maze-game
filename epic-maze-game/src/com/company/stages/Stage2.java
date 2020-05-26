package com.company.stages;

import com.company.Position;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;

import java.util.ArrayList;

public class Stage2 implements Stage {
    private boolean[][] _maze;
    private Position _start;
    private Position _end;

    private ArrayList<Position> _avi;

    private Player _levelTwoPlayer;
    private Minotaur _levelTwoMinotaur;
    private Rat _levelTwoRat;
    private Zombie _levelTwoZombie;

    private Item _levelTwoKey;
    private Item _levelTwoMap;
    private Item _levelTwoSword;
    private Item _levelTwoTorch;

    private static final int PLAYER_START_ROW = 0;
    private static final int PLAYER_START_COL = 1;
    private static final int PLAYER_END_ROW = 9;
    private static final int PLAYER_END_COL = 33;

    private static final int MINOTAUR_START_ROW = 7;
    private static final int MINOTAUR_START_COL = 6;

    private static final int RAT_START_ROW = 1;
    private static final int RAT_START_COL = 1;

    private static final int ZOMBIE_START_ROW = 1;
    private static final int ZOMBIE_START_COL = 4;

    public Stage2() {
        _maze = new boolean[][] {
                {true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true},
                {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                {true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true},
                {true, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, true},
                {true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, true, false, true},
                {true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, true, false, true},
                {true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, true},
                {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true}
        };
        StageMethods _sm = new StageMethods();
        _start = new Position(PLAYER_START_ROW, PLAYER_START_COL);
        _end = new Position(PLAYER_END_ROW, PLAYER_END_COL);
        _avi = _sm.getAvailablePositions(_maze);
        _levelTwoPlayer = new Player(_start, _end);
        _levelTwoMinotaur = new Minotaur(_sm.rr(_avi));
        _levelTwoRat = new Rat(_sm.rr(_avi));
        _levelTwoZombie = new Zombie(_sm.rr(_avi));
        _levelTwoKey = new Key(_sm.rr(_avi));
        _levelTwoMap = new Map(_sm.rr(_avi));
        _levelTwoSword = new Sword(_sm.rr(_avi));
        _levelTwoTorch = new Torch(_sm.rr(_avi));
    }

    public Position getStart() {
        return _start;
    }

    public Position getEnd() {
        return _end;
    }

    public boolean playerIsAtEnd() {
        return _levelTwoPlayer.amIAt(_end);
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
        return _levelTwoPlayer;
    }

    public Minotaur getMyMinotaur() {
        return _levelTwoMinotaur;
    }

    public Rat getMyRat() {
        return _levelTwoRat;
    }

    public Zombie getMyZombie() { return _levelTwoZombie; }

    public Key getMyKey() { return (Key) _levelTwoKey; }

    public Map getMyMap() { return (Map) _levelTwoMap; }

    public Sword getMySword() { return (Sword) _levelTwoSword; }

    public Torch getMyTorch() { return (Torch) _levelTwoTorch; }

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