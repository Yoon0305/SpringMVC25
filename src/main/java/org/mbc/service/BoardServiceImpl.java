package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service // 이 클래스는 서비스 계층임을 명시.
@AllArgsConstructor // 생성자 자동 주입. (new BoardServiceImpl(mapper);
@Log4j2 //logging 처리를 위한 import
public class BoardServiceImpl implements BoardService {
	// 조원이 실행문을 생성하는 용도로 활용 : implements BoardService (구현 클래스)

	
	
	private BoardMapper mapper; //DB 쿼리용 객체(CRUD)
	
	
	@Override
	public void register(BoardVO board) {
		// 객체가 넘어오면 mapper를 이용해서 DB에 등록하겠다.
		
		log.info("BoardServiceImpl.register메서드 실행............");
		
		mapper.insertSelectKey(board);
		log.info("정상 등록 후 List 출력 테스트.......");
		mapper.getList2();
		
	}

	@Override
	public BoardVO get(Long bno) {
		// 게시물 번호가 들어가면 mapper 의 select 문이 동작해야한다.
		log.info("BoardServiceImpl.get 메서드 실행........"+bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// 프론트에서 객체가 넘어오면 mapper를 통해서 update 쿼리가 실행된다.
		log.info("BoardServiceImpl.modify 메서드 실행.....");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// 프론트에서 번호가 넘어오면 매퍼를 통해서 delete 쿼리가 실행된다.
		
		log.info("BoardServiceImpl.remove메서드 실행....");
		return mapper.delete(bno) ==1;
	}

	@Override
	public List<BoardVO> getList() {
		// getList 메서드가 호출되면 mapper의 getList2()를 호출한다.
		
		log.info("BoardServiceImpl.getList 메서드 실행.........");
		
		return mapper.getList2();
	}
	
	

}
