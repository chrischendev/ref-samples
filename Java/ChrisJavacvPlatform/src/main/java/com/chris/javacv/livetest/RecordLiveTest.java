package com.chris.javacv.livetest;

import org.bytedeco.javacv.*;

/**
 * ChrisTechnologyDemo
 * com.chris.javacv.recordlive
 * Created by Chris Chen
 * 2018/8/20
 * Explain: 拉取直播流并且录制成文件
 */
public class RecordLiveTest {
    public static void main(String[] args) throws Exception {

//        String inputFile = "rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov";
//        String inputFile = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
//        String inputFile = "D:/t.mp4";
        String inputFile = "rtmp://192.168.1.101:1935/live/stream";
        // Decodes-encodes
        String outputFile = "D:/recorde-009.mp4";
        frameRecord(inputFile, outputFile, 1);
    }

    /**
     * 按帧录制视频
     *
     * @param inputFile-该地址可以是网络直播/录播地址，也可以是远程/本地文件路径
     * @param outputFile                              -该地址只能是文件地址，如果使用该方法推送流媒体服务器会报错，原因是没有设置编码格式
     * @throws FrameGrabber.Exception
     * @throws FrameRecorder.Exception
     * @throws org.bytedeco.javacv.FrameRecorder.Exception
     */
    public static void frameRecord(String inputFile, String outputFile, int audioChannel)
            throws Exception, org.bytedeco.javacv.FrameRecorder.Exception {

        final boolean isStart = true;//该变量建议设置为全局控制变量，用于控制录制结束
        // 获取视频源
        final FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputFile);
        // 流媒体输出地址，分辨率（长，高），是否录制音频（0:不录制/1:录制）
        final FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outputFile, 1280, 720, audioChannel);
        // 开始取视频源
        new Thread(new Runnable() {
            public void run() {
                try {
                    recordByFrame(grabber, recorder, isStart);
                } catch (FrameGrabber.Exception e) {
                    e.printStackTrace();
                } catch (FrameRecorder.Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private static void recordByFrame(FFmpegFrameGrabber grabber, FFmpegFrameRecorder recorder, Boolean status) throws FrameGrabber.Exception, FrameRecorder.Exception {
        try {//建议在线程中使用该方法
            grabber.start();
            recorder.start();
            Frame frame = null;
            //加入：设置一个录制30秒的逻辑
            long startTime = System.currentTimeMillis();
            while (status && (frame = grabber.grabFrame()) != null) {
                //开始后30秒退出
                if (System.currentTimeMillis() - startTime >= 30 * 1000) {
                    recorder.stop();
                    grabber.stop();
                    System.exit(0);//退出程序
                }
                recorder.record(frame);
            }
            recorder.stop();
            grabber.stop();
        } finally {
            if (grabber != null) {
                grabber.stop();
            }
        }
    }

}
