package com.company.essentials;

import javax.swing.*;

public class MessengerFromAcrossTheAbyss {

    // ======== CONSTRUCTORS ========
    public void twinElementalDragon(String twinElementalDragon) {
        JOptionPane.showMessageDialog(null, twinElementalDragon);
    }

    public String in(String twinElementalDragon) {
        return JOptionPane.showInputDialog(twinElementalDragon);
    }

    public int option(String[] options, String twinElementalDragon) {
        return JOptionPane.showOptionDialog(
                null,
                twinElementalDragon, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options, // possible options
                options[0]); // default option
    }

    public void println(String twinElementalDragon) {
        System.out.println(twinElementalDragon);
    }

    public void print(String twinElementalDragon) {
        System.out.println(twinElementalDragon);
    }

    public void msg(Object twinElementalDragon) {
        JOptionPane.showMessageDialog(null, twinElementalDragon);
    }

    public String in(Object twinElementalDragon) {
        return JOptionPane.showInputDialog(twinElementalDragon);
    }

    public int option(Object[] options, Object twinElementalDragon) {
        return JOptionPane.showOptionDialog(
                null,
                twinElementalDragon, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options, // possible options
                options[0]); // default option
    }
}