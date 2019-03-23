/**
 * 
 */
package cn.jx.pxc.pda.entity;

/**
 *<p> Title:  ClassAndDormitory.java</p>
 *<p> Description:  描述</p>
 * @package   cn.jx.pxc.pda.entity
 * @author    黄信胜
 * @date      2019年3月22日上午11:27:20
 * @version 版本号
 */
@SuppressWarnings("all")
public class ClassAndDormitory {
	
	private Integer id;
	
	private Integer classId;
	
	private String dormitoryId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getDormitoryId() {
		return dormitoryId;
	}
	public void setDormitoryId(String dormitoryId) {
		this.dormitoryId = dormitoryId;
	}
	
}
