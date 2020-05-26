package com.company.essentials;

import com.company.MessageCentral;
import com.company.Position;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;
import com.company.effects.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import sun.audio.AudioStream;

public class Keyboard implements KeyListener {

    // ======== INSTANCE VARIABLES ========
    private JFrame _frame;
    private Window _f;
    private MusicStuff _audioStream;

    // ======== CONSTRUCTORS ========
    public Keyboard(JFrame myStage, Window f, MusicStuff audioStream) {
        _frame = myStage;
        _f = f;
        _audioStream = audioStream;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        _f.fogUp();
        Position p = _f.getPlayer().getPosition();
        int pr = p.getRow();
        int pc = p.getCol();
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (!_f.getMaze().isWall(p.oneUp()) && _f.getMaze().isInBounds(p.oneUp())) {
                _f.removePlayer();
                _f.addPlayer(p.oneUp(), Direction.North);
                _f.getPlayer().torchCheck();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (!_f.getMaze().isWall(p.oneLeft()) && _f.getMaze().isInBounds(p.oneLeft())) {
                _f.removePlayer();
                _f.addPlayer(p.oneLeft(), Direction.West);
                _f.getPlayer().torchCheck();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (!_f.getMaze().isWall(p.oneDown()) && _f.getMaze().isInBounds(p.oneDown())) {
                _f.removePlayer();
                _f.addPlayer(p.oneDown(), Direction.South);
                _f.getPlayer().torchCheck();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (!_f.getMaze().isWall(p.oneRight()) && _f.getMaze().isInBounds(p.oneRight())) {
                _f.removePlayer();
                _f.addPlayer(p.oneRight(), Direction.East);
                _f.getPlayer().torchCheck();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

        MessengerFromAcrossTheAbyss twinElementalDragon = new MessengerFromAcrossTheAbyss();

        System.out.println("DEBUG: " + _f.getPlayer().getPosition().toString());

        Minotaur taur = _f.getMaze().getMyMinotaur();
        if (taur.isMinotaurAlive()) {
            _f.removeMinotaur();
            _f.addMinotaur(taur.chooseMyPosition(_f.getMaze()), taur.getDirection());
        }

        Rat rat = _f.getMaze().getMyRat();
        if(rat.isRatAlive()) {
            _f.removeRat();
            _f.addRat(rat.chooseMyPosition(_f.getMaze()), rat.getDirection());
        }

        Zombie zombie = _f.getMaze().getMyZombie();
        if (zombie.isZombieAlive()) {
            _f.removeZombie();
            _f.addZombie(zombie.chooseMyPosition(_f.getMaze()), zombie.getDirection());
        }

        Key key = _f.getMaze().getMyKey();
        Map map = _f.getMaze().getMyMap();
        Sword sword = _f.getMaze().getMySword();
        Torch torch = _f.getMaze().getMyTorch();

        if (taur.getPosition().samePosAs(_f.getPlayer().getPosition())) {
            if (_f.getPlayer().hasSword()) {
                twinElementalDragon.msg(MessageCentral.SWORD_KILLS_MINOTAUR);
                _f.removeMinotaur();
                _f.getPlayer().useSword();
                _f.getMinotaur().killMinotaur();
            } else if (taur.isMinotaurAlive()) {
                twinElementalDragon.msg(MessageCentral.KILLED_BY_MINOTAUR);
                _f.removePlayer();
                _f.getPlayer().setPosition(new StageMethods().rr(new StageMethods().getAvailablePositions(_f.getMaze().getMaze())));
            }
        }

        if (zombie.getPosition().samePosAs(_f.getPlayer().getPosition())) {
            if (_f.getPlayer().hasSword()) {
                twinElementalDragon.msg(MessageCentral.SWORD_KILLS_ZOMBIE);
                _f.removeZombie();
                _f.getPlayer().useSword();
                _f.getZombie().killZombie();
            } else if (zombie.isZombieAlive()) {
                twinElementalDragon.msg(MessageCentral.KILLED_BY_ZOMBIE);
                _f.removePlayer();
                _f.getPlayer().setPosition(new StageMethods().rr(new StageMethods().getAvailablePositions(_f.getMaze().getMaze())));
            }
        }

        if (rat.getPosition().samePosAs(_f.getPlayer().getPosition())) {
            if (_f.getPlayer().hasSword()) {
                twinElementalDragon.msg(MessageCentral.SWORD_KILLS_RAT);
                _f.removeRat();
                _f.getPlayer().useSword();
                _f.getRat().killRat();
            } else if (rat.isRatAlive()) {
                twinElementalDragon.msg("oh look its a dog");
            }
        }

        if (key.getPosition().samePosAs(_f.getPlayer().getPosition())) {
            twinElementalDragon.msg(MessageCentral.KEY_GET_MESSAGE);
            _f.removeKey();
            _f.addKey(new Position(0, 0));
            _f.getPlayer().pickUpKey();
        }

        if (map.getPosition().samePosAs(_f.getPlayer().getPosition())) {
            twinElementalDragon.msg(MessageCentral.MAP_GET_MESSAGE);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            _f.removeMap();
            _f.addMap(new Position(1, 0));
            _f.getPlayer().pickUpMap();
        }

        if (sword.getPosition().samePosAs(_f.getPlayer().getPosition())) {
            twinElementalDragon.msg(MessageCentral.SWORD_GET_MESSAGE);
            _f.removeSword();
            _f.addSword(new Position(2, 0));
            _f.getPlayer().pickUpSword();
        }

        if (torch.getPosition().samePosAs(_f.getPlayer().getPosition()) && !_f.getPlayer().getPosition().samePosAs(_f.getMaze().getEnd())) {
            twinElementalDragon.msg(MessageCentral.TORCH_GET_MESSAGE);
            _f.removeTorch();
            _f.addTorch(new Position(3, 0));
            _f.getPlayer().pickUpTorch();
        }

        try {
            Thread.sleep(20);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        _f.fogUp();
        // System.out.println("DEBUG MSG Player is at end: " + _f.getMaze().playerIsAtEnd());
        // System.out.println("DEBUG MSG Location of end: " + _f.getMaze().getEnd().toString());
        // System.out.println("DEBUG MSG Current Position: " + _f.getPlayer().getPosition().toString());
        // System.out.println("DEBUG MSG Player is at location (" + _f.getPlayer().getPosition().toString() + "): " + _f.getPlayer().amIAt(new Position(_f.getPlayer().getPosition().getRow(), _f.getPlayer().getPosition().getCol())));
    }
}
