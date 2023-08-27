package jdbc.sungJuk;

public interface SungJukDAO {



    // DAO : Data Access Object
    // DB의 데이터에 접근하여 데이터를 처리하는 객체

    // 학생 성적 정보를 insert 하는 기능
    public void sungJukInsert();

    // 전체학생 성적을 DB에서 얻어와(select) 성적정보를 출력해주는 기능
    public void sungJukList();

    // idCode를 입력받아 해당 학생의 성적 정보를 출력하는 기능
    public void sungJukInfo();

    // idCode, 국어점수, 영어점수, 수학점수를 입력받아
    // 해당학생의 성적정보를 수정하는 기능 (update)
    public void sungJukUpdate();

    // idCode를 입력받아 해당 학생 성적정보를 삭제하는 기능 (delete)
    public void sungJukDelete();


}