package com.callor.score.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO {

	private Long sc_seq;		// BIGINT
	private String sc_stnum;	// CHAR(8)
	private String sc_sbcode;	// VARCHAR(20)
	private String sc_sbname;
	private int sc_score;

}
