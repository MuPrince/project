package com.prince.mall.file.controller;

import com.prince.mall.file.ceph.FileHandler;
import com.prince.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project mall <br\>
 * Package com.prince.mall.file.controller <br\>
 * <p>
 * Description : 文件上传/下载控制器 <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 9:19
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileHandler fileHandler;

    /**
     * Description :  文件上传
     * @param file
     * @return com.prince.mall.util.RespResult
     * @throws
     * @since 2021/7/7 9:21
     * @author StrangePrince
     */
    @PostMapping("upload")
    public RespResult upload(MultipartFile file) throws IOException {
        fileHandler.upload(file.getOriginalFilename(),file.getBytes());
        return RespResult.ok();
    }

    /**
     * Description :  文件下载
     * @param fileName 文件名
     * @return com.prince.mall.util.RespResult
     * @throws
     * @since 2021/7/7 9:21
     * @author StrangePrince
     */
    @PostMapping("download/{fileName}")
    public void download(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        byte[] buffer = fileHandler.download(fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(buffer);
        outputStream.flush();
        outputStream.close();
    }
}
