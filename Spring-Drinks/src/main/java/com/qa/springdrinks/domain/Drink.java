package com.qa.springdrinks.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Drink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Give the drink a name")
	private String name;
	
	@NotNull(message = "Give the drink a year of introduction")
	private String manufacturer;
	
	@NotNull(message = "What year was it introduced?")
	private int yearIntroduced;
	
	@NotNull(message = "Give the drink a volume in ml")
	private int volume;
	
	@NotNull(message = "Is the drink fizzy?")
	private boolean fizzy;
	
	@NotNull(message = "Does the drink contain sugar?")
	private boolean containsSugar;
	
	//Default constructor
	public Drink() {
	}

	//For testing
	public Drink(int id, String name, String manufacturer, int yearIntroduced, int volume, boolean fizzy, boolean containsSugar) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.yearIntroduced = yearIntroduced;
		this.volume = volume;
		this.fizzy = fizzy;
		this.containsSugar = containsSugar;
	}
	//For creating
	public Drink(String name, String manufacturer, int yearIntroduced, int volume, boolean fizzy, boolean containsSugar) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.yearIntroduced = yearIntroduced;
		this.volume = volume;
		this.fizzy = fizzy;
		this.containsSugar = containsSugar;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getYearIntroduced() {
		return yearIntroduced;
	}
	public void setYearIntroduced(int yearIntroduced) {
		this.yearIntroduced = yearIntroduced;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public boolean isFizzy() {
		return fizzy;
	}
	public void setFizzy(boolean fizzy) {
		this.fizzy = fizzy;
	}
	public boolean isContainsSugar() {
		return containsSugar;
	}
	public void setContainsSugar(boolean containsSugar) {
		this.containsSugar = containsSugar;
	}
	@Override
	public int hashCode() {
		return Objects.hash(containsSugar, id, fizzy, manufacturer, name, volume, yearIntroduced);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		return containsSugar == other.containsSugar && id == other.id && fizzy == other.fizzy
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(name, other.name)
				&& volume == other.volume && yearIntroduced == other.yearIntroduced;
	}
}
