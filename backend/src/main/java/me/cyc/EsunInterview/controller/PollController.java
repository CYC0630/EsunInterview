package me.cyc.EsunInterview.controller;

import me.cyc.EsunInterview.dto.PollRequest;
import me.cyc.EsunInterview.dto.VoteRequest;
import me.cyc.EsunInterview.entity.Poll;
import me.cyc.EsunInterview.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/polls")
public class PollController
{
	@Autowired
	private PollService pollService;

	@GetMapping("/ongoing")
	public List<Poll> getOngoingPolls()
	{
		return pollService.getOngoingPolls(); //回傳正在進行中的投票
	}

	@PostMapping("/create")
	public ResponseEntity<Poll> createPoll(@RequestBody PollRequest pollRequest)
	{
		return new ResponseEntity<>(pollService.createPoll(pollRequest), HttpStatus.CREATED);
	}

	@PostMapping("/vote")
	public ResponseEntity<?> vote(@RequestBody VoteRequest voteRequest)
	{
		boolean success = pollService.vote(voteRequest.getPollID(), voteRequest.getOptionID());

		return success ? ResponseEntity.ok(Map.of("message", "投票成功！")) : ResponseEntity.badRequest().body(Map.of("error", "投票失敗。"));
	}
}