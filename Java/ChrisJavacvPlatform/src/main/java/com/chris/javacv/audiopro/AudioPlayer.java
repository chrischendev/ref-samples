package com.chris.javacv.audiopro;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

/**
 * ChrisJavacvPlatform
 * com.chris.javacv.audiopro
 * Created by Chris Chen
 * 2018/8/20
 * Explain: 不成功
 */
public class AudioPlayer {
    public static void main(String[] args) {
        play();
    }

    private static void play() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //选择播放文件
                File file = new File("D:/gaihang.mp3");
                //创建audioclip对象
                AudioClip audioClip = null;
                //将file转换为url
                try {
                    audioClip = Applet.newAudioClip(file.toURL());
                    //循环播放	播放一次可以使用audioClip.play
                    audioClip.loop();
//                    Thread.sleep(5000);
                    System.out.println("正在播放");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
