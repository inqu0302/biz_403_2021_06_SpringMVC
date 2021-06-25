package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;

@Service("ScoreServiceV1")
@RequiredArgsConstructor
public class ScoreServiceImplV1 implements ScoreService{

	protected final ScoreDao scDao;
	
	@Override
	public List<ScoreDTO> selectScore() {
		
		List<ScoreDTO> scList = scDao.selectViewAll();
		
		return scList;
	}

	@Override
	public List<SubjectAndScoreDTO> selectScore(String st_num) {
		
		List<SubjectAndScoreDTO> ssList = scDao.selectSubjectAndScore(st_num);
		
		return ssList;
	}

}
