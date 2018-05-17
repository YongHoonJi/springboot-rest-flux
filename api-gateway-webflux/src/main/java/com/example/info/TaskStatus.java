package com.example.info;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class TaskStatus {
	@ApiModelProperty(required = true, notes = "요청 아이디")
	private long userId;
	@ApiModelProperty(required = true, notes = "작업 아이디")
	private long id;		
	@ApiModelProperty(required = true, notes = "작업 상태")
	private String status;
	@ApiModelProperty(required = true, notes = "작업 상태 코드")
	private String statusCode;	
}
