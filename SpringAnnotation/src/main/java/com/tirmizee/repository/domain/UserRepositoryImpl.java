package com.tirmizee.repository.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.entities.User;

/**
 * @author tirmizee
 *
 */
@Repository("UserRepository")
public class UserRepositoryImpl extends AbstractJdbcRepository<User, Long> implements UserRepository {
	
	public UserRepositoryImpl() {
		this(T_USER);
	}

	public UserRepositoryImpl(String tableName) {
		super(MAPPER, UNMAPPER, tableName, C_ID);
	}
	
	public static final RowMapper<User> MAPPER = new RowMapper<User>() {
		
		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			return new User(
					rs.getLong(C_ID),
					rs.getString(C_USERNAME),
					rs.getString(C_PASSWORD),
					rs.getString(C_FIRSTNAME),
					rs.getString(LASTNAME),
					rs.getString(STATUS),
					rs.getDate(CREATE_DATE),
					rs.getDate(UPDATE_DATE));
		}
	};
	
	public static final RowUnmapper<User> UNMAPPER  = new RowUnmapper<User>() {
		
		@Override
		public Map<String, Object> mapColumns(User param) {
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put(C_ID, param.getId());
			map.put(C_USERNAME, param.getUsername());
			map.put(C_PASSWORD, param.getPassword());
			map.put(C_FIRSTNAME, param.getFirstname());
			map.put(LASTNAME, param.getLastname());
			map.put(STATUS, param.getStatus());
			map.put(CREATE_DATE, param.getCreate_date());
			map.put(UPDATE_DATE, param.getUpdate_date());
			return map;
		}
	};

	@Override
	protected <S extends User> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.longValue());
		return entity;
	}

}
