package com.chris.javacv.videoplayer;

import org.bytedeco.javacv.*;

import javax.swing.*;

/**
 * ChrisJavacvPlatform
 * com.chris.javacv
 * Created by Chris Chen
 * 2018/8/20
 * Explain:
 */
public class VideoPlayerTest {
    private static String filename = "D:/ad.mp4";

    public static void main(String[] args) throws FrameGrabber.Exception {
        play();
    }


    private static void play() throws FrameGrabber.Exception {
        // 转换器，用于Frame/Mat/IplImage相互转换
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(filename);//打开视频文件
        grabber.start(); // 开始
        CanvasFrame canvas = new CanvasFrame("播放: " + filename);// 新建一个窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);
        Frame frame = null;
        while (true) {
            if (!canvas.isDisplayable()) {// 窗口是否关闭
                grabber.stop();// 停止抓取
                System.exit(2);// 退出
            }
            frame = grabber.grab();
            // 取一帧视频（图像），并转换为Mat
//            Mat mat = converter.convertToMat(frame);
            canvas.showImage(frame);
        }
    }
}
