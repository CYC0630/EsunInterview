package me.cyc.EsunInterview.repository;

import me.cyc.EsunInterview.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPollRepository extends JpaRepository<Poll, Long> { }