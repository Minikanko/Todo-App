<template>
  <div id="app">
    <Header/>
      <router-view></router-view>
    <!-- <b-container class="bv-example-row">
      
        <b-row align-h="between">
          <b-col cols="4"><calendar/></b-col>
          <b-col cols="7"> 
          
           </b-col>
        </b-row>
    </b-container> -->
  </div>
</template>
<style>
 @import './assets/styles/style.css';
</style>
<script>
import Header from './components/layout/Header.vue'
//import Calendar from './components/layout/Calendar.vue'

export default {
  name: 'App',
  components: {
    Header,
    //Calendar,
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
