package me.cyc.EsunInterview.dto;

public class VoteRequest
{
	private Long pollID;
	private Long optionID;

	public Long getPollID()
	{
		return pollID;
	}

	public void setPollID(Long pollID)
	{
		this.pollID = pollID;
	}

	public Long getOptionID()
	{
		return optionID;
	}

	public void setOptionID(Long optionID)
	{
		this.optionID = optionID;
	}
}