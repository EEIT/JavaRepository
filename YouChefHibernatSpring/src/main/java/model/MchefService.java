package model;

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
			MchefBean bean = new MchefBean();
			bean.setMc_id(1001);
			System.out.println("beans=" + service.apply(bean));

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
		System.out.println(mchefDao.select(bean.getMc_id()));
//		if(null == mchefDao.select(bean.getMc_id()))
//			b = mchefDao.insert(bean);
		return b;
	}

}
