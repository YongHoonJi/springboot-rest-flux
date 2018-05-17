package com.example.info;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class TranslationResponse {
	@ApiModelProperty(required = true, notes = "요청 id")
	private Long requestId;	
	
	@ApiModelProperty(required = true, notes = "원문")
	private List<String> org;
	
	@ApiModelProperty(required = true, notes = "번역문")
	private List<String> trn;
	
	@ApiModelProperty(required = true, notes = "방향")
	private String direction;	
	
	@ApiModelProperty(required = true, notes = "타입")
	private String type;
	
	@ApiModelProperty(required = true, notes = "요청일시")
	private Date requestDate;	
	
	@ApiModelProperty(required = true, notes = "처리일시")
	private Date responseDate;		
}
