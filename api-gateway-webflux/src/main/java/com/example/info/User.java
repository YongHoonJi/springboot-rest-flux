package com.example.info;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
public class User {
	@ApiModelProperty(required = true, notes = "user name")
	private String name;
	@ApiModelProperty(required = true, notes = "user email")
	private String email;
}
