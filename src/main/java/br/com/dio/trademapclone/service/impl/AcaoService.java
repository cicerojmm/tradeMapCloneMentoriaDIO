package br.com.dio.trademapclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.dio.trademapclone.componentes.KafkaProducerComponent;
import br.com.dio.trademapclone.dto.AcaoDTO;
import br.com.dio.trademapclone.service.IAcaoService;

@Service
public class AcaoService implements IAcaoService {

	
	@Value("${api.b3.url-base}")
	private String urlApiBase;

	@Value("${kafka.topico-acao-b3}")
	private String topicoKafkaAcaoB3;

	@Autowired
	private KafkaProducerComponent kafkaProducerComponent;


	public void atualizarValorAcao(String codigoAcao) {
		Gson gson = new Gson();
		RestTemplate restTemplate = new RestTemplate();
		String json = restTemplate.getForObject(criarUrlConsultaAcao(codigoAcao), String.class);
		AcaoDTO acaoB3DTO = gson.fromJson(json, AcaoDTO.class);

		kafkaProducerComponent.sendCustomMessage(acaoB3DTO, topicoKafkaAcaoB3);
	}

	private String criarUrlConsultaAcao(String codigoAcao) {
		return urlApiBase + "/acoes/" + codigoAcao;
	}
}
