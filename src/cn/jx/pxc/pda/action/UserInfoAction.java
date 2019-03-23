/**
 * 
 */
package cn.jx.pxc.pda.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.jx.pxc.pda.entity.UserInfo;
import cn.jx.pxc.pda.service.UserInfoService;

/**
 *<p> Title:  UserInfoAction.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.action
 * @author    黄信胜
 * @date      2019年3月22日下午12:18:06
 * @version 版本号
 */
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class UserInfoAction extends ActionSupport implements ModelDriven<UserInfo>{
	
	
	private String newPass;
	
	
	private String newPassAg;
	
	@Resource
	private UserInfoService userInfoService;
	
	private UserInfo userInfo = new UserInfo();
	
	private ActionContext con = ActionContext.getContext();
	
	@Override
	public UserInfo getModel() {
		return userInfo;
	}
	
	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getNewPassAg() {
		return newPassAg;
	}

	public void setNewPassAg(String newPassAg) {
		this.newPassAg = newPassAg;
	}

	/**登录校验
	 * @return
	 */
	public String login() {
		try {
			UserInfo user = userInfoService.login(userInfo.getName(), userInfo.getPassword());
			if (user != null) {
				con.getSession().put("userInfo",user);
				con.getSession().put("allUserInfo", userInfoService.selectAllUser());
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.getRequest().setAttribute("loginInfo", "***用户名或密码错误！");
		return "login";
	}
	
	/**
	 * 退出
	 * @return
	 */
	public String loginOut() {
		con.getSession().clear();
		return "login";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
	public String modifyPassWord() {
		    UserInfo u = (UserInfo) con.getSession().get("userInfo");
			try {
				if(userInfo.getPassword().equals(u.getPassword())) {
					if(newPass.equals(newPassAg)) {
						userInfoService.modifyPasswod(userInfo.getPassword(), newPass ,u.getId());
						return "login";
					}else {
						ServletActionContext.getRequest().setAttribute("modifyMessage", "两次密码不一致");
					}
			}else {
				ServletActionContext.getRequest().setAttribute("modifyMessage", "原密码错误");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
}
