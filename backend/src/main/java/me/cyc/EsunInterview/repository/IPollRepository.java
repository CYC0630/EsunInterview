package me.cyc.EsunInterview.repository;

import me.cyc.EsunInterview.entity.Poll;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPollRepository extends JpaRepository<Poll, Long>
{
	@Query("SELECT * FROM polls")
	List<Poll> findOngoingPolls();
}