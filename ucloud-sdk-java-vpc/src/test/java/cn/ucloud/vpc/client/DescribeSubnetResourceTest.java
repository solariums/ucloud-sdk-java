package cn.ucloud.vpc.client;

import cn.ucloud.vpc.client.DefaultVPCClient;
import cn.ucloud.vpc.client.VPCClient;
import cn.ucloud.vpc.model.DescribeSubnetResourceParam;
import cn.ucloud.vpc.model.DescribeSubnetResourceResult;
import cn.ucloud.common.pojo.Account;
import cn.ucloud.vpc.pojo.VPCConfig;
import org.junit.Before;
import org.junit.Test;

/**
 * @description:
 * @author: codezhang
 * @date: 2018-09-21 16:51
 **/
public class DescribeSubnetResourceTest {


    private VPCClient client;

    private DescribeSubnetResourceParam param;


    @Before
    public void initData() {
        client = new DefaultVPCClient(new VPCConfig(
                new Account(System.getenv("UcloudPrivateKey"),
                        System.getenv("UcloudPublicKey"))));
        param = new DescribeSubnetResourceParam("cn-bj2","subnet-2kprhq");
        param.setProjectId("org-4nfe1i");
    }

    @Test
    public void describeSubnetResource() {
        try {
            DescribeSubnetResourceResult describeSubnetResourceResult = client.describeSubnetResource(param);
            System.out.println(describeSubnetResourceResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}