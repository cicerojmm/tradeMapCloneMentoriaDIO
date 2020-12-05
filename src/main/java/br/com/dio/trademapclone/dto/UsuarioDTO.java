package br.com.dio.trademapclone.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class UsuarioDTO {

	private String login;
	private String senha;
	private String email;
	private String nome;
	private List<AcaoFavoritaDTO> acoesFavoritas;
	private Boolean ativo;

}
