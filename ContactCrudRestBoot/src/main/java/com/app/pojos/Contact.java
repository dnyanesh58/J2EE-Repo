package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
@Table(name="contact_db")
public class Contact extends BaseEntity
{
	@JsonProperty("name")
	@Column(length = 20)
	private String name;
	@JsonProperty("email")
	@Column(length = 40)
	private String email;
	@JsonProperty("contact")
	@Column(length = 10)
	private String contact;
}
