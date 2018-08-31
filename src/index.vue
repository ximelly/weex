<template>
  <div>
    <wxc-tab-bar :tab-titles="tabTitles"
                 :tab-styles="tabStyles"
                 title-type="icon"
                 @wxcTabBarCurrentTabSelected="wxcTabBarCurrentTabSelected">
      <!--The first page content-->
      <div class="item-container">
        <wxc-minibar background-color="#FFF3CD" @wxcMinibarRightButtonClicked="mine">
          <image src="https://gw.alicdn.com/tfs/TB1Vm3abuuSBuNjy1XcXXcYjFXa-64-64.png"
                 slot="left"
                 style="height: 40px;width: 40px;"></image>
          <text style="font-size: 40px;" slot="middle">mama100</text>
          <text style="font-size: 40px;" slot="right">···</text>
        </wxc-minibar>
        <wxc-popover ref="wxc-popover"
             :buttons="btns"
             :position="popoverPosition"
             :arrowPosition="popoverArrowPosition"
             @wxcPopoverButtonClicked="popoverButtonClicked"></wxc-popover>
        <advert-box></advert-box>
        <div class="fw"><main-nav></main-nav></div>
        <mother-learning></mother-learning>
     </div>
      
      <!--The second page content-->
      <div class="item-container"><text>Hot</text></div>
      
      <!-- The third page content-->
      <div class="item-container"><text>Message</text></div>
      
      <!-- The fourth page content-->
      <div class="item-container"><text>My</text></div>
    </wxc-tab-bar>
  </div>
</template>

<style scoped>
  .item-container {
    width: 750px;
    background-color: #f2f3f4;
    align-items: center;
    justify-content: center;
  }
</style>
<script>
  import {WxcMinibar, WxcTabBar, WxcPopover, Utils} from 'weex-ui'
  import { RETURN_ICON, QRCODE_ICON, QUESTION_ICON, TABLES } from './components/type.js'
  import mainNav from './components/mainNav.vue'
  import advertBox from './components/advertBox.vue'
  import motherLearning from './components/motherLearning.vue'
  const modal = weex.requireModule('modal')

  export default {
    components: { WxcMinibar, WxcTabBar, WxcPopover, mainNav, advertBox, motherLearning },
    data: () => ({
      tabTitles: TABLES.tabTitles,
      tabStyles: TABLES.tabStyles,
      btns: [
        {
          icon: QRCODE_ICON,
          text: 'My Qrcode',
          key: 'key-qrcode'
        },
        {
          icon: QUESTION_ICON,
          text: 'Help',
          key: 'key-help'
        }
      ],
      popoverPosition: {
        x: -7,
        y: 60
      },
      popoverArrowPosition: {
        pos: 'top',
        x: -15
      }
    }),
    created () {
      const tabPageHeight = Utils.env.getPageHeight();
      const { tabStyles } = this;
      this.contentStyle = { height: (tabPageHeight - tabStyles.height) + 'px' };
    },
    methods: {
      mine () {
        this.$refs['wxc-popover'].wxcPopoverShow()
      },
      popoverButtonClicked (obj) {
        modal.toast({ 'message': `key:${obj.key}, index:${obj.index}`, 'duration': 1 })
      },
      wxcTabBarCurrentTabSelected (e) {
        const index = e.page;
        console.log(index);
      }
    }
  };
</script>


<style>
  .item-container {
    width: 750px;
    align-items: center;
    justify-content: center;
  }
  .fw{width:750px;}
</style>