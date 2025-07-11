package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;

public interface BoardService {
	// interface는 단독으로 사용할 수 없는 객체 (동작문이 없기 때문)
	// 여기서 선언한 method는 무조건 abstract method로 사용된다.
	// interface를 사용하려면 구현 Class 를만들고 실행문을 넣게 된다.
	// interface를 사용하는 이유는 조장이 method명을 강제로 셋팅하기 위함이다.
	
	public void register(BoardVO boardVO); // 조장이 만든 method 명 (Signature)
	// 게시판 등록용 method
	
	
	public BoardVO get(Long bno);
	// 게시글 자세히 보기 (번호를 넣으면 객체가 나와야 한다.)
	
	public boolean modify(BoardVO board);
	// 게시글 수정하기 (객체가 들어가서 수정이 되었는지 t/f)
	
	public boolean remove(Long bno);
	// 게시글 삭제하기 (번호가 들어가서 삭제가 되었는지 t/f)
	
	public List<BoardVO> getList();
	// 이 메서드가 호출되면 List 타입으로 BoardVO 객체들이 넘어온다.
	// List : 동적 List / <>  generic : 강제로 객체 타입을 정함.
	
	
}
