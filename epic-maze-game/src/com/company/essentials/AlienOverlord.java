package com.company.essentials;

import com.company.MessageCentral;
import com.company.Position;
import com.company.stages.*;
import sun.audio.AudioStream;

import javax.swing.*;

public class AlienOverlord {

    Window _f;
    MessengerFromAcrossTheAbyss _twinElementalDragon;
    MusicStuff musicThing;
    Stage[] _levels;

    public MusicStuff getMusicThing() {
        return musicThing;
    }

    public AlienOverlord() {
        // TODO: implement an information/help section using /view/infoGUI.png
        musicThing = new MusicStuff();
        musicThing.music(); // take a wild guess as to what that does
        _twinElementalDragon = new MessengerFromAcrossTheAbyss();
        _twinElementalDragon.option(new String[]{"ok boomer"}, "long ago, yadda yadda, ancient greece, " +
                "something something, save the world, blah blah blah, only hope, etc, etc");
        _twinElementalDragon.msg("wasd to move, dont get caught by minotaur");
        _twinElementalDragon.msg("changelog:\n" +
                "/02/15/2020/ - did the thing\n" +
                "/02/16/2020/ - did the other thing\n" +
                "             - added item things\n" +
                "             - sword thing kills minotaur thing now\n" +
                "             - level 2 thing added\n" +
                "             - made it easier to make and visualize the map things\n" +
                "             - fixed the extra window thing\n" +
                "/02/18/2020/ - finished complete implementation of fog thing\n" +
                "             - made \"death via sphinx vore\" game over screen thing (still unimplemented as of nearly a month later)\n" +
                "             - level 3 thing added\n" +
                "/02/29/2020/ - made level 4 a thing\n" +
                "/03/15/2020/ - made level 6 a thing\n" +
                "/03/16/2020/ - fixed the jar-specific fog/movement bug\n" +
                "             - made level 5 a thing\n" +
                "             - added music\n");
        _twinElementalDragon.msg("to-do\n" +
                " - make the key item work\n" +
                " - make torches run out after a certain number of steps\n" +
                " - make sword respawn in random location after use\n" +
                " - make more sphinx riddles\n" +
                " - make level 7 a thing\n" +
                " - make level 8 a thing\n" +
                " - make level 9 a thing\n" +
                " - make level 10 a thing\n" +
                " - implement various key messages from MessageCentral\n" +
                " - make items not be visible in fog\n" +
                " - could we maybe not have the game close after every death? thanks. == TOP PRIORITY ==\n" +
                " - make music loop");
        _twinElementalDragon.msg("acknowledgements\n" +
                "- myself for making it\n" +
                "- sol for beta-testing it");
        String debugS = _twinElementalDragon.in("NORMAL or DEBUG?");
        _levels = new Stage[10];
        _levels[0] = new Stage1();
        _levels[1] = new Stage2();
        _levels[2] = new Stage3();
        _levels[3] = new Stage4();
        _levels[4] = new Stage5();
        _levels[5] = new Stage6();
        _levels[6] = new Stage7();
        _levels[7] = new Stage8();
        _levels[8] = new Stage9();
        _levels[9] = new StageA1();
        if (debugS.equalsIgnoreCase("NORMAL")) {
            int counter = 0;
            while (counter < _levels.length) {
                _f = new Window(_levels[counter], this);
                _f.makeActualFrameOnce(_levels[counter]);
                while (!_f.getMaze().playerIsAtEnd()) {
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // System.out.println("DEBUG MSG the next level should show now");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String riddleThing = new MessageCentral().getRandomRiddle();
                String guess = _twinElementalDragon.in("There is a sphinx here. She demands that you answer\n" +
                        "her question correctly in order to proceed. \"But,\n" +
                        "o great and powerful Sphinx,\" you plead, \"surely\n" +
                        "you can see how much difficulty I have encountered\n" +
                        "already simply to reach you. I implore you to give\n" +
                        "me mercy!\"\n" +
                        "\n" +
                        "She appears lost in thought for a moment. Finally,\n" +
                        "she replies: \"Sucks to suck. Here is the riddle: \"\n" +
                        "\n" +
                        riddleThing);
                if (new MessageCentral().answerIsValidPerQuestion(riddleThing, guess) && _f.getPlayer().hasKey()) {
                    _twinElementalDragon.msg("The sphinx smiles. \"Indeed, that is the answer. You may pass.\"");
                    try {
                        _twinElementalDragon.msg("Loading....");
                        _f.getFrame().setVisible(false);
                        _twinElementalDragon.msg("Please stand by....");
                        Thread.sleep(2000);
                        _twinElementalDragon.msg("Loaded!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter = counter + 1;
                    // System.out.println("DEBUG MSG Counter: " + counter);
                } else if (new MessageCentral().answerIsValidPerQuestion(riddleThing, guess) && !_f.getPlayer().hasKey()) {
                    _twinElementalDragon.msg("The sphinx begins to nod, then stops.\n" +
                            "\"Indeed, that is the answer, \n" +
                            "Yet you may not proceed.\n" +
                            "You see, young necromancer,\n" +
                            "My pharaoh has decreed\n" +
                            "That, should somebody reach the end,\n" +
                            "Then they must pay a fee.\n" +
                            "But, as it seems you're broke, my friend,\n" +
                            "You need to find a key.\"\n" +
                            "\n" +
                            "She teleports you to a random part of the maze.");
                    _f.getPlayer().setPosition(new StageMethods().rr(new StageMethods().getAvailablePositions(_f.getMaze().getMaze())));
                } else {
                    _twinElementalDragon.msg("The sphinx rears up and pounces, crushing you to death. Game over.");
                    musicThing.sTOPTHEMUSICBLEASE(false);
                    try {
                        this.finalize();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                    AlienOverlord recursiveThing = new AlienOverlord();
                    System.exit(0);
                }
            }
        } else if (debugS.equalsIgnoreCase("DEBUG")) {
            int lvl = 2;
            int theLevel = _twinElementalDragon.option(new String[]{"Lobby (Unused)", "Stage 1", "Stage 2", "Stage 3", "Stage 4", "Stage 5", "Stage 6", "Stage 7", "Stage 8", "Stage 9", "Stage 10", "TestStage (Unused)"}, "Which level would you like to go to?");
            if (theLevel == 0) {
                _f = new Window(new Lobby(), this);
                _f.makeActualFrameOnce(new Lobby());
            } else if (theLevel == 1) {
                _f = new Window(new Stage1(), this);
                _f.makeActualFrameOnce(new Stage1());
            } else if (theLevel == 2) {
                _f = new Window(new Stage2(), this);
                _f.makeActualFrameOnce(new Stage2());
            } else if (theLevel == 3) {
                _f = new Window(new Stage3(), this);
                _f.makeActualFrameOnce(new Stage3());
            } else if (theLevel == 4) {
                _f = new Window(new Stage4(), this);
                _f.makeActualFrameOnce(new Stage4());
            } else if (theLevel == 5) {
                _f = new Window(new Stage5(), this);
                _f.makeActualFrameOnce(new Stage5());
            } else if (theLevel == 6) {
                _f = new Window(new Stage6(), this);
                _f.makeActualFrameOnce(new Stage6());
            } else if (theLevel == 7) {
                _f = new Window(new Stage7(), this);
                _f.makeActualFrameOnce(new Stage7());
            } else if (theLevel == 8) {
                _f = new Window(new Stage8(), this);
                _f.makeActualFrameOnce(new Stage8());
            } else if (theLevel == 9) {
                _f = new Window(new Stage9(), this);
                _f.makeActualFrameOnce(new Stage9());
            } else if (theLevel == 10) {
                _f = new Window(new StageA1(), this);
                _f.makeActualFrameOnce(new StageA1());
            } else if (theLevel == 11) {
                _f = new Window(new TestStage(), this);
                _f.makeActualFrameOnce(new TestStage());
            }
        } else {
            musicThing.sTOPTHEMUSICBLEASE(true);
            MEGALOVANIA megalovania = new MEGALOVANIA();
            megalovania.music();
            new MessengerFromAcrossTheAbyss().msg(new ImageIcon(getClass().getResource("jojobug.png")));
            megalovania.sTOPTHEMUSICBLEASE(true);
            System.exit(-1);
        }
    }
}
