package com.chris.javacv.audiopro;

import javafx.application.Application;
import javafx.stage.Stage;


public class SoundMainTest extends Application {
    private Sound sound;// 注意，我这里是为了防止被JVM的垃圾回收给回收掉
    private static String mediaFilePath = "D:/ad.mp4";


    public static void main(String[] args) {
//        launch(args);// 初始化
        SoundManager.play(mediaFilePath, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 直接复制下来没效果可能是因为连接地址失效了
//		sound = new Sound("http://sc1.111ttt.cn/2017/1/04/26/297262113196.mp3", false);
        sound = new Sound("file:///" + mediaFilePath, false);
        sound.loop();// 循环播放
    }


}
