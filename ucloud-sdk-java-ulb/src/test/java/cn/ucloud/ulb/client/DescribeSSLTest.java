package cn.ucloud.ulb.client;

import cn.ucloud.common.pojo.Account;
import cn.ucloud.ulb.model.DescribeSSLParam;
import cn.ucloud.ulb.model.DescribeSSLResult;
import cn.ucloud.ulb.pojo.ULBConfig;
import org.junit.Before;
import org.junit.Test;

/**
 * @description:
 * @author: codezhang
 * @date: 2018-09-20 19:12
 **/
public class DescribeSSLTest {

    private ULBClient client;

    private DescribeSSLParam param;

    @Before
    public void initData() {
        client = new DefaultULBClient(new ULBConfig(
                new Account(System.getenv("UcloudPrivateKey"),
                        System.getenv("UcloudPublicKey"))));
        param = new DescribeSSLParam("cn-bj2");
        param.setProjectId("org-4nfe1i");
    }


    @Test
    public void describeSSL() {
        try {
            DescribeSSLResult describeSSLResult = client.describeSSL(param);
            System.out.println(describeSSLResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}