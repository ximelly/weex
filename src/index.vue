<template>
  <div>
    <wxc-tab-bar :tab-titles="tabTitles"
                 :tab-styles="tabStyles"
                 title-type="icon"
                 @wxcTabBarCurrentTabSelected="wxcTabBarCurrentTabSelected">
      <!--The first page content-->
      <div class="item-container" :style="contentStyle">
        <home></home>
     </div>
      
      <!--The second page content-->
      <div class="item-container" :style="contentStyle">
        <!-- <web src="https://vuejs.org"></web> -->
        <product-list></product-list>
      </div>
      
      <!-- The third page content-->
      <div class="item-container" :style="contentStyle">
        <web @pagestart="onPageStart" @pagefinish="onPageFinish" @error="onError" src="https://m.baidu.com/" class="web" :style="contentStyle"></web>
      </div>
      
      <!-- The fourth page content-->
      <div class="item-container" :style="contentStyle">
        <mine></mine>
      </div>
    </wxc-tab-bar>
  </div>
</template>

<script>
  import {WxcTabBar, Utils} from 'weex-ui'
  import { TABLES } from './components/type.js'
  import productList from './pages/productList.vue'
  import home from './pages/home.vue'
  import mine from './pages/mine.vue'
  const dom = weex.requireModule('dom')

  export default {
    components: { WxcTabBar, productList, home, mine},
    data:function(){
      return {
        tabTitles: TABLES.tabTitles,
        tabStyles: TABLES.tabStyles
      }
    },
    created () {
      const tabPageHeight = Utils.env.getPageHeight();
      const { tabStyles } = this;
      this.contentStyle = { height: (tabPageHeight - tabStyles.height) + 'px' };
    },
    methods: {
      wxcTabBarCurrentTabSelected (e) {//切换tab
        if(e.page==0){
          //dom.scrollToElement(this.$refs['banner'], {});//通知index页面滑动到顶部
        }
      },
      onPageStart(){
        console.log("显示web页面");
      },
      onPageFinish(){
        console.log("隐藏web页面");
      },
      onError(event){
        console.log(event);
      }
    }
  };
</script>

<style scoped>
  .item-container {
    width: 750px;
    height:1000px;
    background-color: #f2f3f4;
  }
  .web{
    width:750px;
    height:800px;
  }
</style>