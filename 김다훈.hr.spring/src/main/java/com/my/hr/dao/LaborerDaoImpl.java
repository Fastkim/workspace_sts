package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.hr.dao.map.LaborerMap;
import com.my.hr.domain.Laborer;
import com.my.hr.domain.NoneException;

@Repository
public class LaborerDaoImpl implements LaborerDao {
	@Autowired private LaborerMap laborerMap;
	
	@Override
	public List<Laborer> selectLaborers(){
		return laborerMap.selectLaborers();
	}
	
	@Override
	public Laborer selectLaborer(int laborerId) {
		return laborerMap.selectLaborer(laborerId);
	}
	
	@Override
	public void insertLaborer(Laborer laborer) {
		laborerMap.insertLaborer(laborer);
	}
	
	@Override
	public void updateLaborer(Laborer laborer) {
		laborerMap.updateLaborer(laborer);
	}
	
	@Override
	public void deleteLaborer(int laborerId) {
		Laborer laborer = selectLaborer(laborerId);
		if(laborer != null) laborerMap.deleteLaborer(laborerId);
		else throw new NoneException("해당 노동자가 없습니다.");
	}
}