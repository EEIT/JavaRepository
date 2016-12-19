package model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service(value = "calendarService")
public class CalendarService {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			CalendarService service = (CalendarService) context.getBean("calendarService");
			
			//Test for MchefInsert
			CalendarBean cb = new CalendarBean();
			MchefBean mb = new MchefBean();
			mb.setMc_id(1006);
			cb.setMchefBean(service.mchefDao.select(mb));
			cb.setDate1(2);
			cb.setDate2(2);
			cb.setTheMonth("201702");
			cb.setMaxNum(5);
			System.out.println(service.mchefInput(cb));
			
			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}
	}
	
	@Autowired
	CalendarDAO calendarDao;
	@Autowired
	MchefDAO mchefDao;
	
	public CalendarBean mchefInput(CalendarBean calendarBean){
		//先確認table裡有沒有這筆資料
		CalendarBean cab = calendarDao.selectMchef(calendarBean.getMchefBean().getMc_id(), calendarBean.getTheMonth());
		if (null == cab) {//選擇insert
			if (calendarDao.insert(calendarBean) > 0)
				return calendarDao.selectMchef(calendarBean.getMchefBean().getMc_id(), calendarBean.getTheMonth());
		}else{//選擇update
			calendarBean.setCal_id(cab.getCal_id());
			CalendarBean cb = calendarDao.update(calendarBean);
			System.out.println("Update : " + cb);
			return cb;
		}
		return null;
	}

}
