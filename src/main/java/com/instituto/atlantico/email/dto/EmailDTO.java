package com.instituto.atlantico.email.dto;

import java.io.Serializable;

public class EmailDTO  implements Serializable {
	
	public String idEmail;
	
	public String email;

	public String getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(String idEmail) {
		this.idEmail = idEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
