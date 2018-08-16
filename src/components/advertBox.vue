<template>
  <div>
    <slider class="slider" auto-play="true" interval="2000">
      <div class="frame" v-for="item in bannerList" :key="item.advId">
        <image class="image" resize="cover" :src="item.imgUrl"></image>
      </div>
      <indicator class="indicator"></indicator>
    </slider>
  </div>
</template>

<script>
  var stream = weex.requireModule('stream');
  module.exports = {
    data: function () {
      return {
        bannerList:[]
      }
    },
    created: function() {
      let _this=this;
      let postBody='{"accessToken":"","devid":"80A2C2DB9A4A0ACDF0F62ED0E858D1F5","fromBiz":"MAMA_MOB","fromSystem":"HH_MALL","os":"iPhone OS","seqNo":"982D01FAD448AB167E89AAEBF01B01FD153438760727105032848027161557","ver":"84"}';
      stream.fetch({
        method: 'POST',
        url: "https://m.mama100.com/o2o-web/home/getAdvert",
        body: postBody,
        type:'json',
        headers: {
            'Content-Type': 'application/json',
        }
      }, function(ret) {
        if(!ret.ok){
          _this.bannerList =  [];
        }else{
          _this.bannerList = ret.data.data.advertImageBeans;
        }
      });
    }
  };
</script>

<style scoped>
  .slider,.frame{
    width: 750px;
    height: 450px;
  }
  .slider .image,.image{width:750px;height:450px;}
  .indicator{
    width:750px;
    height:60px;
    item-color: #333;
    item-selected-color: #e06c75;
    item-size:20px;
    justify-content: center;
    align-items:center;
    bottom:0;
  }
</style>