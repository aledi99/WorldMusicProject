package com.proyectofinal.model;

/**
 * 
 * @author alediaz
 * @version 1.5
 * 
 *          Clase Modelo de los Tags los cuales van a filtrar la aplicación a
 *          los gustos del usuario
 */

public class Tag {

	private String nombreTag; // El nombre del tag tendrá que ir obligado con un "#" al principio.
	private long idTag; // El id del Tag para gestionar los Tags que habrán en la aplicación

	/**
	 * Constructor vacío
	 */
	public Tag() {

	}

	/**
	 * Constructor de la clase Modelo Tag
	 * 
	 * @param nombreTag
	 * @param idTag
	 */
	public Tag(String nombreTag, long idTag) {
		super();
		this.nombreTag = nombreTag;
		this.idTag = idTag;
	}

	// Getters & Setters

	public String getNombreTag() {
		return nombreTag;
	}

	public void setNombreTag(String nombreTag) {
		this.nombreTag = nombreTag;
	}

	public long getIdTag() {
		return idTag;
	}

	public void setIdTag(long idTag) {
		this.idTag = idTag;
	}

	// hashCode

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idTag ^ (idTag >>> 32));
		result = prime * result + ((nombreTag == null) ? 0 : nombreTag.hashCode());
		return result;
	}

	// equals

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (idTag != other.idTag)
			return false;
		if (nombreTag == null) {
			if (other.nombreTag != null)
				return false;
		} else if (!nombreTag.equals(other.nombreTag))
			return false;
		return true;
	}

	// toString()

	@Override
	public String toString() {
		return "Tag ->{nombre del Tag: " + nombreTag + ", id del Tag: " + idTag + "}";
	}

}
