package com.chris.javacv;

/*
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.opencv.core.Core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.bytedeco.javacpp.opencv_core.cvReleaseImage;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;
import static org.bytedeco.javacpp.opencv_imgproc.cvSmooth;
*/
public class JavaCV {
    /*
    // the image's path;
    final static String imagePath = "D:\\";
    // the vedio's path and filename;
    final static String vedioPath = "D:\\";
    final static String vedioName = "t.mp4";

    public static void main(String[] args) throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        smooth(imagePath);
        grabberFFmpegImage(vedioPath + vedioName, vedioPath, vedioName, 30);
    }

    // the method of compress image;
    public static void smooth(String fileName) {
        opencv_core.IplImage iplImage = cvLoadImage(fileName);
        if (iplImage != null) {
            cvSmooth(iplImage, iplImage);
            cvSaveImage(fileName, iplImage);
            cvReleaseImage(iplImage);
        }
    }

    // grab ffmpegImage from vedio;
    public static void grabberFFmpegImage(String filePath, String fileTargetPath, String fileTargetName, int grabSize) throws Exception {
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
        ff.start();
        for (int i = 0; i < grabSize; i++) {
            Frame frame = ff.grabImage();
            doExecuteFrame(frame, filePath, fileTargetName, i);
        }
        ff.stop();
    }
    // grab frame from vedio;

    public static void doExecuteFrame(Frame frame, String targetFilePath, String targetFileName, int index) {
        if (frame == null || frame.image == null) {
            return;
        }
        Java2DFrameConverter converter = new Java2DFrameConverter();
        String imageMat = "jpg";
        String fileName = targetFilePath + File.pathSeparator + targetFileName + "_" + index + "." + imageMat;
        BufferedImage bi = converter.getBufferedImage(frame);
        File output = new File(fileName);
        try {
            ImageIO.write(bi, imageMat, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}