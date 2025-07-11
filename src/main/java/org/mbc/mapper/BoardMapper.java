package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {
	
	//	interface는 Class와 다르게 abstract method로 구성.
	//	abstract method 는 signature만 있으며, {실행문이 없다.} 그래서 ; 로 끝난다.
	
	// 어노테이션으로 간단한 쿼리문은 가능하나, 복잡한 쿼리문은 버그가 좀 있다.
	@Select("SELECT * FROM tbl_board WHERE bno > 0") // bno > 0 이유는 pk로 선언되어 있어서 indexing으로 빠른 추출을 위함.
	public List<BoardVO> getList(); //추상 메서드
	
	// 그래서 xml을 이용하여 sql문 처리를 진행한다.
	// xml을 이용하려면 resources folder 아래쪽에 org폴더 아래 mbc 폴더 아래 mapper 폴더를 만들고
	// 인터페이스와 이름이 같은 xml 파일을 생성한다.
	// src/main/resources .....
	// 이것이 myBatis사용법이다.
	
	public List<BoardVO> getList2();
	// XML을 이용한 쿼리 처리 메퍼용 메서드
	
	
	
	// Create : insert 처리 - 데이터를 삽입하는 쿼리문
	// 1. insert 처리후에 결과 int로 받는 방법
	// 2. pk를 먼저 생성한 후에 insert가 되는 방법
	
	public void insert(BoardVO board); // xml에서 쿼리 작성
	
	public void insertSelectKey(BoardVO board); //xml에서 쿼리 작성
	
	public BoardVO read(Long bno); // xml에서 쿼리 작성
	// 번호가 들어가면 객체로 나온다.
	
	public int delete(Long bno); // xml에서 쿼리 작성
	// 번호가 들어가면 삭제 후 몇개가 됐는지 리턴한다.
	
	public int update(BoardVO board); // xml에서 쿼리 작성
	// 번호가 들어가면 수정 후 몇개가 수정 되었는지 리턴한다.
	
}
