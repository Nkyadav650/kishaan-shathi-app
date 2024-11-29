package com.kishan_shathi.model;

import java.util.List;

import lombok.Data;

@Data
public class Response<T> {
	private String status;

	private Integer statusCode;

	private List<T> result;

	private String error;

}
