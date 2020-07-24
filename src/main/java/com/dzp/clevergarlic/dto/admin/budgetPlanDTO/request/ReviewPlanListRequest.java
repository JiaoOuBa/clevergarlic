package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther ck
 * @Date 2020/7/23 16:25
 * @Desc
 */
public class ReviewPlanListRequest {

    @ApiModelProperty("页码，默认1")
    private Integer page = 1;

    @ApiModelProperty("每页记录数，默认10")
    private Integer pageSize = 10;

    @ApiModelProperty("预测计划名称")
    private String planName;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
}
