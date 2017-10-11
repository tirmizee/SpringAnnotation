package com.tirmizee.repository.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.jdbcrepository.RowUnmapper;
import com.tirmizee.repository.entities.Geography;

@Repository("GeographyRepository")
public class GeographyRepositoryImpl extends AbstractJdbcRepository<Geography, Long> {
	
	public GeographyRepositoryImpl(){
		this("geography");
	}

	public GeographyRepositoryImpl(String tableName) {
		super(MAPPER, UMAPPER, tableName, "GEO_ID");
	}
	
	public static final RowMapper<Geography> MAPPER = new RowMapper<Geography>() {
		
		@Override
		public Geography mapRow(ResultSet rs, int arg2) throws SQLException {
			return new Geography(rs.getLong("GEO_ID"), rs.getString("GEO_NAME"));
		}
	}; 
	
	private static final RowUnmapper<Geography> UMAPPER = new RowUnmapper<Geography>() {
		
		@Override
		public Map<String, Object> mapColumns(Geography param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put("GEO_ID", param.getId());
			map.put("GEO_NAME", param.getGeoName());
			return map;
		}
	};

}
