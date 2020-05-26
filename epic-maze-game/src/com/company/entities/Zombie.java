package com.company.entities;

import com.company.Position;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;
import java.util.ArrayList;

import static com.company.essentials.Direction.*;


public class Zombie {

    // ======== INSTANCE VARIABLES ========
    private Position _curPos;
    private Direction _curDir;
    private int _lurchCount;
    private boolean _isAlive;

    // ======== GETTERS ========
    public boolean isZombieAlive() {
        return _isAlive;
    }
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

    // ======== SETTERS ========
    public void setPosition(Position p) {
        _curPos = p;
    }

    // ======== CONSTRUCTORS ========
    public Zombie(Position zombieSpawnPoint) {
        _curPos = zombieSpawnPoint;
        _curDir = Direction.mSouth;
        _lurchCount = 0;
        _isAlive = true;
    }

    public void killZombie() {
        _isAlive = false;
    }
    
    public Position chooseMyPosition(Stage lvl) {

        if (_lurchCount == 0) {

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
                _curDir = zWest;
            } else if (canMoveRight && pRow == mRow && pCol > mCol) {
                _curPos = rightP;
                _curDir = zEast;
            } else if (canMoveUp && pCol == mCol && pRow < mRow) {
                _curPos = northP;
                _curDir = zNorth;
            } else if (canMoveDown && pCol == mCol && pRow > mRow) {
                _curPos = southP;
                _curDir = zSouth;
            } else {
                int i = 0;

                ArrayList <Position> randomPositions = new ArrayList <>(0);
                ArrayList <Direction> randomDirections = new ArrayList <>(0);

                if (canMoveLeft) {
                    i++;
                    randomPositions.add(leftP);
                    randomDirections.add(zWest);
                }

                if (canMoveRight) {
                    i++;
                    randomPositions.add(rightP);
                    randomDirections.add(Direction.zEast);
                }

                if (canMoveUp) {
                    i++;
                    randomPositions.add(northP);
                    randomDirections.add(Direction.zNorth);
                }

                if (canMoveDown) {
                    i++;
                    randomPositions.add(southP);
                    randomDirections.add(Direction.zSouth);
                }

                if (i <= 0) {
                    // System.out.println("bluh zombie is trapped, this should never happen");
                    _curDir = zSouth;
                } else {
                    int d = (int) (Math.random() * randomPositions.size());
                    _curPos = randomPositions.get(d);
                    _curDir = randomDirections.get(d);
                }
            }
            _lurchCount = 1;
            return _curPos;
        } else {
            _lurchCount = 0;
            return _curPos;
        }
    }
}
