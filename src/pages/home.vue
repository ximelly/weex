<template>
  <div>
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
    <scroller :style="contentStyleInner" class="home_scroll">
      <advert-box ref="banner"></advert-box>
      <main-nav></main-nav>
      <mother-learning></mother-learning>
    </scroller>
  </div>
</template>

<script>
import {WxcMinibar, WxcPopover, Utils} from 'weex-ui'
import { RETURN_ICON, QRCODE_ICON, QUESTION_ICON, TABLES } from '../components/type.js'
import mainNav from '../components/mainNav.vue'
import advertBox from '../components/advertBox.vue'
import motherLearning from '../components/motherLearning.vue'
const modal = weex.requireModule('modal')
const modalEvent = weex.requireModule('event')
//原生模块引用
const phoneModule = weex.requireModule('phoneModule')
const logModule = weex.requireModule("logModule")
module.exports = {
    components: { WxcMinibar, WxcPopover, mainNav, advertBox, motherLearning },
    data: function () {
      return {
        content: "haha",
        btns: [
          {
            icon: QRCODE_ICON,
            text: '获取网络信息',
            key: 'key-qrcode'
          },
          {
            icon: QUESTION_ICON,
            text: '获取设备信息',
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
      }
    },
    created(){
      const tabPageHeight = Utils.env.getPageHeight();
      this.contentStyleInner = { height: (tabPageHeight-210) + 'px' };
    },
    methods: {
      mine () {
        this.$refs['wxc-popover'].wxcPopoverShow()
      },
      popoverButtonClicked (obj) {
        if(obj.index===0){
          this.getNetStatus();
        }else{
          this.getPhoneInfo();
          modal.toast({ 'message': `key:${obj.key}, index:${obj.index}`, 'duration': 1 })
        }
      },
      //测试js调用原生方法
      getPhoneInfo: function() {
        logModule.log("测试js调用原生方法");
        var that = this;
        phoneModule.getPhoneInfo(function (event) { 
            var object = JSON.stringify(event);
            logModule.log("getPhoneInfo:"+object);
            var obj =JSON.parse(event);
            that.target  = "getPhoneInfo="+event;
            modal.toast({
              message: '客户端获取手机信息： '+that.target,
              duration: 10
            });
          });
      },
      getNetStatus: function() {
        phoneModule.isNetworkConnected(function(event){
          var obj =JSON.parse(event);
          logModule.log(obj.isConnected);//0表示未连接，1，已连接
          logModule.log(obj.isConnected==1);
          logModule.log('网络类型：'+obj.netType);
          var object = obj.isConnected=='1'?'网络已连接':'网络未连接';
          modal.toast({
             message: '客户端网络状态： '+object+' 网络类型：'+obj.netType,
             duration: 10
           });
        });
      },
      //测试weex是否支持某些模块和功能
      testSupports: function() {
          var net = weex.supports('@module/stream')  // true
          var my = weex.supports('@module/MyMoudle')  // true
          var dialog = weex.supports('@module/WeexDialogModule')  
          var duqian = weex.supports('@module/MyMoudle.duqian')  // false
          var mytest = weex.supports('@module/duqian')  // false
          console.log("net", net);
          modal.toast({
            message:"是否有MyMoudle="+my+",dialog="+dialog+",是否支持stream= "+net+",mytest="+mytest,
            duration: 10
          });
      }
    }
  };
</script>

<style scoped>
  .home_scroll{padding-bottom: 20px;background-color:#fff;}
</style>