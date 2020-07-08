package com.dzp.clevergarlic.dto.admin;

import io.swagger.annotations.ApiModelProperty;

/**
 * 列表分页请求实体基类
 * @Auther ck
 * @Date 2020/7/2 13:45
 * @Desc
 */
public class ListToPageRequest {

    @ApiModelProperty(value = "页码，默认1")
    private Integer page = 1;

    @ApiModelProperty(value = "每页记录数，默认10")
    private Integer pageSize = 10;

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
}
