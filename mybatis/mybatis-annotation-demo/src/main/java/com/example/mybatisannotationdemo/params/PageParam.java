package com.example.mybatisannotationdemo.params;

import lombok.Data;

/**
 * @author Lenovo
 */
@Data
public class PageParam {
    private Integer beginLine;
    private Integer pageSize = 3;
    private Integer currentPage = 0;
    public int getBeginLine(){
        return pageSize * currentPage;
    }
}
