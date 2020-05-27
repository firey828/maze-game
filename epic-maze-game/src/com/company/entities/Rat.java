package com.company.entities;

import com.company.Position;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;

import java.util.ArrayList;

import static com.company.essentials.Direction.*;

public class Rat {

    // ======== INSTANCE VARIABLES ========
    private Position _curPos;
    private Direction _curDir;
    private boolean _isAlive;

    // ======== GETTERS ========
    public Direction getDirection() {
        return _curDir;
    }
    public Position getPosition() {
        return _curPos;
    }
    public boolean isRatAlive() {
        return _isAlive;
    }

    // ======== SETTERS ========
    public void setPosition(Position p) {
        _curPos = p;
    }

    // ======== CONSTRUCTORS ========
    public Rat(Position ratSpawnPoint) {
        _curPos = ratSpawnPoint;
        _curDir = rSouth;
        _isAlive = true;
    }

    /*
     * Sets the value of _isAlive to false.
     */
    public void killRat() {
        _isAlive = false;
    }

    /*
     * The "AI" of the Rat prioritizes certain decisions (out of necessity). If a decision is found
     * to be logical, it will be implemented no matter what lower-priority decisions could have otherwise
     * been made. In order from highest priority to lowest priority:
     *
     * 1. Stay in the same position and face down if there are no empty tiles available in any direction.*
     * 2. Of the directions I am capable of moving in, I will move in a randomly-selected one.
     * 3. Stay in the same position.**
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

        int i = 0;

        ArrayList<Position> randomPositions = new ArrayList<>(0);
        ArrayList<Direction> randomDirections = new ArrayList<>(0);

        if (canMoveLeft) {
            i++;
            randomPositions.add(leftP);
            randomDirections.add(Direction.rWest);
        }

        if (canMoveRight) {
            i++;
            randomPositions.add(rightP);
            randomDirections.add(Direction.rEast);
        }

        if (canMoveUp) {
            i++;
            randomPositions.add(northP);
            randomDirections.add(Direction.rNorth);
        }

        if (canMoveDown) {
            i++;
            randomPositions.add(southP);
            randomDirections.add(rSouth);
        }

        if (i <= 0) {
            _curDir = rSouth;
        } else {
            int d = (int) (Math.random() * randomPositions.size());
            _curPos = randomPositions.get(d);
            _curDir = randomDirections.get(d);
        }
        return _curPos;
    }
}