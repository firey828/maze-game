package com.company.effects;

import com.company.Position;
import com.company.essentials.MessengerFromAcrossTheAbyss;
import com.company.stages.Stage;

import java.util.ArrayList;

public class FogOfWar {

    // ======== INSTANCE VARIABLES ========
    private boolean _playerHasTorch;
    private boolean _playerHasMap;
    Stage _stage;
    public boolean[][] entireBoard;
    public boolean[][] isInvisible;
    public boolean[][] isVisible;
    public Position _playerPosition;
    private int _searchRange;

    // ======== CONSTRUCTORS ========
    public FogOfWar(Stage stage) {
        _stage = stage;
        _playerPosition = _stage.getMyPlayer().getPosition();
        entireBoard = _stage.getMaze();
        isInvisible = new boolean[entireBoard.length][entireBoard[0].length];
        isVisible = new boolean[entireBoard.length][entireBoard[0].length];
        _playerHasTorch = _stage.getMyPlayer().hasTorch();
        _playerHasMap = _stage.getMyPlayer().hasMap();
        if (_playerHasMap) {
            for (int x = 0; x < entireBoard.length; x++) {
                for (int y = 0; y < entireBoard[x].length; y++) {
                    isVisible[x][y] = true;
                }
            }
            return;
        } else if (_playerHasTorch) {
            _searchRange = 2;
        } else {
            _searchRange = 1;
        }

        for (int x = 0; x < entireBoard.length; x++) {
            for (int y = 0; y < entireBoard[x].length; y++) {
                if ((x >= _playerPosition.getRow() - _searchRange && x <= _playerPosition.getRow() + _searchRange) || x == _playerPosition.getRow()) {
                    if ((y >= _playerPosition.getCol() - _searchRange && y <= _playerPosition.getCol() + _searchRange) || y == _playerPosition.getCol()) {
                        isVisible[x][y] = true;
                        isInvisible[x][y] = false;
                    } else {
                        isVisible[x][y] = false;
                        isInvisible[x][y] = true;
                    }
                } else {
                    isVisible[x][y] = false;
                    isInvisible[x][y] = true;
                }
            }
        }
    }
}
