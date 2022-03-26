package com.jn.arcade.entity;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class ArcadeMachine {

	// Auto generates ID and puts it into ID column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Name has to be a String and unique
	@Column(unique = true, nullable = false)
	private String name;

	@Column(nullable = false)
	private String publisher;

	@Column
	private String developer;

	@Column
	private String genre;

	@Column
	private double purchaseCost;

	@Column
	private double costToPlay;

	// Default Constructor
	public ArcadeMachine() {
	}

	// Constructor without ID
	public ArcadeMachine(String name, String publisher, String developer, String genre, double purchaseCost,
			double costToPlay) {
		this.name = name;
		this.publisher = publisher;
		this.developer = developer;
		this.genre = genre;
		this.purchaseCost = purchaseCost;
		this.costToPlay = costToPlay;
	}

	// Constructor with ID
	public ArcadeMachine(long id, String name, String publisher, String developer, String genre, double purchaseCost,
			double costToPlay) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.developer = developer;
		this.genre = genre;
		this.purchaseCost = purchaseCost;
		this.costToPlay = costToPlay;
	}

	// Getters and Setters
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getDeveloper() {
		return developer;
	}
	
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public double getPuchaseCost() {
		return purchaseCost;
	}
	
	public void setPuchaseCost(double purchaseCost) {
		this.purchaseCost = purchaseCost;
	}
	
	public double getCostToPlay() {
		return costToPlay;
	}
	
	public void setCostToPlay(double costToPlay) {
		this.costToPlay = costToPlay;
	}
	
	// End of Getters and Setters

	@Override
	public String toString() {
		return "\n"
				+ "ArcadeMachine ID: " + id + "\n"
				+ "Name: " + name + "\n"
				+ "Publisher: " + publisher + "\n"
				+ "Developer: " + developer + "\n"
				+ "Genre: " + genre + "\n"
				+ "Purchase Cost: " + purchaseCost + "\n"
				+ "Cost To Play: " + costToPlay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costToPlay, developer, genre, name, publisher, purchaseCost);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArcadeMachine other = (ArcadeMachine) obj;
		return Double.doubleToLongBits(costToPlay) == Double.doubleToLongBits(other.costToPlay)
				&& Objects.equals(developer, other.developer) && Objects.equals(genre, other.genre)
				&& Objects.equals(name, other.name) && Objects.equals(publisher, other.publisher)
				&& Double.doubleToLongBits(purchaseCost) == Double.doubleToLongBits(other.purchaseCost);
	}
}