package com.kaishengit.util;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Named;
import java.util.Map;

/**
 * Created by qiyawei on 2016/5/4.
 */
@Named
public class UploadQiniuUtil {



    @Value("${qiniu.ak}")
    private String ak;
    @Value("${qiniu.sk}")
    private String sk;
    @Value("${qiniu.bucket}")
    private String bucket;
    @Value("${qiniu.domain}")
    private String domain;

    public String upload() {

        Auth auth = Auth.create("sGxR6n5CfLUZuMrpw1ilQm79pvIRqUZQ5h1gqSwF", "yNIN4pNkMCd-MHAPHVqZ3LxcvlUuO-4-GM9ZQiit");
        String uploadToken = auth.uploadToken("kaishengitdemo");
        return uploadToken;
    }
}
