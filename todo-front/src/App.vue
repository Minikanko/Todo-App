<template>
  <div id="app">
    <Header/>
      <router-view></router-view>
  </div>
</template>
<style>
 @import './assets/styles/style.css';
</style>
<script>
import Header from './components/layout/Header.vue'

export default {
  name: 'App',
  components: {
    Header,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
