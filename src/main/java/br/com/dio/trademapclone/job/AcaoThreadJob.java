package br.com.dio.trademapclone.job;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dio.trademapclone.modelo.AcaoFavorita;
import br.com.dio.trademapclone.service.IAcaoService;
import br.com.dio.trademapclone.service.impl.AcaoFavoritaService;
import br.com.dio.trademapclone.utils.LogUtil;

@Component
public class AcaoThreadJob implements DisposableBean, Runnable {

	@Autowired
	private IAcaoService acaoB3Service;

	@Autowired
	private AcaoFavoritaService acaoFavoritaService;

	private Thread thread;
	private boolean someCondition;

	AcaoThreadJob() {
		this.thread = new Thread(this);
		this.thread.start();
		someCondition = true;
	}

	@Override
	public void run() {
		while (someCondition) {
			try {
				Thread.sleep(10000);
				// Poderia ser consultado em um banco em memória para ser mais rápido
				List<AcaoFavorita> listaAcoes = acaoFavoritaService.listarSemDuplicidade();

				for (AcaoFavorita acaoFavorita : listaAcoes) {
					acaoB3Service.atualizarValorAcao(acaoFavorita.getCodigo());
				}
			} catch (InterruptedException e) {
				LogUtil.error(e);
			}
		}
	}

	@Override
	public void destroy() {
		someCondition = false;
	}

}
