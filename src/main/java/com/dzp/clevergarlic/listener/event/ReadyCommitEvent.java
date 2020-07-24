package com.dzp.clevergarlic.listener.event;

import org.springframework.context.ApplicationEvent;

/**
 * 代办列表生成监听
 * @Auther ck
 * @Date 2020/7/23 15:15
 * @Desc
 */
public class ReadyCommitEvent extends ApplicationEvent {

    /**
     * 计划id
     */
    private String planId;

    /**
     * 类型：1。计划确认，自动生成待办列表信息
     */
    private Integer type;

    /**
     * adminId
     */
    private Long adminId;

    public ReadyCommitEvent(Object source, String planId, Integer type, Long adminId) {
        super(source);
        this.planId = planId;
        this.type = type;
        this.adminId = adminId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
