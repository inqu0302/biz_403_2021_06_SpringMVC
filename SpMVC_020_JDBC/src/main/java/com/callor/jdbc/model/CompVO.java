package com.callor.jdbc.model;

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
public class CompVO {

	private String cp_code; //CHAR(5)
	private String cp_name;	//VARCHAR(125)
	private String cp_ceo;	//VARCHAR(20)
	private String cp_tel;	//VARCHAR(20)
	private String cp_addr;	//VARCHAR(125)
	private String cp_genre;//nVARCHAR2(30)

}
