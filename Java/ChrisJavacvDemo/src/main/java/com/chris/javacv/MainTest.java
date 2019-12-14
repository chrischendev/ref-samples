package com.chris.javacv;

import com.sun.javafx.iio.ImageStorage;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ChrisJavacvDemo
 * com.chris.javacv
 * Created by Chris Chen
 * 2018/8/19
 * Explain:
 */
public class MainTest {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        test();
    }

    private static void test() {
        Mat src = Imgcodecs.imread("D:\\chrisfile\\upload\\images\\live_video_item.png");
        if (src.empty()) return;
        System.out.println(src.height());
        BufferedImage bufferedImage = conver2Image(src);
        System.out.println(bufferedImage.getWidth());
        try {
            ImageIO.write(bufferedImage, "png", new File("D:\\cc.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage conver2Image(Mat mat) {
        int width = mat.cols();
        int height = mat.rows();
        int dims = mat.channels();
        int[] pixels = new int[width * height];
        byte[] rgbdata = new byte[width * height * dims];
        mat.get(0, 0, rgbdata);
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);
        int index = 0;
        int r = 0, g = 0, b = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (dims == 3) {
                    index = row * width * dims + col * dims;
                    b = rgbdata[index] & 0xff;
                    g = rgbdata[index + 1] & 0xff;
                    r = rgbdata[index + 2] & 0xff;
                    pixels[row * width + col] = ((255 & 0xff) << 24) |
                            ((r & 0xff) << 16) | ((g & 0xff) << 8) | b & 0xff;
                }
                if (dims == 1) {
                    index = row * width + col;
                    b = rgbdata[index] & 0xff;
                    pixels[row * width + col] = ((255 & 0xff) << 24) |
                            ((b & 0xff) << 16) | ((b & 0xff) << 8) | b & 0xff;
                }
            }
        }
        //setRGB( image, 0, 0, width, height, pixels);
        return image;
    }

    public static Mat convert2Mat(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Mat src = new Mat(new Size(width, height), CvType.CV_8UC3);
        int[] pixels = new int[width * height];
        byte[] rgbdata = new byte[width * height * 3];
        //getRGB( image, 0, 0, width, height, pixels );
        int index = 0, c = 0;
        int r = 0, g = 0, b = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                index = row * width + col;
                c = pixels[index];
                r = (c & 0xff0000) >> 16;
                g = (c & 0xff00) >> 8;
                b = c & 0xff;

                index = row * width * 3 + col * 3;
                rgbdata[index] = (byte) b;
                rgbdata[index + 1] = (byte) g;
                rgbdata[index + 2] = (byte) r;
            }
        }

        src.put(0, 0, rgbdata);
        return src;
    }
}
