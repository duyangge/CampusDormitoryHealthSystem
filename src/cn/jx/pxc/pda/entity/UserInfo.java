package cn.jx.pxc.pda.entity;

/**
 *<p> Title:  UserInfo.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.entity
 * @author    黄信胜
 * @date      2019年3月22日上午11:32:12
 * @version 版本号
 */
public class UserInfo {
    private Integer id;

    private String name;

    private String password;

    private String telphone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", password=" + password + ", telphone=" + telphone + "]";
	}
    
}