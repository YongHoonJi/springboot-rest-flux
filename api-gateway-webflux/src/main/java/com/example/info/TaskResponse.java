package com.example.info;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class TaskResponse {
	@ApiModelProperty(required = true, notes = "작업 아이디")
	private long id;	
	@ApiModelProperty(required = true, notes = "요청 아이디")
	private long userId;
	@ApiModelProperty(required = true, notes = "파일 이름")
	private String fileName;
	@ApiModelProperty(required = true, notes = "파일 확장자")
	private String fileExtension;
	@ApiModelProperty(required = true, notes = "번역가 코맨트")
	private String commentByWorker;
	@ApiModelProperty(required = true, notes = "파일 정보(바이너리)")
	private String fileData;	
}