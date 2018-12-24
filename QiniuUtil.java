package me.zbl.fullstack.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class QiniuUtil {
    private static Logger logger = LoggerFactory.getLogger(QiniuUtil.class);
    private static final String bucketName = "blogo";
    private static final String ACCESS_KEY = "BS7dFHFCI9JFdfOTTJ9h9Y8tRGf8cGR35GV5ThTH";
    private static final String SECRET_KEY = "72gzKpJ1U-j-jMFeLmlPy7l2UmSJ7H3Gg0hT-Ce2";
    private static final String DOMAIN = "pk8hectkz.bkt.clouddn.com";
    private static final String style = "imageMogr2/thumbnail/400x400!/format/jpg/blur/1x0/quality/100|watermark/1/image/aHR0cDovLzd4a3YxcS5jb20xLnowLmdsYi5jbG91ZGRuLmNvbS93YXRlcm1hcmsucG5n/dissolve/100/gravity/SouthEast/dx/10/dy/10";

    private static Configuration cdfg = new Configuration(Zone.zone2());
    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    public String getUpToken() {
        return auth.uploadToken(bucketName, null, 3600, new StringMap().put("insertOnly", 1));
    }

    // 普通上传
    public static String upload(String filePath, String fileName) throws IOException {
        // 创建上传对象
        UploadManager uploadManager = new UploadManager(cdfg);
        try {
            // 调用put方法上传
            String token = auth.uploadToken(bucketName);
            Response res = uploadManager.put(filePath, fileName, token);
            // 打印返回的信息
            System.out.println(res.bodyString());
            if (res.isOK()) {
                Ret ret = res.jsonToObject(Ret.class);
                //如果不需要对图片进行样式处理，则使用以下方式即可
                //return DOMAIN + ret.key;
                return "http://"+DOMAIN + "/" + ret.key;
            }
        } catch (QiniuException e) {
            Response r = e.response;
            System.out.println(r.toString());
        }
        return null;
    }

    //base64方式上传
    public String put64image(byte[] base64, String key) throws Exception {
        String file64 = Base64.encodeToString(base64, 0);
        Integer l = base64.length;
        String url = "http://upload.qiniu.com/putb64/" + l + "/key/" + UrlSafeBase64.encodeToString(key);
        //非华东空间需要根据注意事项 1 修改上传域名
        RequestBody rb = RequestBody.create(null, file64);
        Request request = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getUpToken())
                .post(rb).build();
        //System.out.println(request.headers());
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
        System.out.println(response);
        //如果不需要添加图片样式，使用以下方式
        //return DOMAIN + key;
        return DOMAIN + key + "?" + style;
    }


    // 普通删除(暂未使用以下方法，未测试)
    public void delete(String key) throws IOException {
        // 实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(auth, cdfg);
        // 此处的33是去掉：http://ongsua0j7.bkt.clouddn.com/,剩下的key就是图片在七牛云的名称
        key = key.substring(33);
        try {
            // 调用delete方法移动文件
            bucketManager.delete(bucketName, key);
        } catch (QiniuException e) {
            // 捕获异常信息
            Response r = e.response;
            System.out.println(r.toString());
        }
    }

    class Ret {
        public long fsize;
        public String key;
        public String hash;
        public int width;
        public int height;
    }


    public static void main(String[] args) throws IOException {
        String path = "/Users/chengzhengbo/waigong.jpeg964538cf-8711-4985-9db2-0afa802139de7595552833384218650.jpeg";
        String name = "waigong.jpeg";
        String upload = new QiniuUtil().upload(path, name);
        System.out.println(upload);
        System.out.println("完成上传");
    }
}
