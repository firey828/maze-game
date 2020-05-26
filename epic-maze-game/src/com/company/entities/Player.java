package com.company.entities;

import com.company.Position;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;


public class Player {

    // ======== INSTANCE VARIABLES ========
    private Position _curPos;
    private boolean _hasSword = false;
    private boolean _hasTorch = false;
    private boolean _hasMap = false;
    private boolean _hasKey = false;
    private int _stepsTillTorchRunsOut;
    private boolean _isAlive = true;

    // ======== GETTERS ========
    public Position getPosition() {
        return _curPos;
    }
    public boolean isAlive() {
        return _isAlive;
    }
    public boolean hasSword() {
        return _hasSword;
    }
    public boolean hasMap() {
        return _hasMap;
    }
    public boolean hasTorch() {
        return _hasTorch;
    }
    public boolean hasKey() { return _hasKey; }

    // ======== SETTERS ========
    public void setPosition(Position p) {
        _curPos = p;
    }

    // ======== CONSTRUCTORS ========
    public Player(Position _mySpawnPoint, Position _myEndPoint) {
        _curPos = _mySpawnPoint;
    }

    public void killPlayer() {
        _isAlive = false;
    }

    public boolean amIAt(Position dest) {
        return _curPos.samePosAs(dest);
    }

    public void torchCheck() {
        if (_hasTorch) {
            _stepsTillTorchRunsOut--;
            // System.out.println("DEBUG: steps till torch runs out: " + _stepsTillTorchRunsOut);
            if (_stepsTillTorchRunsOut <= 0) {
                _hasTorch = false;
                _stepsTillTorchRunsOut = 100;
                new MessengerFromAcrossTheAbyss().option(new String[] { "of course i did", "wait, i was supposed to memorize all that??"}, "The light of your torch flickers for a moment, then fades out with a weak crackling. Because\n" +
                        "your torch has died out, you can no longer make out the writing on your map. Good thing you\n" +
                        "memorized it....right?");
            }
        } else {
            // System.out.println("DEBUG: player does not have torch.");
        }
    }

    public boolean move(Direction d, Stage z) {
        if (d == Direction.North) {
            if (_curPos.getRow() - 1 >= 0 && !z.getMaze()[_curPos.getRow() - 1][_curPos.getCol()]) {
                _curPos = new Position(_curPos.getRow() - 1, _curPos.getCol());
                torchCheck();
                return true;
            }
        } else if (d == Direction.South) {
            if (_curPos.getRow() + 1 < z.getMaze().length && !z.getMaze()[_curPos.getRow() + 1][_curPos.getCol()]) {
                _curPos = new Position(_curPos.getRow() + 1, _curPos.getCol());
                torchCheck();
                return true;
            }
        } else if (d == Direction.East) {
            if (_curPos.getCol() + 1 < z.getMaze()[_curPos.getRow()].length
                    && !z.getMaze()[_curPos.getRow()][_curPos.getCol() + 1]) {
                _curPos = new Position(_curPos.getRow(), _curPos.getCol() + 1);
                torchCheck();
                return true;
            }
        } else {
            if (_curPos.getCol() - 1 >= 0 && !z.getMaze()[_curPos.getRow()][_curPos.getCol() - 1]) {
                _curPos = new Position(_curPos.getRow(), _curPos.getCol() - 1);
                torchCheck();
                return true;
            }
        }
        return false;
    }

    public void pickUpSword() {
        _hasSword = true;
    }

    public void pickUpMap() {
        _hasMap = true;
    }

    public void pickUpTorch() {
        _hasTorch = true;
        _stepsTillTorchRunsOut = 100;
    }

    public void pickUpKey() { _hasKey = true; }

    public void useSword() {
        _hasSword = false;
    }
}