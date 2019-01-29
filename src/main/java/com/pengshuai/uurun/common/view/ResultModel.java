package com.pengshuai.uurun.common.view;

import com.pengshuai.uurun.common.constants.Constants;
import com.pengshuai.uurun.common.utils.DateUtil;

import java.util.Date;

/**
 * Created by YangPeng on 2018/12/8.
 */
public class ResultModel {
    private Boolean success;
    private String message;
    private Object data;
    private String time;

    public ResultModel(){

    }

    public ResultModel(Object data){
        this.success = Boolean.valueOf(true);
        this.time = DateUtil.formatDate(new Date(), Constants.DATE_PATTERN.yyyy_MM_dd_HH_mm_ss2);
        this.data = data;
    }

    public ResultModel(Object data,String message){
        this.success = Boolean.valueOf(true);
        this.time = DateUtil.formatDate(new Date(), Constants.DATE_PATTERN.yyyy_MM_dd_HH_mm_ss2);
        this.data = data;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
