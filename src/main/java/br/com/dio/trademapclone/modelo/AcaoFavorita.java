package br.com.dio.trademapclone.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude={"usuario"})
@Entity
@Table(name = "ACOES_FAVORITAS")
public class AcaoFavorita extends EntidadeBase {

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "AF_USUARIO_ID", nullable = false)
	private Usuario usuario;

	@Column(name = "AF_CODIGO", nullable = false)
	private String codigo;

}
