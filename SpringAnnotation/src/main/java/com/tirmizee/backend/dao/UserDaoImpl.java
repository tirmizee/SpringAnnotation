package com.tirmizee.backend.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.tirmizee.backend.user.data.CriteriaUserTable;
import com.tirmizee.backend.user.data.UserTableDto;
import com.tirmizee.jdbcrepository.sql.SqlGenerator;
import com.tirmizee.repository.domain.UserRepository;
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
			.append(SqlGenerator.FROM).append(UserRepository.USER)
			.append(SqlGenerator.WHERE)
			.append(" USERNAME ").append(SqlGenerator.PARAM);
		LOGGER.info(sql);
		
		try {
			return getJdbcOps().queryForObject(sql.toString(), new Object[]{username},MAPPER);
		} catch (EmptyResultDataAccessException e) {
			LOGGER.debug(e.getMessage());
			return null;
		}
	}

	@Override
	public PageImpl<User> findByAllFields(Pageable pageable,CriteriaUserTable criteria) {
		List<Object> params = new LinkedList<Object>();
		StringBuilder select = new StringBuilder()
				.append(SqlGenerator.SELECT)
				.append(" ID ,")
				.append(" USERNAME ,")
				.append(" PASSWORD ,")
				.append(" FIRSTNAME ,")
				.append(" LASTNAME ,")
				.append(" CREATE_DATE ,")
				.append(" UPDATE_DATE ")
				.append(SqlGenerator.FROM)
				.append(" user ")
				.append(SqlGenerator.WHERE)
				.append(" ID IS NOT NULL ");
				if (criteria.getUsername() != null) {
					select.append(SqlGenerator.AND)
					.append(" USERNAME ").append(SqlGenerator.PARAM);
					params.add(StringUtils.trimToEmpty(criteria.getUsername()));
				}
				
				PageImpl<User> page = new PageImpl<User>(getJdbcOps().query(getSqlGenerator().selectAll(select, pageable).toString(), params.toArray(), MAPPER), pageable,count());
				
		return page;
	}

	
	
}
