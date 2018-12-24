package me.zbl.fullstack.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class QiniuController {
    private static Logger logger = LoggerFactory.getLogger(QiniuController.class);

    /**
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "/qiniuUpload", method = RequestMethod.POST)
    @ResponseBody
    public String qiniuUpload(@RequestParam(value = "editormd-image-file", required = false) MultipartFile multipartFile) {
        JSONObject jsonObject = new JSONObject();
        try {
            // 获取文件名
            String fileName = multipartFile.getOriginalFilename();
            // 获取文件后缀
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            // 用uuid作为文件名，防止生成的临时文件重复
            String path = "/tmp/";
            /**
             fileName: 临时文件的名字, 生成后的文件名字将会是【fileName + 随机数】
             suffix： 文件后缀，例如.txt, .tmp
             parentFile: 临时文件目录，如果不指定，则默认把临时文件存储于系统临时文件目录上
             */
            File excelFile = File.createTempFile(fileName, prefix, new File(path));
            // MultipartFile to File
            multipartFile.transferTo(excelFile);
            //上传到七牛上去
            String upload = QiniuUtil.upload(path + excelFile.getName(), fileName);
            //删除本地缓存
            excelFile.delete();
            System.out.println(upload);
            jsonObject.put("success", 1);
            jsonObject.put("message", "上传成功");
            jsonObject.put("url", upload);
        } catch (Exception e) {
            jsonObject.put("success", 0);
        }
        return jsonObject.toJSONString();
    }

}
