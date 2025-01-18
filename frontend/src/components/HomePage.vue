<template>
	<div class="homepage">
		<button @click="goToPage('vote')">投票</button>
		<button @click="goToPage('edit')">後台</button>
	</div>
</template>

<script>
	export default {
		name: "HomePage",
		methods: {
			goToPage(page) {
				this.$router.push(`/${page}`);
			}
		}
	}
</script>