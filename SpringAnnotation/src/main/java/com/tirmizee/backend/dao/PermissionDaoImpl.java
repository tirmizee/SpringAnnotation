package com.tirmizee.backend.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.sql.SqlGenerator;
import com.tirmizee.repository.domain.PermissionRepositoryImpl;
import com.tirmizee.repository.entities.Permission;


/**
 * @author tirmizee
 *
 */
@Repository("PermissionDao")
public class PermissionDaoImpl extends PermissionRepositoryImpl implements PermissionDao {
	
	private static final Logger LOGGER = Logger.getLogger(PermissionDaoImpl.class);

	@Override
	public List<Permission> findByUsername(String username) {
		StringBuilder sql = new StringBuilder();
		sql.append(SqlGenerator.SELECT).append(" permission.* ")
			.append(SqlGenerator.FROM).append(" user ")
			.append(" INNER JOIN ").append(" user_map_per ")
			.append(" ON ").append(" user.ID = user_map_per.FK_USER_ID ")
			.append(" INNER JOIN ").append(" permission ")
			.append(" ON ").append(" user_map_per.FK_PER_ID = permission.PER_ID ")
			.append(SqlGenerator.WHERE).append(" user.USERNAME ").append(SqlGenerator.PARAM);
		LOGGER.info(sql);
		return getJdbcOps().query(sql.toString(), new Object[]{username}, PermissionRepositoryImpl.MAPPER);
	}

}
