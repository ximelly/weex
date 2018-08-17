<template>
  <div class="wrapper">
    <advert-box></advert-box>
    <main-nav></main-nav>
    <mother-learning></mother-learning>
  </div>
</template>

<script>
import mainNav from "./components/mainNav.vue";
import advertBox from "./components/advertBox.vue";
import motherLearning from "./components/motherLearning.vue";
export default {
  name: 'App',
  components: {mainNav,advertBox,motherLearning},
  data () {
  	return {};
  }
};
</script>

<style>
</style>
