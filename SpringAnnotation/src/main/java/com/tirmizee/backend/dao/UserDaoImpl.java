package com.tirmizee.backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.backend.service.user.data.CriteriaUser;
import com.tirmizee.backend.service.user.data.UserStatus;
import com.tirmizee.backend.service.user.data.UserTableDto;
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
			.append(SqlGenerator.FROM).append(UserRepository.T_USER)
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
	public PageImpl<UserTableDto> findByAllFields(Pageable pageable,CriteriaUser criteria) {
		List<Object> params = new LinkedList<Object>();
		StringBuilder select = new StringBuilder()
				.append(SqlGenerator.SELECT)
				.append(" ID ,")
				.append(" USERNAME ,")
				.append(" FIRSTNAME ,")
				.append(" LASTNAME ,")
				.append(" STATUS ,")
				.append(" CREATE_DATE ,")
				.append(" UPDATE_DATE ")
				.append(SqlGenerator.FROM)
				.append(" user ")
				.append(SqlGenerator.WHERE)
				.append(" ID IS NOT NULL ");
				if (criteria.getUserName() != null) {
					select.append(SqlGenerator.AND)
					.append(" USERNAME LIKE ?");
					params.add("%" + StringUtils.trimToEmpty(criteria.getUserName()) + "%");
				}
				if (criteria.getFirstName() != null) {
					select.append(SqlGenerator.AND)
					.append(" FIRSTNAME LIKE ?");
					params.add("%" + StringUtils.trimToEmpty(criteria.getFirstName()) + "%");
				}
				if (criteria.getLastName() != null) {
					select.append(SqlGenerator.AND)
					.append(" LASTNAME LIKE ?");
					params.add("%" + StringUtils.trimToEmpty(criteria.getLastName()) + "%");
				}
				if (criteria.getStatus() != null) {
					select.append(SqlGenerator.AND)
					.append(" STATUS = ?");
					params.add(StringUtils.trimToEmpty(criteria.getStatus()));
				}
				long count = count(select.toString(), params.toArray());
				PageImpl<UserTableDto> page = new PageImpl<UserTableDto>(getJdbcOps().query(getSqlGenerator().selectAll(select, pageable).toString(), params.toArray(), USER_TABLE_MAPPER), pageable,count);
		return page;
	}
	
	private static final RowMapper<UserTableDto> USER_TABLE_MAPPER = new RowMapper<UserTableDto>() {
		
		@Override
		public UserTableDto mapRow(ResultSet rs, int arg1) throws SQLException {
			UserTableDto result = new UserTableDto();
			result.setId(rs.getLong(C_ID));
			result.setUsername(rs.getString(C_USERNAME));
			result.setFirstname(rs.getString(C_FIRSTNAME));
			result.setLastname(rs.getString(LASTNAME));
			result.setStatus(rs.getString(STATUS));
			result.setCreate_date(rs.getDate(CREATE_DATE));
			result.setUpdate_date(rs.getDate(UPDATE_DATE));
			return  result;
		}
	};

	@Override
	public boolean updateStatus(UserStatus userStatus) {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new LinkedList<>();
		sql.append("update user set STATUS");
		sql.append(SqlGenerator.PARAM);
		params.add(StringUtils.trimToEmpty(userStatus.getStatus()));
		sql.append(SqlGenerator.WHERE);
		sql.append(" ID ").append(SqlGenerator.PARAM);
		params.add(userStatus.getId());
		return getJdbcOps().update(sql.toString(), params.toArray()) > 0;
	}

	
}
