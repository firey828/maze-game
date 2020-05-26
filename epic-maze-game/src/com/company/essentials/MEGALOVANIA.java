package com.company.essentials;
import java.io.*;
import sun.audio.*;

/**
 * A simple Java sound file example (i.e., Java code to play a sound file).
 * AudioStream and AudioPlayer code comes from a javaworld.com example.
 * @author alvin alexander, devdaily.com.
 */
public class MEGALOVANIA {

    // ======== INSTANCE VARIABLES ========
    private AudioStream audioStream;

    // ======== CONSTRUCTORS ========
    public MEGALOVANIA() {
        InputStream in = null;
        try {
            in = new FileInputStream(getClass().getResource("Toby-Fox-Megalovania.wav").getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            new MessengerFromAcrossTheAbyss().twinElementalDragon("audio failed to load but quicker :(");
        }
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
            new MessengerFromAcrossTheAbyss().twinElementalDragon("audio failed to load :(");
        }
    }

    public void music() {
        AudioPlayer.player.start(audioStream);
    }

    public void sTOPTHEMUSICBLEASE(boolean isError) {
        AudioPlayer.player.stop(audioStream);
    }

    public AudioStream getAudioStream() {
        return audioStream;
    }
}