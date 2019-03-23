package cn.jx.pxc.pda.entity;

/**
 *<p> Title:  ClassInfo.java</p>
 *<p> Description:  班级信息字段</p>
 * @package   com.pxxy.dormitoryassessment.bean
 * @author    admin
 * @date      2019年3月22日上午8:52:04
 * @version 1.0
 */
public class ClassInfo {
    private Integer classId;

    private String className;

    private String classTeacher;

    private String classAcademic;

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}

	public String getClassAcademic() {
		return classAcademic;
	}

	public void setClassAcademic(String classAcademic) {
		this.classAcademic = classAcademic;
	}
    
}