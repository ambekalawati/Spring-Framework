package com.sirt.boot.hibernate;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

import lombok.Data;

@Data
@Entity
@Table(name = "collection_mapping")
public class CollectionMapping {
	@Id
	@Column(name = "sid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	@IndexColumn(name="ids")
	@ElementCollection
	@JoinTable(name = "courses_info", joinColumns = @JoinColumn(name = "sid"))
	@Column(name = "courses")
	
	private String[] courses;
	@ElementCollection
	@JoinTable(name = "emails_info", joinColumns = @JoinColumn(name = "sid"))
	@Column(name = "emails")
	private Set<String> emails;
	@ElementCollection
	@JoinTable(name = "phones_info", joinColumns = @JoinColumn(name = "sid"))
	@Column(name = "phones")
	private List<Integer> phones;
	@ElementCollection
	@JoinTable(name = "ref_info", joinColumns = @JoinColumn(name = "sid"))
	@Column(name = "reference")
	private Map<String, String> reference;

}
