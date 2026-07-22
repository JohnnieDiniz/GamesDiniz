package com.generation.lojagames.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo nome é obrigatório!")
	@Size(min = 10, max = 100, message = "O campo nome deve ter entre 10 e 100 caracteres!")
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@NotNull(message = "O campo preço é obrigatório!")
	@Digits(integer = 3, fraction = 2, message = "Preço deve ter no máximo 3 dígitos inteiros e 2 decimais")
	@Column(name = "preco", nullable = false)
	private BigDecimal preco;

	@NotBlank(message = "O campo sobre é obrigatório!")
	@Size(min = 50, max = 300, message = "O campo sobre deve ter entre 50 e 300 caracteres!")
	@Column(name = "sobre", nullable = false, length = 300)
	private String sobre;

	@NotBlank(message = "O campo plataforma é obrigatório!")
	@Size(min = 10, max = 50, message = "O campo plataforma deve ter entre 10 e 50 caracteres!")
	@Column(name = "plataforma", nullable = false, length = 50)
	private String plataforma;

	@NotNull(message = "O campo tamanho é obrigatório!")
	@Min(value = 1, message = "O tamanho deve ser de no mínimo 1 GB")
	@Max(value = 500, message = "O tamanho deve ser de no máximo 500 GB")
	@Column(name = "tamanho", nullable = false)
	private Integer tamanho;

	@NotBlank(message = "O campo desenvolvedora é obrigatório!")
	@Size(min = 5, max = 100, message = "O campo desenvolvedora deve ter entre 5 e 100 caracteres!")
	@Column(name = "desenvolvedora", nullable = false, length = 100)
	private String desenvolvedora;

	@NotNull(message = "A categoria é obrigatória!")
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
