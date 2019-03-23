/**
 * 
 */
package cn.jx.pxc.pda.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jx.pxc.pda.dao.*;
import cn.jx.pxc.pda.entity.*;
import cn.jx.pxc.pda.service.*;

/**
 *<p> Title:  UserInfoServiceImpl.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.service.impl
 * @author    黄信胜
 * @date      2019年3月22日下午12:17:42
 * @version 版本号
 */
@Transactional
@Service
@SuppressWarnings("all")
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoDao userInfoDao;
	
	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.service.UserInfoService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public UserInfo login(String username, String password) throws Exception {
		return userInfoDao.selectUser(username, password);
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.service.UserInfoService#selectAllUser()
	 */
	@Override
	public List<UserInfo> selectAllUser() throws Exception {
		return userInfoDao.selectAllUser();
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.service.UserInfoService#modifyPasswod(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public Boolean modifyPasswod(String oldPw, String newPw, Integer uid) throws Exception {
		// TODO Auto-generated method stub
		if(userInfoDao.modifyPasswod(oldPw, newPw, uid)) {
			return true;
		}
		return false;
	}

}
