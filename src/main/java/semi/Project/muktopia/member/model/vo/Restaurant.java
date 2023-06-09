package semi.Project.muktopia.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
	
	private String rest_id;
	private String rest_name;
	private String rest_Addr;
	private String rest_x;
	private String rest_y;
	private String rest_category;
	private String rest_sns;
	private String rest_tel;
	private String rest_time;
	private String rest_img;
	private String rest_contents;
	
	
	public Restaurant(String restId, String restName, String restAddr, String restCategory, String restSns, String restTel,
			String restTime, String restImg, String restContents, String restContents2) {}



}	
