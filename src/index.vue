<template>
  <div>
    <wxc-tab-bar :tab-titles="tabTitles"
                 :tab-styles="tabStyles"
                 title-type="icon"
                 @wxcTabBarCurrentTabSelected="wxcTabBarCurrentTabSelected">
      <!--The first page content-->
      <div class="item-container" :style="contentStyle">
        <index></index>
     </div>
      
      <!--The second page content-->
      <div class="item-container" :style="contentStyle">
        <!-- <web src="https://vuejs.org"></web> -->
        <my-source></my-source>
      </div>
      
      <!-- The third page content-->
      <div class="item-container" :style="contentStyle"><text>Message</text></div>
      
      <!-- The fourth page content-->
      <div class="item-container" :style="contentStyle"><text>My</text></div>
    </wxc-tab-bar>
  </div>
</template>

<script>
  import {WxcTabBar, Utils} from 'weex-ui'
  import { TABLES } from './components/type.js'
  import mySource from './pages/mySource.vue'
  import index from './pages/index.vue'
  const dom = weex.requireModule('dom')

  export default {
    components: { WxcTabBar, mySource, index},
    data: () => ({
      tabTitles: TABLES.tabTitles,
      tabStyles: TABLES.tabStyles
    }),
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
    }
  };
</script>

<style scoped>
  .item-container {
    width: 750px;
    height:1000px;
    background-color: #f2f3f4;
  }
</style>