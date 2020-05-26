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

    private Position _curPos;
    private Direction _curDir;
    private boolean _isAlive;

    // public Position getPosition() { return _curPos;	}

    public Rat(Position ratSpawnPoint) {
        _curPos = ratSpawnPoint;
        _curDir = rSouth;
        _isAlive = true;
    }

    public void killRat() {
        _isAlive = false;
    }

    public boolean isRatAlive() {
        return _isAlive;
    }

    public Direction getDirection() {
        return _curDir;
    }

    public void setPosition(Position p) {
        _curPos = p;
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
            // System.out.println("bluh rat is trapped, this should never happen");
            _curDir = rSouth;
        } else {
            int d = (int) (Math.random() * randomPositions.size());
            _curPos = randomPositions.get(d);
            _curDir = randomDirections.get(d);
        }
        return _curPos;
    }
}
