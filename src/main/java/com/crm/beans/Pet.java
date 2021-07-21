package com.crm.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pet_id")
	private int pet_id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "customer_id")
	private Customer owner;

	@Column(name = "pet_name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "pet_type")
	private PetType pet_type;

	@OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "pet")
	private Set<Visit> visits;

	public Pet() {
	}

	public int getPet_id() {
		return pet_id;
	}

	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PetType getPet_type() {
		return pet_type;
	}

	public void setPet_type(PetType pet_type) {
		this.pet_type = pet_type;
	}

	public Set<Visit> getVisits() {

		if (visits == null) {
			visits = new HashSet<>();
		}
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	
	public void add(Visit visit) {
		if(visits == null) {
			visits = new HashSet<Visit>();
		}
		
		visit.setPet(this);
	}

	@Override
	public String toString() {
		return "Pet [pet_id=" + pet_id + ", owner=" + owner + ", name=" + name + ", pet_type=" + pet_type + ", visits="
				+ visits + "]";
	}

}
