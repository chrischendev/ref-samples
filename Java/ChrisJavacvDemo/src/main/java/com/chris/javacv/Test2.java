package com.chris.javacv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * ChrisJavacvDemo
 * com.chris.javacv
 * Created by Chris Chen
 * 2018/8/19
 * Explain: 膨胀与腐蚀
 */
public class Test2 {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat srcImage = Imgcodecs.imread("D:\\i01.jpg");

        Mat dilateImage = srcImage.clone();
        Mat erodeImage = srcImage.clone();

        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));
        //膨胀
        Imgproc.dilate(srcImage, dilateImage, element, new Point(-1, -1), 1);
        //腐蚀
        Imgproc.erode(srcImage, erodeImage, element, new Point(-1, -1), 1);

        Imgcodecs.imwrite("D:\\i02.jpg", dilateImage);
        Imgcodecs.imwrite("D:\\i03.jpg", erodeImage);
    }
}
