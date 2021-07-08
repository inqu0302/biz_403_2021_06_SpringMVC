package com.callor.gallery.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.gallery.model.MemberVO;
import com.callor.gallery.persistance.ext.MemberDao;
import com.callor.gallery.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("memberServiceV1")
public class MemberServiceImplV1 implements MemberService{

	protected final MemberDao mDao;
	
	@Autowired
	public void create_member_table(MemberDao dummy) {
		
		Map<String, String> maps = new HashMap<String, String>();
		
		mDao.create_table(maps);
	}
	
	/*
	 * 1. 회원가입에서 최초로 가입된 member는 ADMIN
	 * 	- 회원 테이블에 데이터가 있는지???
	 * 	- selectAll() method를 사용하여 최초 가입된 member인지 확인
	 * 2. ADMIN 권한을 갖는 최초의 가입자는 level 0
	 * 3. ADMIN 이 아닌 일반 가입자는 기본 level 9
	 * 4. level 6 보다 큰 member는 이미지 보기만 가능
	 * 5. 이미지 등록을 하려면 level이 6보다 작아야 한다.
	 * 6. 최초 가입한 member가 가입승인이 되면 level 6으로 설정
	 * 7. 이미 가입된 member의 m_userid 정보가 JOIN을 통해서 전달되면
	 * 		회원정보를 업데이트 한다
	 */
	@Override
	public MemberVO join(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
		List<MemberVO> members = mDao.selectAll();
		log.debug("Members {}", members.toString());
		
		// member table 에 데이터가 없는 상태
		// 최초 가입신청이 된 상태
		// 최초 가입자는 ADMIN 
		// ADMIN은 lecel이 0 이다
		if(members == null || members.size() < 1) {
			memberVO.setM_level(0);
		}else {
			memberVO.setM_level(9);
		}
		
		mDao.insertOrUpdqte(memberVO);
		
		return memberVO;
	}

	@Override
	public MemberVO update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findById(String m_userid) {
		// TODO Auto-generated method stub
		
		MemberVO memberVO = mDao.findById(m_userid.trim());
		
		if(memberVO == null) {
			// 가입되지 않은 사용자 ID
			log.debug("가입되지 않은 사용자 {}",m_userid);
		} else {
			log.debug("조회한 사용자 정보 {} ",memberVO.toString());
		}
		
		return memberVO;
	}

	@Override
	public MemberVO login(MemberVO memberVO, Model model) {
		// TODO Auto-generated method stub
		
		// 1. memberVO에서 m_userid를 getter 한 후
		// 2. findByid()를 통해 id 조회
		// 3. 만약 결과가 null이면 : 가입되지 않은 ID
		// 4. 결과가 null 이 아니면 
		// 5. 비밀번호 일치 조회
		// 6. 일치하지 않으면 : 비밀번호 오류 로그인 거부
		// 7. 일치하면 로그인 처리
		
		MemberVO findVO = mDao.findById(memberVO.getM_userid());
		if(findVO == null) {
			model.addAttribute("LOGIN_FAIL", "NOT_USERID");
			return null;
		}
		
		// 비밀번호 비교
		if(findVO.getM_password().equals(memberVO.getM_password())) {
			return findVO;
		}
		
		model.addAttribute("LOGIN_FAIL","NEW_PASS");
		
		return null;
	}

}
