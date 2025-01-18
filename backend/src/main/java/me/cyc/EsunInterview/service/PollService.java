package me.cyc.EsunInterview.service;

import me.cyc.EsunInterview.entity.Poll;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService
{
	public List<Poll> getOngoingPolls()
	{
		return List.of();
	}

	public boolean vote(Long pollID, Long optionID)
	{
		return true;
	}
}