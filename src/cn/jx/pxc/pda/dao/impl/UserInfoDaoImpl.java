/**
 * 
 */
package cn.jx.pxc.pda.dao.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import cn.jx.pxc.pda.dao.UserInfoDao;
import cn.jx.pxc.pda.entity.AdminInfo;
import cn.jx.pxc.pda.entity.UserInfo;

/**
 *<p> Title:  UserInfoDaoImpl.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.dao.impl
 * @author    黄信胜
 * @date      2019年3月22日下午12:15:20
 * @version 版本号
 */
@Repository
@SuppressWarnings("all")
public class UserInfoDaoImpl extends BaseDaoHibernate implements UserInfoDao {

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.UserInfoDao#selectUser(java.lang.String, java.lang.String)
	 */
	@Override
	public UserInfo selectUser(String username, String password) throws Exception {
		List<AdminInfo> adminList = (List<AdminInfo>) this.getHibernateTemplate().find("from AdminInfo where name=? and password=?", username,password);
		if (adminList != null && adminList.size() > 0) {
			UserInfo user = new UserInfo();
			BeanUtils.copyProperties(adminList.get(0), user);
			System.out.println(user);
			return user;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.UserInfoDao#selectAllUser()
	 */
	@Override
	public List<UserInfo> selectAllUser() throws Exception {
		List<UserInfo> userList = (List<UserInfo>) this.getHibernateTemplate().find("from UserInfo");
		return userList;
	}

	/* (non-Javadoc)
	 * @see cn.jx.pxc.pda.dao.UserInfoDao#modifyPasswod(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public Boolean modifyPasswod(String oldPw, String newPw, Integer uid) throws Exception {
		List<AdminInfo> adminList = (List<AdminInfo>) this.getHibernateTemplate().find("from AdminInfo where id=?", uid);
		adminList.get(0).setPassword(newPw);
		this.getHibernateTemplate().update(adminList.get(0));
		return true;
		
	}
	
	
}
