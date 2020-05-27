package com.company.entities;

import com.company.Position;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;
import java.util.ArrayList;

import static com.company.essentials.Direction.*;


public class Minotaur {

    // ======== INSTANCE VARIABLES ========
    private Position _curPos;
    private Direction _curDir;
    private boolean _isAlive;

    // ======== GETTERS ========
    public Direction getDirection() {
        return _curDir;
    }
    public int getRow() {
        return _curPos.getRow();
    }
    public int getCol() {
        return _curPos.getCol();
    }
    public Position getPosition() {
        return _curPos;
    }
    public boolean isMinotaurAlive() {
        return _isAlive;
    }

    // ======== SETTERS ========
    public void setPosition(Position p) {
        _curPos = p;
    }

    // ======== CONSTRUCTORS ========
    public Minotaur(Position minotaurSpawnPoint) {
        _curPos = minotaurSpawnPoint;
        _curDir = Direction.mSouth;
        _isAlive = true;
    }

    /*
     * Sets the value of _isAlive to false.
     */
    public void killMinotaur() {
        _isAlive = false;
    }

    /*
     * The "AI" of the Minotaur prioritizes certain decisions (out of necessity). If a decision is found
     * to be logical, it will be implemented no matter what lower-priority decisions could have otherwise
     * been made. In order from highest priority to lowest priority:
     *
     * 1. Stay in the same position if the player is also in my position.*
     * 2. Move left if the player is anywhere directly to my left and the space immediately to my left is clear.
     * 3. Move right if the player is anywhere directly to my right and the space immediately to my right is clear.
     * 4. Move up if the player is anywhere directly above me and the space immediately above me is clear.
     * 5. Move down if the player is anywhere directly below me and the space immediately below me is clear.
     * 6. Stay in the same position and face down if there are no empty tiles available in any direction.*
     * 7. Of the directions I am capable of moving in, I will move in a randomly-selected one.
     * 8. Stay in the same position.**
     *
     * * This behavior cannot be observed under normal circumstances.
     * ** This behavior can never be observed.
     */
    public Position chooseMyPosition(Stage lvl) {

        Position leftP = _curPos.oneLeft();
        Position rightP = _curPos.oneRight();
        Position northP = _curPos.oneUp();
        Position southP = _curPos.oneDown();

        boolean canMoveLeft = (!lvl.isWall(leftP)) && (lvl.isInBounds(leftP));
        boolean canMoveRight = (!lvl.isWall(rightP)) && (lvl.isInBounds(rightP));
        boolean canMoveUp = (!lvl.isWall(northP)) && (lvl.isInBounds(northP));
        boolean canMoveDown = (!lvl.isWall(southP)) && (lvl.isInBounds(southP));

        Position playerPos = lvl.getMyPlayer().getPosition();
        int pRow = playerPos.getRow();
        int pCol = playerPos.getCol();

        int mRow = _curPos.getRow();
        int mCol = _curPos.getCol();

        if (playerPos.samePosAs(_curPos)) {
            return _curPos;
        }

        if (canMoveLeft && pRow == mRow && pCol < mCol) {
            _curPos = leftP;
            _curDir = mWest;
        } else if (canMoveRight && pRow == mRow && pCol > mCol) {
            _curPos = rightP;
            _curDir = mEast;
        } else if (canMoveUp && pCol == mCol && pRow < mRow) {
            _curPos = northP;
            _curDir = mNorth;
        } else if (canMoveDown && pCol == mCol && pRow > mRow) {
            _curPos = southP;
            _curDir = mSouth;
        } else {
            int i = 0;

            ArrayList <Position> randomPositions = new ArrayList <>(0);
            ArrayList <Direction> randomDirections = new ArrayList <>(0);

            if (canMoveLeft) {
                i++;
                randomPositions.add(leftP);
                randomDirections.add(mWest);
            }

            if (canMoveRight) {
                i++;
                randomPositions.add(rightP);
                randomDirections.add(Direction.mEast);
            }

            if (canMoveUp) {
                i++;
                randomPositions.add(northP);
                randomDirections.add(Direction.mNorth);
            }

            if (canMoveDown) {
                i++;
                randomPositions.add(southP);
                randomDirections.add(Direction.mSouth);
            }

            if (i <= 0) {
                _curDir = mSouth;
            } else {
                int d = (int) (Math.random() * randomPositions.size());
                _curPos = randomPositions.get(d);
                _curDir = randomDirections.get(d);
            }
        }
        return _curPos;
    }
}

