/**
 * 
 */
package com.bestgamesreviews.entity;

import java.util.Collection;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Marielle Machael Rudolph
 */
@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name ="moderateur")
public class Moderateur extends Utilisateur{


	private String numeroDetelephone;

	/**
	 * Empty constructor
	 */
	public Moderateur() {
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	/**
	 * pour la création
	 * @param id
	 * @param pseudo
	 * @param motDePasse
	 * @param email
	 */
	public Moderateur( String pseudo, String motDePasse, String email,String numeroDetelephone) {
		super( pseudo, motDePasse, email);
		this.numeroDetelephone = numeroDetelephone;
	}
}
