package me.cyc.EsunInterview.service;

import me.cyc.EsunInterview.dto.PollRequest;
import me.cyc.EsunInterview.entity.Option;
import me.cyc.EsunInterview.entity.Poll;
import me.cyc.EsunInterview.repository.IOptionRepository;
import me.cyc.EsunInterview.repository.IPollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PollService
{
	private final IPollRepository pollRepository;
	private final IOptionRepository optionRepository;

	@Autowired
	public PollService(IPollRepository pollRepository, IOptionRepository optionRepository)
	{
		this.pollRepository = pollRepository;
		this.optionRepository = optionRepository;
	}

	public List<Poll> getOngoingPolls()
	{
		return pollRepository.findOngoingPolls();
	}

	public Poll createPoll(@RequestBody PollRequest pollRequest)
	{
		Poll poll = new Poll();
		poll.setTitle(pollRequest.getTitle());
		poll.setDescription(pollRequest.getDescription());

		Poll savedPoll = pollRepository.save(poll);

		for (String optionText : pollRequest.getOptions())
		{
			Option option = new Option();
			option.setPoll(savedPoll);
			option.setText(optionText);
			optionRepository.save(option);
		}

		return savedPoll; // 返回創建的投票問題
	}

	public boolean vote(Long pollID, Long optionID)
	{
		return true;
	}
}