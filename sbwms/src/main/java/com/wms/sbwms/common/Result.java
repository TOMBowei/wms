package com.wms.sbwms.common;

import lombok.Data;

@Data
public class Result {
    private int code; //编码 200/400
    private String msg; //成功/失败
    private Long total; //总记录数
    private Object data; //数据
//    private String name; //姓名
//    private String password; //密码

    public static Result fail(){
        return result(400, "失败", 0L, null);
    }
    public static Result fail(String name){
        return result(400, "已经存在该用户", 0L, null);
    }
    public static Result fail(String name, String password){
        return result(400, "缺少用户名或密码", 0L, null);
    }
    public static Result success(){
        return result(200, "成功", 0L, null);
    }
    public static Result success(Object data){
        return result(200, "成功", 0L, data);
    }
    public static Result success(Long total, Object data){
            return result(200, "成功", total, data);
    }

    private static Result result(int code, String msg, Long total, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setTotal(total);
        result.setData(data);
        return result;
    }
}
