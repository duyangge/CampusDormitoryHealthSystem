/**
 * 
 */
package test.cn.jx.pxc.pda.entity;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jx.pxc.pda.dao.DormitoryScoreDao;
import cn.jx.pxc.pda.entity.*;
import cn.jx.pxc.pda.service.*;
/**
 *<p> Title:  UserInfoTest.java</p>
 *<p> Description:  描述</p>
 * @package   test.cn.jx.pxc.pda.entity
 * @author    黄信胜
 * @date      2019年3月22日下午12:23:48
 * @version 版本号
 */
@SuppressWarnings("all")
public class UserInfoTest {
	
	/**
	 * 测试登录
	 * @throws Exception
	 */
	@Test
	public void TestSelectUser() throws Exception {
	
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*UserInfoDao ud = context.getBean(UserInfoDao.class);
		UserInfo u = ud.selectUser("章小军", "123");*/
		UserInfoService ud = context.getBean(UserInfoService.class);
		UserInfo u = ud.login("admin", "admin");
		UserInfo u2 = ud.login("章小", "123");
		
		System.out.println(u);
		System.out.println(u2+":u2");
	}
	
}
