package com.tx.saveWorld.common.enums;

/**
 * Created by tangxi on 2018/2/8.
 */
public enum CacheKeyEnum implements EnumCode<String>{
    ORDER("order","订单缓存");

    private final String code; // 枚举值
    private final String desc; // 说明
    CacheKeyEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    public static String buildKey(String pre,Object keyObject){
        if(keyObject == null){
            return pre;
        }
        return pre + "_" + String.valueOf(keyObject);
    }

    public static String buildKeys(String pre,Object... keyObject){
        if(keyObject == null){
            return pre;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(pre);
        for(Object object : keyObject){
            stringBuffer.append("_").append(String.valueOf(object));
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        // 获取key对应的枚举
        System.out.println(EnumCode.Parser.parseTo(CacheKeyEnum.class,CacheKeyEnum.ORDER.getCode()));
    }
}
