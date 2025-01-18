package me.cyc.EsunInterview.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Option
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String text;

	@ManyToOne
	@JoinColumn(name = "poll_id")
	private Poll poll;
}