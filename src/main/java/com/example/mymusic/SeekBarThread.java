package com.example.mymusic;



public abstract class SeekBarThread extends Thread {

    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;

    public SeekBarThread(MediaPlayer mediaPlayerInput, SeekBar seekBarInput) {
        mediaPlayer = mediaPlayerInput;
        seekBar = seekBarInput;
    }

    @Override
    public void run() {
        int currentPosition = mediaPlayer.getCurrentPosition();

        int total mediaPlayer.getDuration();

        while (mediaPlayer != null && mediaPlayer.isPlaying() && currentPosition < total) {
            try {
                Thread.sleep(1000);
                currentPosition = mediaPlayer.getCurrentPosition();
            } catch (InterruptedException e) {
e.printStackTrace();

            }
        }
    }
}