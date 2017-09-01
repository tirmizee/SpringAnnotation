package com.tirmizee.repository.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.entities.User;

@Repository
public class UserRepositoryImpl extends AbstractJdbcRepository<User, Long> implements UserRepository {
	
	public UserRepositoryImpl() {
		this("user");
	}

	public UserRepositoryImpl(String tableName) {
		super(MAPPER, UNMAPPER, tableName, "ID");
	}
	
	public static final RowMapper<User> MAPPER = new RowMapper<User>() {
		
		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			return new User(
					rs.getLong("ID"),
					rs.getString("USERNAME"),
					rs.getString("PASSWORD"),
					rs.getDate("CREATE_DATE"),
					rs.getDate("UPDATE_DATE"));
		}
	};
	
	public static final RowUnmapper<User> UNMAPPER  = new RowUnmapper<User>() {
		
		@Override
		public Map<String, Object> mapColumns(User param) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ID", param.getId());
			map.put("USERNAME", param.getUsername());
			map.put("PASSWORD", param.getPassword());
			map.put("CREATE_DATE", param.getCreate_date());
			map.put("UPDATE_DATE", param.getUpdate_date());
			return map;
		}
	};

	@Override
	protected <S extends User> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.longValue());
		return entity;
	}
	
	

}
