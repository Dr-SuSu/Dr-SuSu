package com.situ.web.Util;


import com.situ.web.pojo.User;

import java.util.List;

public class PageInfoPlus {
    //当前页的数据
    private List<User> list;//数据
    private Integer pageNumber;//当前第几页
    private Integer pageSize;//每页多少条数据
    private Integer totalPage;//一共多少页

    public PageInfoPlus(List<User> list, Integer pageNumber, Integer pageSize, Integer totalPage) {
        this.list = list;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
    }
    public PageInfoPlus() {
    }

    public List<User> getList() {
        return list;
    }
    public void setList(List<User> list) {
        this.list = list;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

}
