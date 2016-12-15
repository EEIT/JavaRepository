package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MchefBean;
import model.MchefDAO;

@Repository(value="mchefDao")
public class MchefDAOHibernate implements MchefDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public MchefBean select(Integer mc_id) {
		return this.getSession().get(MchefBean.class, mc_id);
	}

	@Override
	public boolean insert(MchefBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
