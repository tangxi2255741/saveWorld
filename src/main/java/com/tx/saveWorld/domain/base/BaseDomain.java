/*
 * Copyright (c) 2014 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都云平台所有,未经许可不得任意复制与传播.
 */
package com.tx.saveWorld.domain.base;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 领域模型基类(常规公共字段)<br/>
 * 一律使用引用类型
 * @author J-ONE
 * @since 2014-09-19
 */
public class BaseDomain extends BaseQuery {
	private static final Logger logger = LoggerFactory.getLogger(BaseDomain.class);
	
	private static final long serialVersionUID = 1L;
	
	private Long id;// 编号
	
	private String uuid;// 唯一编号
	
	private String code;// 编码
	
	private String remark;// 备注
	
	private Date createDate;// 创建日期
	
	private String createUser;// 创建者
	
	private Date modifyDate;// 最后修改日期
	
	private String modifyUser;// 最后修改者
	
	private Integer isDel;// 是否删除
	
	private String createUserErp;//创建者erp
	
	private String modifyUserErp;//更新者erp

}
