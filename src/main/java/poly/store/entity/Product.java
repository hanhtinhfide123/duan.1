package poly.store.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="Products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String name;
	String image;
	Double price;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Createdate")
	Date createDate = new Date();
	Boolean available;
	@ManyToOne
	@JoinColumn(name="Categoryid")
	Category category;
	@ManyToOne
	@JoinColumn(name="Movementid")
	Movement movement;
	@ManyToOne
	@JoinColumn(name="Collectionid")
	Collection collection;
	@ManyToOne
	@JoinColumn(name="Glassid")
	Glass glass;
	@ManyToOne
	@JoinColumn(name="Strapid")
	Strap strap;
	@ManyToOne
	@JoinColumn(name="Waterid")
	Water water;
	@ManyToOne
	@JoinColumn(name="Brandid")
	Brand brand;
	@ManyToOne
	@JoinColumn(name="Genderid")
	Gender gender;

	@JsonIgnore
	@OneToMany(mappedBy ="product")
	List<OrderDetail> orderDetails;
	
	
}
