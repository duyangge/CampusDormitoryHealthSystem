package cn.jx.pxc.pda.interceptor;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import cn.jx.pxc.pda.entity.*;


/**
 * @author 黄信胜
 * @date 2018年11月20日下午8:39:17
 * @version 版本号
 */
/**
 *<p> Title:  LoginInterceptor.java</p>
 *<p> Description:  登陆拦截器</p>
 * @package   cn.jx.pxc.shoppingweb.interceptor
 * @author    黄信胜
 * @date      2019年1月4日下午2:25:52
 * @version 19.01.04
 */
@SuppressWarnings("all")
public class LoginInterceptor extends MethodFilterInterceptor {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * 1.创建过滤类，继承methodFilterIntercepror，并重写doInterceptor的方法
	 * 2.配置action和拦截器的关系（注册拦截器）
	 * @see com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("userInfo");
		if (userInfo !=null) {
			return invocation.invoke();
		} else {
		   ServletActionContext.getRequest().setAttribute("loginInfo", "*请先登录");
		   return "login";
		}
	}

}
