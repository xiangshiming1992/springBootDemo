package com.xsm.demo.common.pageHelper;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageHelper implements Pageable {

    private int pageNum = 1;

    private int pageSize = 20;

    public  PageHelper(){}

    public PageHelper(int pageNum, int pageSize) {
        if(pageNum <= 0){
            this.pageNum = 1;
        }
        else{
            this.pageNum = pageNum;
        }
        this.pageSize = pageSize;
    }

    public void setPageNum(int pageNum) {
        if(pageNum <= 0){
            this.pageNum = 1;
        }
        else{
            this.pageNum = pageNum;
        }
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public int getPageNumber() {
        return this.pageNum;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public int getOffset() {
        return (pageNum-1) * pageSize;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
