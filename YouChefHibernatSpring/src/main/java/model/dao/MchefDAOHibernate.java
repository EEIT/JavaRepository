package model.dao;

import java.util.List;

import javax.persistence.Query;

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
	public MchefBean select(MchefBean mc_id) {
		return this.getSession().get(MchefBean.class, mc_id.getMc_id());
	}

	@Override
	public int insert(MchefBean bean) {
		return (int) this.getSession().save(bean);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MchefBean> selectAll() {
		Query query = this.getSession().createQuery("from MchefBean");
		return (List<MchefBean>) query.getResultList();
	}

}
