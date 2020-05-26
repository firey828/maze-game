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

    // instance variables
    private Position _curPos;
    private Direction _curDir;
    private boolean _isAlive;

    // public Position getPosition() { return _curPos;	}

    public Minotaur(Position minotaurSpawnPoint) {
        _curPos = minotaurSpawnPoint;
        _curDir = Direction.mSouth;
        _isAlive = true;
    }

    public void killMinotaur() {
        _isAlive = false;
    }

    public boolean isMinotaurAlive() {
        return _isAlive;
    }

    public Direction getDirection() {
        return _curDir;
    }

    public void setPosition(Position p) {
        _curPos = p;
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

    public Position chooseMyPosition(Stage lvl) {

        Position leftP = _curPos.oneLeft();
        Position rightP = _curPos.oneRight();
        Position northP = _curPos.oneUp();
        Position southP = _curPos.oneDown();

        boolean canMoveLeft = (!lvl.isWall(leftP)) && (lvl.isInBounds(leftP));
        // System.out.println("canMoveLeft: " + canMoveLeft);
        boolean canMoveRight = (!lvl.isWall(rightP)) && (lvl.isInBounds(rightP));
        // System.out.println("canMoveRight: " + canMoveRight);
        boolean canMoveUp = (!lvl.isWall(northP)) && (lvl.isInBounds(northP));
        // System.out.println("canMoveUp: " + canMoveUp);
        boolean canMoveDown = (!lvl.isWall(southP)) && (lvl.isInBounds(southP));
        // System.out.println("canMoveDown: " + canMoveDown);
        // System.out.println("");

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
                // System.out.println("bluh minotaur is trapped, this should never happen");
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

