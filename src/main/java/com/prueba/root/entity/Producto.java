package com.prueba.root.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "codigo", unique = true, nullable = false)
	private String codigo;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	@Column(name = "pvp", nullable = false)
	private Double pvp;
	@Column(name = "estado", nullable = false)
	private String estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPvp() {
		return pvp;
	}
	public void setPvp(Double pvp) {
		this.pvp = pvp;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
