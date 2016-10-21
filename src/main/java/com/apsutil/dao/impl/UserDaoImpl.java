package com.apsutil.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.apsutil.dao.AbstractDao;
import com.apsutil.dao.UserDao;
import com.apsutil.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		 return getByKey(id);
	}

	@Override
	public User findByUserName(String userName) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("userName", userName));
        return (User) crit.uniqueResult();
	}

	@Override
	public List<String> findRoleByUserName(String userName) {
		String sql ="SELECT roleName FROM roles r,users u,user_roles ur WHERE r.roleid=ur.roleid AND ur.userid=u.userid AND u.username='"+userName+"'";
		Session sesion = getSession();
		return sesion.createSQLQuery(sql).list();
	}

}
