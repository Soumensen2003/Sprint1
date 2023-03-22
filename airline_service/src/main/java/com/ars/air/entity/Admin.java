package com.ars.air.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Admin extends User{
@Column(name="admin_name",length=50)
private String aName;
@Column(name="admin_email",length=50)
private String email;
}
