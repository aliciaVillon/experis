package com.experis.ventaapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTOResponse {
	private com.experis.ventaapp.rest.Message 	message;
	private ClienteDTO 	data;
}
