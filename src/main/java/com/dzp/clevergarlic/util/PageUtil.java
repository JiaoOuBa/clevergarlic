package com.dzp.clevergarlic.util;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 自定义分页工具
 * @Auther ck
 * @Date 2020/7/2 13:38
 * @Desc
 */
public class PageUtil<T> {

    @ApiModelProperty(value = "当前页")
    private int currentPage = 1;

    @ApiModelProperty(value = "每页记录数")
    private int pageSize = 10;

    @ApiModelProperty(value = "总条数")
    private long totalNum;

    @ApiModelProperty(value = "总页数")
    private long totalPage;

    @ApiModelProperty(value = "是否为第一页")
    private boolean firstPage = false;

    @ApiModelProperty(value = "是否为最后一页")
    private boolean lastPage = false;

    @ApiModelProperty(value = "返回结果")
    private List<T> data;

    public PageUtil() {
        super();
    }

    /**
     * 获取最终分页结果
     * @param pageInfo 原生分页结果
     * @return 最终结果PageUtil<T>
     */
    public PageUtil (PageInfo<T> pageInfo) {

        this.currentPage = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.totalNum = pageInfo.getTotal();
        this.totalPage = pageInfo.getPages();
        this.firstPage = pageInfo.isIsFirstPage();
        this.lastPage = pageInfo.isIsLastPage();
        this.data = pageInfo.getList();

    }


    public PageUtil(int currentPage, int pageSize, long totalNum, long totalPage, boolean firstPage, boolean lastPage, List<T> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = totalPage;
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.data = data;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }


    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }
}
