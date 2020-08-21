package com.dzp.clevergarlic.listener.event;

import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.ParamsUnit;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @Auther ck
 * @Date 2020/8/21 13:28
 * @Desc
 */
public class IntegratedParamEvent extends ApplicationEvent {

    /**
     * 楼宇id
     */
    private String buildingId;
    /**
     * 计划id
     */
    private String planId;
    /**
     * 参数集合
     */
    private List<ParamsUnit> integratedList;
    /**
     * adminId
     */
    private Long adminId;

    public IntegratedParamEvent(Object source,
                                String buildingId,
                                String planId,
                                List<ParamsUnit> integratedList,
                                Long adminId) {
        super(source);
        this.buildingId = buildingId;
        this.planId = planId;
        this.integratedList = integratedList;
        this.adminId = adminId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public List<ParamsUnit> getIntegratedList() {
        return integratedList;
    }

    public void setIntegratedList(List<ParamsUnit> integratedList) {
        this.integratedList = integratedList;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
