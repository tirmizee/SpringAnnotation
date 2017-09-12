package com.tirmizee.backend.dao;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.sql.SqlGenerator;
import com.tirmizee.repository.domain.UserRepositoryImpl;
import com.tirmizee.repository.entities.User;

/**
 * @author tirmizee
 *
 */
@Repository("UserDao")
public class UserDaoImpl extends UserRepositoryImpl implements UserDao {

	private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	
	@Override
	public User findByUsername(String username) {
		StringBuilder sql = new StringBuilder();
		sql.append(SqlGenerator.SELECT).append(" * ")
			.append(SqlGenerator.FROM).append(getTable().getName())
			.append(SqlGenerator.WHERE)
			.append(" USERNAME ").append(SqlGenerator.PARAM);
		LOGGER.info(sql);
		try {
			return getJdbcOps().queryForObject(sql.toString(), new Object[]{username}, UserRepositoryImpl.MAPPER);
		} catch (EmptyResultDataAccessException e) {
			LOGGER.debug(e);
			return null;
		}
	}
	
}
