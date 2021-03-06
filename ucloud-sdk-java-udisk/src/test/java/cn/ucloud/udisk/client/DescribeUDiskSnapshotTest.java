package cn.ucloud.udisk.client;

import cn.ucloud.common.handler.UcloudHandler;
import cn.ucloud.common.pojo.Account;
import cn.ucloud.udisk.model.DescribeUDiskSnapshotParam;
import cn.ucloud.udisk.model.DescribeUDiskSnapshotResult;
import cn.ucloud.udisk.pojo.UdiskConfig;
import org.junit.Before;
import org.junit.Test;

/**
 * @description:
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2018/9/26 17:12
 */
public class DescribeUDiskSnapshotTest {
    private UdiskClient client;

    private DescribeUDiskSnapshotParam param;

    @Before
    public void initData() {
        client = new DefaultUdiskClient(new UdiskConfig(
                new Account(System.getenv("UcloudPrivateKey"),
                        System.getenv("UcloudPublicKey"))));
        param = new DescribeUDiskSnapshotParam("cn-sh2");
        param.setProjectId("org-4nfe1i");
    }

    @Test
    public void describeUDiskSnapshot() {
        try {
            DescribeUDiskSnapshotResult result = client.describeUDiskSnapshot(param);
            System.out.println("同步：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void describeUDiskSnapshotCallback() {
        client.describeUDiskSnapshot(param, new UcloudHandler<DescribeUDiskSnapshotResult>() {
            @Override
            public Object success(DescribeUDiskSnapshotResult result) {
                System.out.println("异步 success：" + result);
                return null;
            }

            @Override
            public Object failed(DescribeUDiskSnapshotResult result) {
                System.out.println("异步 failed：" + result);
                return null;
            }

            @Override
            public Object error(Exception e) {
                System.out.println("异步 error：" + e);
                return null;
            }
        }, false);
    }
}
