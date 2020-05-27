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

    /*
     * Sets the value of _isAlive to false.
     */
    public void killPlayer() {
        _isAlive = false;
    }

    /*
     * It's like saying this.equals(Position dest), except it actually works!
     */
    public boolean amIAt(Position dest) {
        return _curPos.samePosAs(dest);
    }

    /*
     * If the value of _hasTorch before a call to this method is true, but the value
     * of _stepsTillTorchRunsOut before a call to this method is 1, this method will
     * set _hasTorch to false and set _stepsTillTorchRunsOut to its initial value of
     * 100. It will also display a message with options. The option the user chooses
     * is irrelevant. However, if the latter of the aforementioned conditions is not
     * met, but the value of _hasTorch before a call to this method is true, the old
     * value of _stepsTillTorchRunsOut will be decremented and replaced with the new
     * resulting number.
     */
    public void torchCheck() {
        if (_hasTorch) {
            _stepsTillTorchRunsOut--;
            if (_stepsTillTorchRunsOut <= 0) {
                _hasTorch = false;
                _stepsTillTorchRunsOut = 100;
                new MessengerFromAcrossTheAbyss().option(new String[] { "of course i did", "wait, i was supposed to memorize all that??"}, "The light of your torch flickers for a moment, then fades out with a weak crackling. Because\n" +
                        "your torch has died out, you can no longer make out the writing on your map. Good thing you\n" +
                        "memorized it....right?");
            }
        }
    }

    /*
     * Attempts to take a single step in the Direction d on Stage z. Ensures that the
     * torch is checked as necessary via the torchCheck() method. Returns true if the
     * step was successfully taken (namely, if there is an empty space in the desired
     * direction and said space is not out of bounds), false otherwise.
     */
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

    /*
     * Sets the value of _hasSword to true.
     */
    public void pickUpSword() {
        _hasSword = true;
    }

    /*
     * Sets the value of _hasMap to true.
     */
    public void pickUpMap() {
        _hasMap = true;
    }

    /*
     * Sets the value of _hasTorch to true and resets the counter.
     */
    public void pickUpTorch() {
        _hasTorch = true;
        _stepsTillTorchRunsOut = 100;
    }

    /*
     * Sets the value of _hasKey to true.
     */
    public void pickUpKey() {
        _hasKey = true;
    }

    /*
     * Sets the value of _hasSword to false.
     */
    public void useSword() {
        _hasSword = false;
    }
}