package com.example.info;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class JobRequest {
	@ApiModelProperty(required = true, notes = "작업 아이디")
	private long id;	
	@ApiModelProperty(required = true, notes = "요청 아이디")
	private long userId;
	@ApiModelProperty(required = true, notes = "사용자 이메일")
	private String email;
	@ApiModelProperty(required = true, notes = "사용자 이름")
	private String userName;
	@ApiModelProperty(required = true, notes = "파일 이름")
	private String fileName;
	@ApiModelProperty(required = true, notes = "파일 확장자")
	private String fileExtension;
	@ApiModelProperty(required = true, notes = "파일 정보(바이너리)")
	private String fileData;
	@ApiModelProperty(required = true, notes = "작업 요청 일자")
	private Date requestDate;
	@ApiModelProperty(required = true, notes = "작업량")
	private long payload;
	@ApiModelProperty(required = true, notes = "작업량 단위(page or word)")
	private String payloadUnit;
	@ApiModelProperty(required = true, notes = "방향")
	private String direction;
	@ApiModelProperty(required = true, notes = "작업 처리 기한")
	private Date expDate;
	@ApiModelProperty(required = true, notes = "도메인")
	private String domain;
	@ApiModelProperty(required = true, notes = "상품 타입")
	private String productType;
}
