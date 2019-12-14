package com.chris.javacv.audiopro;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * ChrisJavacvPlatform
 * com.chris.javacv.audiopro
 * Created by Chris Chen
 * 2018/8/20
 * Explain:
 */
public class SoundManager extends Application {
    private Sound sound;
    private static String mediaFilePath;
    private static String[] args;

    public static void play(String mediaFilePath, String[] agrs) {
        SoundManager.mediaFilePath = mediaFilePath;
        SoundManager.args = agrs;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        sound = new Sound("file:///" + mediaFilePath, false);
        sound.play();//播放一次
    }
}
