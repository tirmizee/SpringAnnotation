package com.tirmizee.repository.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.entities.Permission;

@Repository("PermissionRepository")
public class PermissionRepositoryImpl extends AbstractJdbcRepository<Permission, Long> implements PermissionRepository {

	public PermissionRepositoryImpl(){
		this("permission");
	}
	
	public PermissionRepositoryImpl(String tableName) {
		super(MAPPER, UNMAPPER, tableName, "PER_ID");
	}
	
	public static final RowMapper<Permission> MAPPER = new RowMapper<Permission>() {
		
		@Override
		public Permission mapRow(ResultSet rs, int arg1) throws SQLException {
			return new Permission(
					rs.getLong("PER_ID"),
					rs.getString("PER_NAME"),
					rs.getString("PER_DESCRIPTION"),
					rs.getDate("CREATE_DATE"),
					rs.getDate("UPDATE_DATE"));
		}
	};
	
	public static final RowUnmapper<Permission> UNMAPPER = new RowUnmapper<Permission>() {
		
		@Override
		public Map<String, Object> mapColumns(Permission param) {
			Map<String, Object> map = new HashMap<>();
			map.put("PER_ID", param.getId());
			map.put("PER_NAME", param.getName());
			map.put("PER_DESCRIPTION", param.getDescription());
			map.put("CREATE_DATE", param.getCreate_date());
			map.put("UPDATE_DATE", param.getUpdate_date());
			return map;
		}
	};
	
	@Override
	protected <S extends Permission> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.longValue());
		return entity;
	}

	
}
