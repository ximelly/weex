<template>
  <list @loadmore="fetch" loadmoreoffset="5">
    <header>
      <text class="banner">HEADER</text>
    </header>
    <cell v-for="index in lists" :key="index">
      <div class="panel">
        <text class="text">{{index}}</text>
      </div>
    </cell>
    <loading class="loading" @loading="onloading" :display="loadinging ? 'show' : 'hide'">
      <text class="indicator-text">Loading ...</text>
      <loading-indicator class="indicator"></loading-indicator>
    </loading>
  </list>
</template>

<script>
const modal = weex.requireModule('modal')
const LOADMORE_COUNT = 4;
  export default {
    data () {
      return {
        loadinging:false,
        lists: [1, 2, 3, 4,5]
      }
    },
    methods: {
      fetch (event) {
        setTimeout(() => {
          const length = this.lists.length
          for (let i = length; i < length + LOADMORE_COUNT; ++i) {
            this.lists.push(i + 1);
            this.loadinging = true
            setTimeout(() => {
              this.loadinging = false
            }, 2000)
          }
        }, 800)
      },
      onloading(){
        console.log("加载中~");
      }
    }
  };
</script>

<style scoped>
  .banner {
    width: 750px;
    padding: 25px;
    font-size: 60px;
    text-align: center;
    font-weight: bold;
    color: #41B883;
    background-color: rgb(162, 217, 192);
  }
  .panel {
    width: 600px;
    height: 300px;
    margin-left: 75px;
    margin-top: 35px;
    margin-bottom: 35px;
    flex-direction: column;
    justify-content: center;
    border-width: 2px;
    border-style: solid;
    border-color: rgb(162, 217, 192);
    background-color: rgba(162, 217, 192, 0.2);
  }
  .text {
    font-size: 50px;
    text-align: center;
    color: #41B883;
  }
   .loading {
    width: 750;
    display: -ms-flex;
    display: -webkit-flex;
    display: flex;
    -ms-flex-align: center;
    -webkit-align-items: center;
    -webkit-box-align: center;
    align-items: center;
  }
  .indicator-text {
    color: #888888;
    font-size: 42px;
    text-align: center;
  }
  .indicator {
    margin-top: 16px;
    height: 40px;
    width: 40px;
    color: blue;
  }
</style>
