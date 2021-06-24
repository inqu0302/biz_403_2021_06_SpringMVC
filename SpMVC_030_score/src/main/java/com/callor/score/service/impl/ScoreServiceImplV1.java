package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;

@Service("ScoreServiceV1")
@RequiredArgsConstructor
public class ScoreServiceImplV1 implements ScoreService{

	protected final ScoreDao scoreDao;
	
	@Override
	public List<ScoreDTO> selectScore() {
		
		List<ScoreDTO> scList = scoreDao.selectViewAll();
		
		return scList;
	}

}
