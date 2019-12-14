package com.chris.javacv;

import java.util.ArrayList;
import java.util.List;

/**
 * ChrisJavacvDemo
 * com.chris.javacv
 * Created by Chris Chen
 * 2018/8/19
 * Explain: 获取一帧 成功
 */
public class FFmpegTest {
    public static void handler(String ffmpegPath, String upFilePath, String mediaPicPath) {
        List cutpic = new ArrayList();
        cutpic.add(ffmpegPath); // 视频提取工具的位置
        cutpic.add("-i"); // 添加参数＂-i＂，该参数指定要转换的文件
        cutpic.add(upFilePath); // 视频文件路径
        cutpic.add("-y");
        cutpic.add("-f");
        cutpic.add("image2");
        cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
        cutpic.add("2"); // 添加起始时间为第1秒
        cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
        cutpic.add("0.001"); // 添加持续时间为1毫秒
        //cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
        //cutpic.add("800*600"); // 添加截取的图片大小为800*600
        cutpic.add(mediaPicPath); // 添加截取的图片的保存路径
        boolean mark = true;
        ProcessBuilder builder = new ProcessBuilder();
        try {

            builder.command(cutpic);
            builder.redirectErrorStream(true);
            // 如果此属性为 true，则任何由通过此对象的 start() 方法启动的后续子进程生成的错误输出都将与标准输出合并，
            //因此两者均可使用 Process.getInputStream() 方法读取。这使得关联错误消息和相应的输出变得更容易
            builder.start();
        } catch (Exception e) {
            mark = false;
            System.out.println(e);
            e.printStackTrace();
        }
    }

    //??可是，linux下的ffmpeg功效一样吗
    public static void main(String[] args) {
        //handler("D:/ffmpeg-20170811-5859b5b-win64-static/bin/ffmpeg.exe","http://wemewtest.oss-cn-qingdao.aliyuncs.com/2017-06-08-14/wKPPSfepDZ.mp4","D:/new/test7.jpg");
        handler("D://Program Files/ffmpeg/bin/ffmpeg.exe", "D:/t.mp4", "D:/snot02.jpg");
    }
}
