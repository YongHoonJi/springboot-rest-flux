package com.example.repository;

import static com.example.dto.Tables.USER;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.tables.records.UserRecord;;

@Repository
public class UserRepository {
	
	private DSLContext dsl;
	
	@Autowired
	public UserRepository(DSLContext dsl) {
		this.dsl = dsl;
	}
	
	@Transactional(readOnly = true)
	public UserRecord getUser(int id) {
		return dsl.selectFrom(USER).where(USER.ID.eq(id)).fetchSingle();
	}

}
