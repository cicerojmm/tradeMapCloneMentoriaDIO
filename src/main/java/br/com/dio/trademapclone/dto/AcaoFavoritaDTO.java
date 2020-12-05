package br.com.dio.trademapclone.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(Include.NON_NULL)
public class AcaoFavoritaDTO {

	@NotBlank
	private String loginUsuario;
	@NotBlank
	private String codigo;
}
