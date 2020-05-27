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

    /*
     * Sets the value of _isAlive to false.
     */
    public void killZombie() {
        _isAlive = false;
    }

    /*
     * The "AI" of the Zombie prioritizes certain decisions (out of necessity). If a decision is found
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
     * It is worth noting that the Zombie does not take its own speed into account when determining if a decision
     * is logical. For all practical purposes, one might say that it simply assumes that a player in its row/column
     * will simply stay in this same position.
     *
     * * This behavior cannot be observed under normal circumstances.
     * ** This behavior can never be observed.
     */
    public Position chooseMyPosition(Stage lvl) {

        if (_lurchCount == 0) {

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