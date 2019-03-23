/**
 * 
 */
package test.cn.jx.pxc.pda.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jx.pxc.pda.dao.DormitoryScoreDao;
import cn.jx.pxc.pda.entity.AveragedScoreDormitory;
import cn.jx.pxc.pda.entity.DormitoryScoreInfo;
import cn.jx.pxc.pda.service.DormitoryScoreService;

/**
 *<p> Title:  DormitoryScoreTest.java</p>
 *<p> Description:  描述</p>
 * @package   test.cn.jx.pxc.pda.entity
 * @author    黄信胜
 * @date      2019年3月22日下午3:20:52
 * @version 版本号
 */
@SuppressWarnings("all")
public class DormitoryScoreTest {
	
	/**
	 * 测试显示所有的寝室分数
	 * @throws Exception
	 */
	@Test
	public void TestSelectDormitoryScore() throws Exception {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*DormitoryScoreDao di = context.getBean(DormitoryScoreDao.class);
		System.out.println(di.selectDormitoryScore());*/
		DormitoryScoreService dis = context.getBean(DormitoryScoreService.class);
		System.out.println(dis.getAllDormitoryScore());
	}
	
	/**
	 * 测试查询某个寝室分数
	 * @throws Exception
	 */
	@Test
	public void TestSelectOrDormitoryScore() throws Exception {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
	/*	DormitoryScoreDao di = context.getBean(DormitoryScoreDao.class);
		List<DormitoryScoreInfo> list = di.selectConditionDormitoryScore("710");
		System.out.println(list);*/
		DormitoryScoreService dis = context.getBean(DormitoryScoreService.class);
		System.out.println(dis.selectConditionDormitoryScore("710"));
	}
	
	/**
	 * 测试删除某个寝室分数
	 * @throws Exception
	 */
	@Test
	public void TestDeleteDormitoryScore() throws Exception {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*	DormitoryScoreDao di = context.getBean(DormitoryScoreDao.class);
		List<DormitoryScoreInfo> list = di.selectConditionDormitoryScore("710");
		System.out.println(list);*/
		DormitoryScoreService dis = context.getBean(DormitoryScoreService.class);
		if(dis.deleteDormitoryScore(10)) {
			System.out.println("执行成功");
		}else {
			System.out.println("不存在该id");
		}
	}
	
	/**
	 * 测试修改某个寝室分数
	 * @throws Exception
	 */
	@Test
	public void TestUpdateDormitoryScore() throws Exception {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*	DormitoryScoreDao di = context.getBean(DormitoryScoreDao.class);
		List<DormitoryScoreInfo> list = di.selectConditionDormitoryScore("710");
		System.out.println(list);*/
		DormitoryScoreService dis = context.getBean(DormitoryScoreService.class);
		if(dis.updateDormitoryScore(9, 9.6)){
			System.out.println("执行成功");
		}else {
			System.out.println("不存在该id");
		}
	}
	
	/**
	 * 测试添加某个寝室分数
	 * @throws Exception
	 */
	@Test
	public void TestAddDormitoryScore() throws Exception {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		DormitoryScoreService di = context.getBean(DormitoryScoreService.class);
		DormitoryScoreInfo dormitoryScore = new DormitoryScoreInfo();
		dormitoryScore.setId(3);
		dormitoryScore.setScoreUsername("章小军");;
		dormitoryScore.setDormitoryIdScore("19-3-912");
		dormitoryScore.setScoreDate(new Date());
		dormitoryScore.setDormitoryScore(9.7);
		di.addDormitoryScore(dormitoryScore);
		if(di.addDormitoryScore(dormitoryScore)){
			System.out.println("执行成功");
		}else {
			System.out.println("添加失败");
		}
	}
	
	/**
	 * 测试查看所有寝室号
	 * @throws Exception
	 */
	@Test
	public void TestSelecttAllDormitory() throws Exception {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		DormitoryScoreDao di = context.getBean(DormitoryScoreDao.class);
		System.out.println(di.selectAllDormitory());
	}
	
	/**
	 * 测试统计所有寝室号平均分
	 * @throws Exception
	 */
	@Test
	public void TestSumAllDormitory() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1  = null;
		Date d2  = null;
		//这里会有一个异常，所以要用try catch捕获异常
		try {
		     d1  = sdf.parse("2019-03-13");
		     d2  = sdf.parse("2019-03-20");
		     ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
	/*		 DormitoryScoreDao di = context.getBean(DormitoryScoreDao.class);*/
		 	DormitoryScoreService di = context.getBean(DormitoryScoreService.class);
			 List<AveragedScoreDormitory> list = di.calculateAvgScore(d1, d2 );
			 System.out.println(list);
		}catch (Exception e){
		    e.printStackTrace();
		}
	}
}
