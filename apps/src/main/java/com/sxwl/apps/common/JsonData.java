package com.sxwl.apps.common;

/**
 * @Description
 * @auther reading
 * @create 2019-06-12 15:34
 */
public class JsonData {
    private boolean state;
    private String  msg;
    private Object obj;
    public static  JsonData success(Object obj  ,String msg ){
        JsonData jsonData=new JsonData();
        jsonData.state=true;
        jsonData.msg=msg;
        jsonData.obj=obj;
        return  jsonData;
    }
    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData();
        jsonData.state=false;
        jsonData.msg = msg;
        return jsonData;
    }

}
