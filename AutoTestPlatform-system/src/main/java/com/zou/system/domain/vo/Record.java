package com.zou.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zou.common.annotation.Excel;
import java.util.Date;

/** 分布记录 */
public record Record(String name, int sum) {
    public static void main(String[] args){
        new Record("w",1);
    }
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
