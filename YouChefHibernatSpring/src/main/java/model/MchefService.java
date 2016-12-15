package model;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service(value="mchefService")
public class MchefService {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		try {
			sessionFactory.getCurrentSession().beginTransaction();

			MchefService service = (MchefService) context.getBean("mchefService");
			
			//test for apply
//			MchefBean bean = new MchefBean();
//			bean.setMc_id(1004);
//			bean.setYears(8);
//			bean.setVenue("新北市五股區");
//			bean.setQuota(10);
//			bean.setBackground("13年掌廚資歷，擅長台式宴客料理。");
////			VenueBean vb = new VenueBean();
////			vb.setV_id(0);
////			bean.setV_id(vb);
//			bean.setHasPlace("0");
////			MemberBean mb = new MemberBean();
////			mb.setM_id(1001);
//			System.out.println("beans=" + service.apply(bean));
			
			//test for selectAll
			System.out.println(service.selectAll());

			sessionFactory.getCurrentSession().getTransaction().commit();
		} finally {
			sessionFactory.close();
			((ConfigurableApplicationContext) context).close();
		}
	}
	
	@Autowired
	private MchefDAO mchefDao;

	public boolean apply(MchefBean bean) {
		boolean b = false;
//		System.out.println(mchefDao.select(bean).getMemberBean().getAddress());
//		System.out.println("insert:" + mchefDao.insert(bean));
		if(null == mchefDao.select(bean)){
			if(mchefDao.insert(bean) > 0)
				b = true;
		}
		System.out.println("apply result is " + b);
		return b;
	}
	
	public List<MchefBean> selectAll(){
		List<MchefBean> list = mchefDao.selectAll();
		return list;
	}

}
