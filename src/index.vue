<template>
  <div class="wrapper">
    <advert-box></advert-box>
    <main-nav></main-nav>
  </div>
</template>

<script>
import mainNav from "./components/mainNav.vue";
import advertBox from "./components/advertBox.vue";
export default {
  name: 'App',
  components: {mainNav,advertBox},
  data () {
  	return {};
  }
};
</script>

<style>
</style>
