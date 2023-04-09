package semi.Project.muktopia.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyRenamePolicy implements FileRenamePolicy{
	@Override
	public File rename(File originalFile) {
		long currentTime = System.currentTimeMillis();
		//1970년 1월 1일 오전 9시부터 현재 시간까지의 경과한 ms를 반환.
		//보통 관례다.
		//이미지의 파일명을 설정하는 방법이다.
		SimpleDateFormat ft = new SimpleDateFormat("YYYYMMDDHHmmss");
		
		int ranNum = (int)(Math.random()*100000);
		String str = "_" + String.format("%05d", ranNum);
		//String.format() 문자열 지정된 패턴의 형식으로 변경하는 메소드
		//$05d 오른쪽 정렬된 십진 정수 (d) 5자리 형태로 변경, 빈자리는0.
	
		//파일 명을 변경해도 확장자를 유지하기 위하여
		//별도로 확장자명 가져오기
		String name = originalFile.getName();//파일이름.
		String ext = null;//확장자
		
		int dot = name.lastIndexOf(".");
		if(dot != -1) {
			//dot 포함해서 확장자 추출.
			ext = name.substring(dot);
		}else {
			ext = "";
		}
		String fileName = ft.format(new Date(currentTime))+ str + ext;
		
		File newFile = new File(originalFile.getParent(), fileName);
		//경로명 문자열을 반환 or 부모디렉토리의 이름을 지정하지 않으면 null 반환.
		return newFile;
	}
}
