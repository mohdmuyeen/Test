package com.demo.day2.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.day2.spring.entity.Emp;

@Repository
public class EmployeeImp implements EmpDao {

	@Autowired
	JdbcTemplate jt;

	@Override
	public String save(Emp e) {
		// TODO Auto-generated method stub

		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pst = conn
						.prepareStatement("insert into emp(empno,name,address,salary) " + "values(?,?,?,?)");
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());

				return pst;
			}
		});

		if (count == 1) {
			return "emp saved";
		} else {
			return "save failed";
		}
	}

	@Override
	public String delete(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findById(int id) {
		Emp e = null;
		try {
			e = jt.queryForObject("select * from emp where empno=" + id, new RowMapper<Emp>() {

				@Override
				public Emp mapRow(ResultSet rs, int index) throws SQLException {
					return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
							rs.getDouble("SALARY"));
				}
			});

		} catch (EmptyResultDataAccessException ex) {
			ex.printStackTrace();
			e = null;
		}
		return e;
	}

	@Override
	public List<Emp> getAll() {
		List<Emp> emplist = jt.query("Select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int index) throws SQLException {
				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
			}
		});

		return emplist;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String saveSome(List<Emp> emps) {
		
		for(Emp e:emps){
			save(e);
		}
		return  "Saved Sucessfully";
	}

}
