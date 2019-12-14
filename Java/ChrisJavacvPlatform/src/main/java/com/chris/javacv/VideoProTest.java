package com.chris.javacv;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.*;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ChrisJavacvDemo
 * com.chris.javacv
 * Created by Chris Chen
 * 2018/8/19
 * Explain:获取摄像头视频流并添加水印
 * 这只是先截图，再加上字幕，没有混流，没有达到预期效果
 */
public class VideoProTest {
    public static void main(String[] args) throws Exception {
        addVideo();
    }

    // 获取摄像头视频流并添加水印
    public static void addVideo() throws Exception, InterruptedException {
        // 转换器，用于Frame/Mat/IplImage相互转换
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();

        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);//打开摄像头
        grabber.start(); // 开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");// 新建一个窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);


        Point point1 = new Point(10, 50);
        Point point2 = new Point(200, 200);
        Point point3 = new Point(200, 240);
        // 颜色
        Scalar scalar1 = new Scalar(0, 255, 255, 0);
        Scalar scalar2 = new Scalar(255, 0, 0, 0);
        Frame frame = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (true) {
            if (!canvas.isDisplayable()) {// 窗口是否关闭
                grabber.stop();// 停止抓取
                System.exit(2);// 退出
            }
            frame = grabber.grab();
            // 取一帧视频（图像），并转换为Mat
            opencv_core.Mat mat = converter.convertToMat(frame);
//            opencv_core.Mat mat = converter.convertToMat(frame);

            // 加文字水印，opencv_imgproc.putText（图片，水印文字，文字位置，字体，字体大小，字体颜色，字体粗度，文字反锯齿，是否翻转文字）
            opencv_imgproc.putText(mat, "eguid!", point2, opencv_imgproc.CV_FONT_VECTOR0, 2.2, scalar2, 1, 1, false);
            // 翻转字体，文字平滑处理（即反锯齿）
            //opencv_imgproc.putText(mat, "eguid!", point3, opencv_imgproc.CV_FONT_VECTOR0, 2.2, scalar2, 1, 20,true);

            //opencv_imgproc.putText(mat, sdf.format(new Date()), point1, opencv_imgproc.CV_FONT_ITALIC, 0.8, scalar1,2, 20, false);
            // 在窗口显示处理后的图像，Frame frame=converter.convert(mat);
            canvas.showImage(converter.convert(mat));

            //canvas.showImage(grabber.grab());// 获取摄像头图像并放到窗口上显示， 这里的Frame
            // frame=grabber.grab() ;
            // frame是一帧视频图像
            Thread.sleep(50);// 50毫秒刷新一次图像
        }
    }
}
