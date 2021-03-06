package cn.ucloud.unet.model;

import cn.ucloud.common.annotation.UcloudParam;
import cn.ucloud.common.exception.ValidatorException;
import cn.ucloud.common.pojo.BaseRequestParam;
import cn.ucloud.common.pojo.Param;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 将EIP加入共享带宽 参数类
 * @author: joshua
 * @E-mail: joshua.yin@ucloud.cn
 * @date: 2018/9/27 16:54
 */
public class AssociateEIPWithShareBandwidthParam extends BaseRequestParam {
    /**
     * require 地域
     */
    @NotEmpty(message = "region can not be empty")
    @UcloudParam("Region")
    private String region;

    /**
     * require 共享带宽ID
     */
    @NotEmpty(message = "shareBandwidthId can not be empty")
    @UcloudParam("ShareBandwidthId")
    private String shareBandwidthId;

    /**
     * eipIds EIP的资源Id
     */
    @NotNull(message = "eipIds can not be null")
    private List<String> eipIds;

    @UcloudParam("EIPIds")
    public List<Param> checkEIPIds() throws ValidatorException {
        List<Param> list = new ArrayList<>();
        if (this.getEipIds() != null && !this.getEipIds().isEmpty()) {
            List<String> eipIds = this.getEipIds();
            for (int i = 0, len = eipIds.size(); i < len; i++) {
                String eipId = eipIds.get(i);
                if (StringUtils.isBlank(eipId))
                    throw new ValidatorException("eipId[" + i + "] can not be empty");

                list.add(new Param("EIPIds." + i, eipId));
            }
        }

        return list;
    }

    public AssociateEIPWithShareBandwidthParam(@NotEmpty(message = "region can not be empty") String region,
                                               @NotEmpty(message = "shareBandwidthId can not be empty") String shareBandwidthId,
                                               @NotEmpty(message = "eipIds can not be null") List<String> eipIds) {
        super("AssociateEIPWithShareBandwidth");
        this.region = region;
        this.shareBandwidthId = shareBandwidthId;
        this.eipIds = eipIds;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getShareBandwidthId() {
        return shareBandwidthId;
    }

    public void setShareBandwidthId(String shareBandwidthId) {
        this.shareBandwidthId = shareBandwidthId;
    }

    public List<String> getEipIds() {
        return eipIds;
    }

    public void setEipIds(List<String> eipIds) {
        this.eipIds = eipIds;
    }
}
