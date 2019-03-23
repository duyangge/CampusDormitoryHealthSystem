/**
 * 
 */
package cn.jx.pxc.pda.service;

import java.util.List;

import cn.jx.pxc.pda.entity.*;

/**
 *<p> Title:  UserInfoService.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.service
 * @author    黄信胜
 * @date      2019年3月22日下午12:17:21
 * @version 版本号
 */
public interface UserInfoService {
	
	/**登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	UserInfo login(String username, String password) throws Exception;
	
	/**查询所有评分用户
	 * @return
	 * @throws Exception
	 */
	List<UserInfo> selectAllUser() throws Exception;
	

	/**修改密码
	 * @param oldPw
	 * @param newPw
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	Boolean modifyPasswod(String oldPw, String newPw,Integer uid) throws Exception;
}
