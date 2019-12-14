package com.chris.javacv;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * ChrisJavacvDemo
 * com.chris.javacv
 * Created by Chris Chen
 * 2018/8/19
 * Explain: JavaCV 测试成功
 */
public class JavaCvTest {
    private static int FRAME_INDEX = 150;//抓取第?帧?????应该不对，含有关键帧的概念

    /**
     * 获取指定视频的帧并保存为图片至指定目录
     *
     * @param videofile 源视频文件路径
     * @param framefile 截取帧的图片存放路径
     * @throws Exception
     */
    public static void fetchFrame(String videofile, String framefile)
            throws Exception {
        long start = System.currentTimeMillis();
        File targetFile = new File(framefile);
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
        ff.start();
        int lenght = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        while (i < lenght) {
            // 过滤前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabFrame();//这个方法应该移动了指针
            if ((i >= FRAME_INDEX) && (f.image != null)) {
                break;
            }
            i++;
        }
        IplImage img = f.image;
        int owidth = img.width();
        int oheight = img.height();
        // 对截取的帧进行等比例缩放
//        int width = 800;
//        int height = (int) (((double) width / owidth) * oheight);
        int width = owidth;
        int height = oheight;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(f.image.getBufferedImage().getScaledInstance(width, height, Image.SCALE_SMOOTH),
                0, 0, null);
        ImageIO.write(bi, "jpg", targetFile);
        //ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
        try {
            //fetchFrame("http://wemewtest.oss-cn-qingdao.aliyuncs.com/2017-06-08-14/wKPPSfepDZ.mp4", "D:/new/test4.jpg");
            fetchFrame("D:/t.mp4", "D:/test-" + FRAME_INDEX + ".jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
