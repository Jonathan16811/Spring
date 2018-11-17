package br.com.alura.forum.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2303116094396109761L;
	
	@Id
	public String authority;
	
	@Override
	public String getAuthority() {
		return this.authority;
	}

}
