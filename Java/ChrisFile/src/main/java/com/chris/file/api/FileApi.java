package com.chris.file.api;

import com.chris.file.model.UploadParams;
import com.chris.file.model.UrlResult;
import com.chris.file.utils.FileUtils;
import com.google.gson.Gson;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Chris Chen
 * 2018/12/10
 * Explain:
 */
@RestController
@RequestMapping("/file")
public class FileApi {
    @Value("${spring.servlet.multipart.location}")
    String fileFolder;
    @Autowired
    FileUtils fileUtils;
    @Autowired
    Gson gson;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        String saveFileName = fileFolder + File.separator + fileUtils.getRandomFileName(file);
        fileUtils.write(file, saveFileName);
        return "success!";
    }

    @PostMapping("/uploadForArray")
    public String uploadForArray(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        System.out.println(gson.toJson(bytes));
        String saveFileName = fileFolder + File.separator + fileUtils.getRandomFileName(file);
        OutputStream os = new FileOutputStream(saveFileName);
        os.write(bytes);
        os.close();
        return "success!";
    }

    @PostMapping("/uploadFromArray")
    public Boolean uploadFromArray(@RequestBody int[] bts) throws IOException {
        System.out.println(gson.toJson(bts));
        String saveFileName = fileFolder + File.separator + fileUtils.getRandomFileName("png");
        ByteArrayInputStream bais = new ByteArrayInputStream(fileUtils.intArrayToByteArray(bts));
        OutputStream os = new FileOutputStream(saveFileName);
        IOUtils.copy(bais, os);
        IOUtils.closeQuietly(os);
        IOUtils.closeQuietly(bais);
        return true;
    }

    @PostMapping("/uploadStream")
    public Boolean uploadStream(@RequestBody UploadParams params) throws IOException {
        String uploadFileName = params.getFileName();
        String saveFileName = fileFolder + File.separator + uploadFileName;
        ByteArrayInputStream bais = new ByteArrayInputStream(fileUtils.intArrayToByteArray(params.getDataByteArray()));
        OutputStream os = new FileOutputStream(saveFileName);
        IOUtils.copy(bais, os);
        IOUtils.closeQuietly(os);
        IOUtils.closeQuietly(bais);
        return true;
    }
}
