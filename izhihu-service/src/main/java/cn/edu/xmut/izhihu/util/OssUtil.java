package cn.edu.xmut.izhihu.util;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @Description:
 * @Author: qiuguanlin
 * @Date: 2019-07-02 09:15
 * @Version: 1.0
 */
@Getter
@Setter
@Component
public class OssUtil {

    public static OSSClient client;
    public String accessKeyId;
    public String accessKeySecret;
    public String endpoint;
    public String bucketName;

    public static void main(String[] args) {
        try {
            //String text = "<p><br/><br/>雪纺印花百褶裙半身裙,简约的线条和版型上身很好看，整体更有看点。时尚真皮女凉鞋 牛筋底中跟欧美潮鞋 2015夏个性森系女鞋子罗马鞋。</p><p><img src=\"/manager/plugins/ueditor/jsp/upload1/20160129/99731454031866641.png\"/></p>";
            //String s = OssUtil.uploadTextImg(text);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public OSSClient initClient() {
        if (null == client) {
            ClientConfiguration conf = new ClientConfiguration();
            conf.setConnectionTimeout(5000);
            conf.setMaxErrorRetry(10);
            client = new OSSClient("http://" + endpoint, accessKeyId, accessKeySecret, conf);
        }
        return client;
    }

    /**
     * 上传文件
     */
    public boolean putObjectForInputStream(String fileKey, InputStream content) {
        if (null == fileKey || "" == fileKey.trim())
            return false;
        try {
            initClient();
            ObjectMetadata meta = new ObjectMetadata();
            client.putObject(bucketName, fileKey, content, meta);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 上传图片
     */
    public String putObjectForImage(String imageName, InputStream content, boolean if400) {
        if (null == imageName || "" == imageName.trim())
            return null;
        try {
            String file = "images/" + imageName.substring(0, imageName.indexOf(".")) + "/" + imageName;
            putObjectForInputStream(file, content);
            return "http://" + bucketName + "." + endpoint + "/" + file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getObject(String key) {
        try {
            OSSObject object = client.getObject(bucketName, key);
            InputStream objectContent = object.getObjectContent();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i = -1;
            while ((i = objectContent.read()) != -1) {
                baos.write(i);
            }
            objectContent.close();
            return baos.toString("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}