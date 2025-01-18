package me.cyc.EsunInterview.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "polls")
public class Poll
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;

	@OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
	private final List<Option> options = new ArrayList<>();

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}