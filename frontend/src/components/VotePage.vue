<template>
	<div v-for="poll in polls" :key="poll.id" class="poll-item">
		<h2>{{ poll.title }}</h2>
		<p>{{ poll.description }}</p>
		<div v-for="option in poll.options" :key="option.index" class="poll-option">
			<button @click="voteFor(poll.id, option.index)">{{ option.text }}</button>
		</div>
	</div>
</template>

<script>
export default {
	name: "VotePage",
	data() {
		return {
			polls: [], // 從後端獲取投票列表
		};
	},
	methods: {
		voteFor(id, optionIndex) {
			console.log(id + " " + optionIndex)
		}
	}
}
</script>