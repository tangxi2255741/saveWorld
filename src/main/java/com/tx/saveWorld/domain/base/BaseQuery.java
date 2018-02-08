/*
 * Copyright (c) 2014 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都云平台所有,未经许可不得任意复制与传播.
 */
package com.tx.saveWorld.domain.base;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 基础查询类
 *
 * @author J-ONE
 * @since 2014-09-19
 */
public class BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient Integer startIndex;// 开始索引

    private transient Integer endIndex;// 结束索引

    private transient String orderField;// 排序字段

    private transient String orderFieldType;// 排序字段类型

    private transient Map<String, Object> queryData;// 查询扩展

    private transient String keyword;// 关键则查询

    /**
     * 查询条件-开始时间
     */
    private Date createStartTime;

    /**
     * 查询条件-结束时间
     */
    private Date createEndTime;

    /**
     * 修改开始时间
     */
    private Date modifyStartTime;

    /**
     * 修改结束时间
     */
    private Date modifyEndTime;
}
