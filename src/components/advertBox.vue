<template>
  <div>
    <slider class="slider" auto-play="true" interval="2000">
      <div class="frame" v-for="item in bannerList">
        <image class="image" resize="cover" :src="item"></image>
      </div>
      <indicator class="indicator"></indicator>
    </slider>
  </div>
</template>

<script>
  module.exports = {
    data: function () {
        const bannerHead="http://img2.mama100.com/adBigPic/201808/2c91808264ef01c0016";
        const bannerList = [];
        const bannerLast= ['4ff069e170065','522d1082e00ac','50cfc475e006c','5315dd85a00b6','531629a4600b8','5316101ca00b7','51d58975200a7'];
        for (let i = 0; i < bannerLast.length; i++) {
          bannerList.push(bannerHead+bannerLast[i]+'.jpg');
        }
      return {
        bannerList:bannerList
      };
    }
  };
</script>

<style>
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