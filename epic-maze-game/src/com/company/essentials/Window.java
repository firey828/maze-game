package com.company.essentials;

import com.company.MessageCentral;
import com.company.Position;
import com.company.effects.FogOfWar;
import com.company.essentials.*;
import com.company.entities.*;
import com.company.items.*;
import com.company.stages.*;

import javax.swing.*;
import java.awt.*;

public class Window {

    // ======== INSTANCE VARIABLES ========
    private int windowCount = 0;
    private JFrame _frame;
    private JPanel _pan;
    private JLabel[][] _labelMaze;
    private boolean[][] _hasFogged;
    private JLabel _playerLabel;
    private JLabel _minotaurLabel;
    private JLabel _ratLabel;
    private JLabel _zombieLabel;
    private JLabel _keyLabel;
    private JLabel _mapLabel;
    private JLabel _swordLabel;
    private JLabel _torchLabel;
    private JLabel[][] _fogLabel;
    private Player _player;
    private Minotaur _minotaur;
    private Rat _rat;
    private Zombie _zombie;
    private Key _key;
    private Map _map;
    private Sword _sword;
    private Torch _torch;
    private Stage _myStage;
    private AlienOverlord _myAlienDude;

    // ======== GETTERS ========
    public Stage getMaze() { return _myStage; }
    public Player getPlayer() { return _player; }
    public Minotaur getMinotaur() { return _minotaur; }
    public Rat getRat() { return _rat; }
    public Zombie getZombie() { return _zombie; }
    public Key getKey() { return _key; }
    public Map getMap() { return _map; }
    public Sword getSword() { return _sword; }
    public Torch getTorch() { return _torch; }
    public JLabel getPlayerGraphic() { return _playerLabel; }
    public JLabel getMinotaurGraphic() { return _minotaurLabel; }
    public JLabel getRatGraphic() { return _ratLabel; }
    public JLabel getZombieGraphic() { return _zombieLabel; }
    public JLabel getKeyGraphic() { return _keyLabel; }
    public JLabel getMapGraphic() { return _mapLabel; }
    public JLabel getSwordGraphic() { return _swordLabel; }
    public JLabel getTorchGraphic() { return _torchLabel; }
    public JLabel[][] getMazeGraphic() { return _labelMaze; }
    public JFrame getFrame() {
        return _frame;
    }

    // ======== CONSTRUCTORS ========
    public Window(Stage lvl, AlienOverlord myAlienDude) {
        _myStage = lvl;
        _player = lvl.getMyPlayer();
        _minotaur = lvl.getMyMinotaur();
        _rat = lvl.getMyRat();
        _zombie = lvl.getMyZombie();
        _key = lvl.getMyKey();
        _map = lvl.getMyMap();
        _sword = lvl.getMySword();
        _torch = lvl.getMyTorch();
        _fogLabel = new JLabel[lvl.getMaze().length][lvl.getMaze()[0].length];
        _hasFogged = new boolean[_fogLabel.length][_fogLabel[0].length];
        _myAlienDude = myAlienDude;
    }

    /*
     * Listen, it works, okay? That's all that matters.
     */
    public void makeActualFrameOnce(Stage lvl) {
        if (windowCount != 1) {
            _myStage = lvl;
            _player = lvl.getMyPlayer();
            _minotaur = lvl.getMyMinotaur();
            _rat = lvl.getMyRat();
            _zombie = lvl.getMyZombie();
            _key = lvl.getMyKey();
            _map = lvl.getMyMap();
            _sword = lvl.getMySword();
            _torch = lvl.getMyTorch();

            setupLabels();
            setupPanel();
            setupFrame();

            windowCount++;
        }
        // System.out.println(windowCount + " windows have been made! (Should always be 1)");
    }

    /*
     * Prepares the Stage's Player for display by placing a sprite in which it is facing the desired
     * direction at the cell of the grid that corresponds to the Player's location. By default, the
     * Player is facing up.
     */
    private void setupPlayer() {
        ImageIcon i = new ImageIcon(getClass().getResource("player_up.png"));
        _playerLabel = new JLabel(i);
        int r = _player.getPosition().getRow();
        int c = _player.getPosition().getCol();
        _playerLabel.setLocation(0, 0);
        _playerLabel.setSize(_labelMaze[r][c].getSize());
        _labelMaze[r][c].add(_playerLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Prepares the Stage's Minotaur for display by placing a sprite in which it is facing the
     * desired direction at the cell of the grid that corresponds to the Minotaur's location. By
     * default, the Minotaur is facing up.
     */
    private void setupMinotaur() {
        ImageIcon i = new ImageIcon(getClass().getResource("mino_up.png"));
        _minotaurLabel = new JLabel(i);
        int r = _minotaur.getRow();
        int c = _minotaur.getCol();
        _minotaurLabel.setLocation(0, 0);
        _minotaurLabel.setSize(_labelMaze[r][c].getSize());
        _labelMaze[r][c].add(_minotaurLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Prepares the Stage's Rat for display by placing a sprite in which it is facing the desired
     * direction at the cell of the grid that corresponds to the Rat's location. By default, the Rat
     * is facing up.
     */
    private void setupRat() {
        ImageIcon i = new ImageIcon(getClass().getResource("rat_up.png"));
        _ratLabel = new JLabel(i);
        int r = _rat.getPosition().getRow();
        int c = _rat.getPosition().getCol();
        _ratLabel.setLocation(0, 0);
        _ratLabel.setSize(_labelMaze[r][c].getSize());
        _labelMaze[r][c].add(_ratLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Using the power of incredibly inefficient programming, fogs up each and every square that
     * must be fogged up.
     */
    public void fogUp() {
        FogOfWar frog = new FogOfWar(_myStage);
        for (int x = 0; x < _fogLabel.length; x++) {
            for (int y = 0; y < _fogLabel[x].length; y++) {
                if (!_hasFogged[x][y] && frog.isInvisible[x][y]) {
                    _fogLabel[x][y] = new JLabel(new ImageIcon(getClass().getResource("fogOfWar.png")));
                    _fogLabel[x][y].setLocation(0, 0);
                    _fogLabel[x][y].setSize(_labelMaze[x][y].getSize());
                    _labelMaze[x][y].add(_fogLabel[x][y]);
                    _labelMaze[x][y].repaint();
                    _hasFogged[x][y] = true;
                } else {
                    if (_hasFogged[x][y] && frog.isVisible[x][y]) {
                        _labelMaze[x][y].remove(_fogLabel[x][y]);
                        _labelMaze[x][y].repaint();
                        _hasFogged[x][y] = false;
                    }
                }
            }
        }
    }

    /*
     * Prepares the Stage's Zombie for display by placing a sprite in which it is facing the desired
     * direction at the cell of the grid that corresponds to the Zombie's location. By default, the
     * Zombie is facing up.
     */
    private void setupZombie() {
        ImageIcon i = new ImageIcon(getClass().getResource("zombie_up.png"));
        _zombieLabel = new JLabel(i);
        int r = _zombie.getRow();
        int c = _zombie.getCol();
        _zombieLabel.setLocation(0, 0);
        _zombieLabel.setSize(_labelMaze[r][c].getSize());
        _labelMaze[r][c].add(_zombieLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Prepares the Stage's Key for display by placing the key sprite in the correct location on the
     * grid.
     */
    private void setupKey() {
        ImageIcon i = new ImageIcon(getClass().getResource("key.png"));
        _keyLabel = new JLabel(i);
        int r = _key.getRow();
        int c = _key.getCol();
        _keyLabel.setLocation(0, 0);
        _keyLabel.setSize(_labelMaze[r][c].getSize());
        _labelMaze[r][c].add(_keyLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Prepares the Stage's Map for display by placing the map sprite in the correct location on the
     * grid.
     */
    private void setupMap() {
        ImageIcon i = new ImageIcon(getClass().getResource("map.png"));
        _mapLabel = new JLabel(i);
        int r = _map.getRow();
        int c = _map.getCol();
        _mapLabel.setLocation(0, 0);
        _mapLabel.setSize(_labelMaze[r][c].getSize());
        _labelMaze[r][c].add(_mapLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Prepares the Stage's Sword for display by placing the sword sprite in the correct location on
     * the grid.
     */
    private void setupSword() {
        ImageIcon i = new ImageIcon(getClass().getResource("sword.png"));
        _swordLabel = new JLabel(i);
        int r = _sword.getRow();
        int c = _sword.getCol();
        _swordLabel.setLocation(0, 0);
        _swordLabel.setSize(_labelMaze[r][c].getSize());
        _labelMaze[r][c].add(_swordLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Prepares the Stage's Torch for display by placing the torch sprite in the correct location on
     * the grid.
     */
    private void setupTorch() {
        ImageIcon i = new ImageIcon(getClass().getResource("torch.png"));
        _torchLabel = new JLabel(i);
        int r = _torch.getRow();
        int c = _torch.getCol();
        _torchLabel.setLocation(0, 0);
        _torchLabel.setSize(_labelMaze[r][c].getSize());
        _labelMaze[r][c].add(_torchLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Prepares the Labels for display.
     */
    private void setupLabels(){
        _labelMaze = new JLabel[_myStage.getMaze().length][_myStage.getMaze()[0].length];
        for (int r = 0; r < _labelMaze.length; r++) {
            for (int c = 0; c < _labelMaze[r].length; c++) {
                if (_myStage.isWall(r, c)) {
                    ImageIcon i = new ImageIcon(getClass().getResource("void.png"));
                    _labelMaze[r][c] = new JLabel(i);
                } else {
                    ImageIcon i = new ImageIcon(getClass().getResource("space.png"));
                    _labelMaze[r][c] = new JLabel(i);
                }
            }
        }

    }

    /*
     * i have no idea why this exists. the parameter isError is unused, and, despite what the
     * printed message says, it does not, in fact, exit/close anything but the method itself.
     *
     * update: im removing it
     *
     * update: removing it breaks the program and i honestly dont care enough to figure out why so
     * im just gonna leave it like that
     */
    public void closeWindow(boolean isError) {
        System.out.println("Exiting");
    }

    /*
     * Prepares the Panel for display.
     */
    private void setupPanel() {
        _pan = new JPanel(new GridLayout(_labelMaze.length, _labelMaze[0].length));
        for (int x = 0; x < _labelMaze.length; x++) {
            for (int y = 0; y < _labelMaze[x].length; y++) {
                _pan.add(_labelMaze[x][y]);
            }
        }
        _pan.repaint();
    }

    /*
     * Prepares the Frame for display.
     */
    private void setupFrame() {
        _frame = new JFrame("Maze game");
        _frame.add(_pan);
        _frame.pack();
        _frame.setResizable(false);
        _frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setupPlayer();
        setupMinotaur();
        setupRat();
        setupZombie();
        setupKey();
        setupMap();
        setupSword();
        setupTorch();
        _frame.repaint();
        _frame.addKeyListener(new Keyboard(_frame, this, _myAlienDude.getMusicThing()));
        _frame.setVisible(true); // TODO: try making this into a while loop based around whether or not player has completed the level
    }

    /*
     * Shows the Player.
     */
    public void addPlayer(Position p, Direction d) {
        int r = p.getRow();
        int c = p.getCol();
        ImageIcon i = new ImageIcon(getClass().getResource(d.getDir()));
        _playerLabel = new JLabel(i);
        _playerLabel.setSize(_labelMaze[r][c].getSize());
        _player.setPosition(p);
        _labelMaze[r][c].add(_playerLabel);
        _labelMaze[r][c].repaint();
        if(p.equals(_myStage.getEnd())) {
            JOptionPane.showMessageDialog(_frame, "Congrats! You reached the end.");
        }
    }

    /*
     * Hides the Player.
     */
    public void removePlayer() {
        int r = _player.getPosition().getRow();
        int c = _player.getPosition().getCol();
        _labelMaze[r][c].remove(_playerLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Shows the Minotaur.
     */
    public void addMinotaur(Position p, Direction d) {
        int r = p.getRow();
        int c = p.getCol();
        ImageIcon i = new ImageIcon(getClass().getResource(d.getDir()));
        _minotaurLabel = new JLabel(i);
        _minotaurLabel.setSize(_labelMaze[r][c].getSize());
        _minotaur.setPosition(p);
        _labelMaze[r][c].add(_minotaurLabel);
        _labelMaze[r][c].repaint();
        // TODO: player dies if it is on same square as minotaur
    }

    /*
     * Hides the Minotaur.
     */
    public void removeMinotaur() {
        int r = _minotaur.getRow();
        int c = _minotaur.getCol();
        _labelMaze[r][c].remove(_minotaurLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Shows the Rat.
     */
    public void addRat(Position p, Direction d) {
        int r = p.getRow();
        int c = p.getCol();
        ImageIcon i = new ImageIcon(getClass().getResource(d.getDir()));
        _ratLabel = new JLabel(i);
        _ratLabel.setSize(_labelMaze[r][c].getSize());
        _rat.setPosition(p);
        _labelMaze[r][c].add(_ratLabel);
        _labelMaze[r][c].repaint();
        // TODO: player dies if it is on same square as minotaur
    }

    /*
     * Hides the Rat.
     */
    public void removeRat() {
        int r = _rat.getPosition().getRow();
        int c = _rat.getPosition().getCol();
        _labelMaze[r][c].remove(_ratLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Shows the Zombie.
     */
    public void addZombie(Position p, Direction d) {
        int r = p.getRow();
        int c = p.getCol();
        ImageIcon i = new ImageIcon(getClass().getResource(d.getDir()));
        _zombieLabel = new JLabel(i);
        _zombieLabel.setSize(_labelMaze[r][c].getSize());
        _zombie.setPosition(p);
        _labelMaze[r][c].add(_zombieLabel);
        _labelMaze[r][c].repaint();
        // TODO: player dies if it is on same square as zombie
    }

    /*
     * Hides the Zombie.
     */
    public void removeZombie() {
        int r = _zombie.getRow();
        int c = _zombie.getCol();
        _labelMaze[r][c].remove(_zombieLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Shows the Key.
     */
    public void addKey(Position p) {
        int r = p.getRow();
        int c = p.getCol();
        ImageIcon i = new ImageIcon(getClass().getResource("key.png"));
        _keyLabel = new JLabel(i);
        _keyLabel.setSize(_labelMaze[r][c].getSize());
        _key.setPosition(p);
        _labelMaze[r][c].add(_keyLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Hides the Key.
     */
    public void removeKey() {
        int r = _key.getRow();
        int c = _key.getCol();
        _labelMaze[r][c].remove(_keyLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Shows the Map.
     */
    public void addMap(Position p) {
        int r = p.getRow();
        int c = p.getCol();
        ImageIcon i = new ImageIcon(getClass().getResource("map.png"));
        _mapLabel = new JLabel(i);
        _mapLabel.setSize(_labelMaze[r][c].getSize());
        _map.setPosition(p);
        _labelMaze[r][c].add(_mapLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Hides the Map.
     */
    public void removeMap() {
        int r = _map.getRow();
        int c = _map.getCol();
        _labelMaze[r][c].remove(_mapLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Shows the Sword.
     */
    public void addSword(Position p) {
        int r = p.getRow();
        int c = p.getCol();
        ImageIcon i = new ImageIcon(getClass().getResource("sword.png"));
        _swordLabel = new JLabel(i);
        _swordLabel.setSize(_labelMaze[r][c].getSize());
        _sword.setPosition(p);
        _labelMaze[r][c].add(_swordLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Hides the Sword.
     */
    public void removeSword() {
        int r = _sword.getRow();
        int c = _sword.getCol();
        _labelMaze[r][c].remove(_swordLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Shows the Torch.
     */
    public void addTorch(Position p) {
        int r = p.getRow();
        int c = p.getCol();
        ImageIcon i = new ImageIcon(getClass().getResource("torch.png"));
        _torchLabel = new JLabel(i);
        _torchLabel.setSize(_labelMaze[r][c].getSize());
        _torch.setPosition(p);
        _labelMaze[r][c].add(_torchLabel);
        _labelMaze[r][c].repaint();
    }

    /*
     * Hides the Torch.
     */
    public void removeTorch() {
        int r = _torch.getRow();
        int c = _torch.getCol();
        _labelMaze[r][c].remove(_torchLabel);
        _labelMaze[r][c].repaint();
    }
}