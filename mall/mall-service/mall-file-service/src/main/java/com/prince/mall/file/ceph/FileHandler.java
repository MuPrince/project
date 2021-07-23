package com.prince.mall.file.ceph;

import org.javaswift.joss.model.Container;
import org.javaswift.joss.model.StoredObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project mall <br\>
 * Package com.prince.mall.file.ceph <br\>
 * <p>
 * Description : ceph文件操作 <br\>
 *
 * @author StrangePrince <br\>
 * @since 2021/7/7 9:12
 */
@Component
public class FileHandler {

    @Autowired
    private Container container;

    /**
     * 文件上传
     */
    public void upload(String fileName, byte[] buffer) {
        //获取容器
        StoredObject object = container.getObject(fileName);
        object.uploadObject(buffer);
    }

    /**
     * 文件下载
     */
    public byte[] download(String fileName) {
        //获取容器
        StoredObject object = container.getObject(fileName);
        return object.downloadObject();
    }
}
