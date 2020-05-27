package com.company;

public class MessageCentral {

    public static final String HELP_MESSAGE = "insert help message here";
    public static final String INTRO_MESSAGE = "insert epic backstory here";
    public static final String FOG_START_MESSAGE = "You enter the room. An ominous fog obstructs your vision.";
    public static final String TORCH_GET_MESSAGE = "You pick up the torch. This item allows you to see more clearly " +
            "through the fog for 100 steps.";
    public static final String MAP_GET_MESSAGE = "You pick up the map. This item allows you to see the entire room, " +
            "regardless of how foggy it may be.";
    public static final String SWORD_GET_MESSAGE = "You pick up the sword. This one-use item will instantly defeat any " +
            "enemy it comes in contact with. Once it has been used, it will re-appear in a random location on the floor.";
    public static final String KEY_GET_MESSAGE = "You pick up the key. This key will open any door, but will disappear " +
            "mysteriously after being used. Unlike the sword, however, the key will not reappear on a floor once it has " +
            "been collected from that floor.";
    public static final String SWORD_KILLS_MINOTAUR = "You swing your sword at the minotaur, killing it instantly. The " +
            "sword disappears to a random spot on the map.";
    public static final String SWORD_KILLS_RAT = "For some reason, you swing your sword at the rat, killing it instantly, " +
            "but also wasting your sword. The sword disappears to a random spot on the map. You are overcome with a sense " +
            "of having played yourself.";
    public static final String SWORD_KILLS_ZOMBIE = "You swing your sword at the zombie, killing it instantly. The " +
            "sword disappears to a random spot on the map.";
    public static final String KILLED_BY_MINOTAUR = "You are beaten to death by the minotaur. You respawn in a random part of the maze..";
    public static final String KILLED_BY_ZOMBIE = "You are eaten alive by the zombie. You respawn in a random part of the maze.";
    public static final String DOOR_INTERACTION_PLAYER_HAS_KEY = "You turn the key in the lock, and the entire door disappears.";
    public static final String DOOR_INTERACTION_PLAYER_NO_KEY = "This is a door. You will need to find a key in order to unlock it.";
    public static final String DOOR_INTERACTION_PLAYER_HAS_SWORD_NO_KEY = "You can't open a door with a sword, idiot.";
    public static final String DOOR_INTERACTION_PLAYER_HAS_KEY_NO_SWORD = "Feeling proud of yourself for evading all the " +
            "creatures on this floor and getting the key without getting hurt, you turn the key in the lock, and the entire " +
            "door disappears.";
    public static final String DOOR_INTERACTION_PLAYER_HAS_TORCH_NO_KEY = "Are you planning on burning it down? Clever " +
            "idea....wait, no, that's illegal.";

    public static final String SPHYNX_RIDDLE_1 = "Which chemical element has a symbol that is also the Spanish word for \"yes\"?";
    public static final String[] SPHYNX_ANSWERS_1 = {"SILICON", "SI"};

    public static final String SPHYNX_RIDDLE_2 = "A group of people are gathered in front of a wall. This wall was just built yesterday,\n" +
            "and yet it is already overrun with roots. Finding this to be completely normal, the oldest of\n" +
            "the group steps forward and creates more roots. Where is this wall?";
    public static final String[] SPHYNX_ANSWERS_2 = {"MATH CLASS", "MATH CLASSROOM", "MATH", "CLASS", "CLASSROOM", "SCHOOL", "IN MATH CLASS", "IN A MATH CLASS", "IN A MATH CLASSROOM", "IN MATH", "IN A CLASS", "IN CLASS", "IN A CLASSROOM", "IN A SCHOOL", "AT A SCHOOL", "IN SCHOOL", "AT SCHOOL"};

    public static final String SPHYNX_RIDDLE_3 = "If Elaine is either two years older OR two years younger than Mary, Mary is seventeen\n" +
            "years younger than John (making her twelve), and John is nineteen years older than Elaine, how old is Elaine?";
    public static final String[] SPHYNX_ANSWERS_3 = {"10", "10 years", "10 years old", "ten", "ten years", "ten years old"};

    public static final String SPHYNX_RIDDLE_4 = "Throughout their short existence, your species has been afflicted by many\n" +
            "different kinds of diseases, illnesses, and disorders. However, only one such affliction is\n" +
            "known to change one of the human organ systems into another. What is the name of this affliction?\n" +
            "(You may input the full name of the afflication, or the abbreviation. Either will suffice.)";
    public static final String[] SPHYNX_ANSWERS_4 = {"fibrodysplasia ossificans progressiva", "FOP", "F.O.P."};

    public static final String SPHYNX_RIDDLE_5 = "I have but one leg and no arms, yet I can carry a man much larger than myself.\n" +
            "What am I?";
    public static final String[] SPHYNX_ANSWERS_5 = {"STOOL", "A STOOL", "YOU ARE A STOOL", "YOU'RE A STOOL", "I AM A STOOL", "I'M A STOOL"};

    public static final String SPHYNX_RIDDLE_6 = "Seldom to your kind I near,\n" +
            "You say my name, I disappear.\n" +
            "I do not fade, I only die,\n" +
            "You won't see me, so do not try.\n" +
            "When I die, I do not cede\n" +
            "To creatures that on corpses feed.\n" +
            "Yet if all creatures fed no more,\n" +
            "Then, once again, I'd be reborn.\n" +
            "What am I?";
    public static final String[] SPHYNX_ANSWERS_6 = {"SILENCE", "QUIET", "YOU ARE SILENCE", "YOU ARE QUIET", "YOU'RE SILENCE", "YOU'RE QUIET", "I AM SILENCE", "I AM QUIET", "I'M SILENCE", "I'M QUIET"};

    public static final String SPHYNX_RIDDLE_7 = "I find myself in need more than in power,\n" +
            "Yet I am part of every government.\n" +
            "I do not see myself within a mirror,\n" +
            "And everywhere is somewhere I frequent.\n" +
            "\n" +
            "I beg your pardon if this seems like rambling,\n" +
            "But I am in both solvency and debt.\n" +
            "Don't get me wrong -- I'm comfortable with gambling,\n" +
            "As never have I ever lost a bet.\n" +
            "\n" +
            "You see, life simply could not be without me,\n" +
            "And yet, I will admit, I'm not divine,\n" +
            "As proven when a member of your species\n" +
            "Avoided me in 1939.";
    public static final String[] SPHYNX_ANSWERS_7 = {"E", "THE LETTER E", "LETTER E"};

    public String getRandomRiddle() {
        String[] sphynxRiddles = new String[7];
        sphynxRiddles[0] = SPHYNX_RIDDLE_1;
        sphynxRiddles[1] = SPHYNX_RIDDLE_2;
        sphynxRiddles[2] = SPHYNX_RIDDLE_3;
        sphynxRiddles[3] = SPHYNX_RIDDLE_4;
        sphynxRiddles[4] = SPHYNX_RIDDLE_5;
        sphynxRiddles[5] = SPHYNX_RIDDLE_6;
        sphynxRiddles[6] = SPHYNX_RIDDLE_7;
        int i = (int)(Math.random() * 7);
        return sphynxRiddles[i];
    }

    public boolean answerIsValidPerQuestion(String question, String answer) {
        if (question.equals(SPHYNX_RIDDLE_1)) {
            return isValidAnswer(1, answer);
        } else if (question.equals(SPHYNX_RIDDLE_2)) {
            return isValidAnswer(2, answer);
        } else if (question.equals(SPHYNX_RIDDLE_3)) {
            return isValidAnswer(3, answer);
        } else if (question.equals(SPHYNX_RIDDLE_4)) {
            return isValidAnswer(4, answer);
        } else if (question.equals(SPHYNX_RIDDLE_5)) {
            return isValidAnswer(5, answer);
        } else if (question.equals(SPHYNX_RIDDLE_6)) {
            return isValidAnswer(6, answer);
        } else if (question.equals(SPHYNX_RIDDLE_7)) {
            return isValidAnswer(7, answer);
        } else {
            System.out.println("bluh error: this should never happen");
            return false;
        }
    }

    public boolean isValidAnswer(int id, String answer) {
        boolean isValid = false;
        if (id == 1) {
            for (int i = 0; i < SPHYNX_ANSWERS_1.length; i++) {
                if (answer.equalsIgnoreCase(SPHYNX_ANSWERS_1[i])) {
                    isValid = true;
                }
            }
        } else if (id == 2) {
            for (int i = 0; i < SPHYNX_ANSWERS_2.length; i++) {
                if (answer.equalsIgnoreCase(SPHYNX_ANSWERS_2[i])) {
                    isValid = true;
                }
            }
        } else if (id == 3) {
            for (int i = 0; i < SPHYNX_ANSWERS_3.length; i++) {
                if (answer.equalsIgnoreCase(SPHYNX_ANSWERS_3[i])) {
                    isValid = true;
                }
            }
        } else if (id == 4) {
            for (int i = 0; i < SPHYNX_ANSWERS_4.length; i++) {
                if (answer.equalsIgnoreCase(SPHYNX_ANSWERS_4[i])) {
                    isValid = true;
                }
            }
        } else if (id == 5) {
            for (int i = 0; i < SPHYNX_ANSWERS_5.length; i++) {
                if (answer.equalsIgnoreCase(SPHYNX_ANSWERS_5[i])) {
                    isValid = true;
                }
            }
        } else if (id == 6) {
            for (int i = 0; i < SPHYNX_ANSWERS_6.length; i++) {
                if (answer.equalsIgnoreCase(SPHYNX_ANSWERS_6[i])) {
                    isValid = true;
                }
            }
        } else if (id == 7) {
            for (int i = 0; i < SPHYNX_ANSWERS_7.length; i++) {
                if (answer.equalsIgnoreCase(SPHYNX_ANSWERS_7[i])) {
                    isValid = true;
                }
            }
        } else {
            isValid = false;
            System.out.println("bluh error: this should never happen");
        }
        return isValid;
    }
}