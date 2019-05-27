package com.salesianostriana.dam.proyectofinal.model;
/**Clase Model de los Usuarios que estarán registrados en la página
 * @author alediaz
 */

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuario;// El id que gestionará los distintos conciertos que existen en la tienda

	private String nombre, apellidos, nick, correo, direccion, provincia, contrasenya;//Datos de información del usuario
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNac;//Fecha de Nacimiento del usuario
	
	private int codPostal, numDireccion;//El código postal y el número de la dirección en la que reside el usuario
	private boolean usuarioAdmin;//Boolean que identificará si un usuario es Admin (true) o no (false)

}