package com.example.info;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class User {
	@ApiModelProperty(required = true, notes = "user 아이디")
	private long id;
	@ApiModelProperty(required = true, notes = "user 이름")
	private String name;
	@ApiModelProperty(required = true, notes = "user 이메일")
	private String email;
}
