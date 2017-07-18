package com.zxc.service;

import java.util.List;

import com.zxc.entity.Message;

import comzxc.dao.MessageDao;

/**
 *列表相关业务的功能
 */
public class ListService {
	public List<Message> queryMessageList(String command, String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	}
}
