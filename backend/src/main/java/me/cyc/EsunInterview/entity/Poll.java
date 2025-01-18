package me.cyc.EsunInterview.entity;

import java.util.ArrayList;

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
	private List<Option> options = new ArrayList<>();

	// Getters and Setters
}