package com.zxc.service;

import comzxc.dao.MessageDao;

/**
 * 维护相关业务功能
 */
public class MaintainService {
	
	/**
	 * 单条删除
	 */
	public void deleteOne(String id) {
		if(id !=null&&!"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
		
	}
}
