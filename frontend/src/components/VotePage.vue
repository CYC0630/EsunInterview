<template>
	<div v-for="poll in polls" :key="poll.id" class="poll-item">
		<h2>{{ poll.title }}</h2>
		<p>{{ poll.description }}</p>
		<div v-for="option in poll.options" :key="option.index" class="poll-option">
			<button @click="voteFor(poll.id, option.id)">{{ option.text }}</button>
		</div>
	</div>
</template>

<script>
import axios from "axios";

export default {
	name: "VotePage",
	data() {
		return {
			polls: [], // 從後端獲取投票列表
		};
	},
	methods: {
		fetchPolls() {
			axios.get("http://localhost:8080/api/polls/ongoing")
				.then(response => this.polls = response.data)
				.catch(error => console.error("獲取投票列表時發生錯誤:", error));
		},
		voteFor(pollID, optionID) {
			axios.post("http://localhost:8080/api/polls/vote", {
				pollID: pollID,
				optionID: optionID,
			}).catch(error => {
				alert("投票失敗！");
				console.error("投票失敗！", error);
			});
		}
	},
	mounted() {
		this.fetchPolls();
	},
}
</script>