package br.com.dio.trademapclone.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.trademapclone.dto.AcaoFavoritaDTO;
import br.com.dio.trademapclone.service.IAcaoFavoritaService;

@RestController
@RequestMapping("/acoes")
public class AcaoFavoritaResource extends ResourceBase<AcaoFavoritaDTO> {

	@Autowired
	private IAcaoFavoritaService acaoFavoritaService;

	@PostMapping("/favorita")
	public ResponseEntity<AcaoFavoritaDTO> salvar(@RequestBody @Valid AcaoFavoritaDTO acaoFavoritaDTO) {
		AcaoFavoritaDTO acaoFavoritaRetorno = acaoFavoritaService.salvar(acaoFavoritaDTO);
		return responderSucessoComItem(acaoFavoritaRetorno);
	}

}
