package com.experis.ventaapp.rest;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Message {
	private Integer code;
	private String  message;
}
