<template>
  <div>
    <image class="img" ref="img" style="width: 600px; height: 800px;" src="http://weixin.mama100.cn/wmall/images/mine.jpg
">
    </image>
    
    <text class="button" value="SaveImg" type="primary" @click="save" v-if="plat!=='Web'" >保存</text>
  </div>
</template>

<style scoped>
  .button {
    font-size: 36px;
    width: 200px;
    height:80px;
    line-height:80px;
    margin:30px 275px;
    color: #41B883;
    text-align: center;
    background-color: #f40;
  }
  .img {
    margin: 50px 75px 30px;
  }
</style>

<script>
  var modal = weex.requireModule('modal')
  module.exports = {
    data: function () {
      return {
        plat:weex.config.env.platform
      }
    },
    methods: {
      save: function () {
        if(this.plat!=="Web"){
          this.$refs['img'].save(function(result) {
            if(result.success){
              modal.toast({ message: "保存成功 "})
            }else{
              modal.toast({ message:result.errorDesc})
            }
            
          });
        }else{
          console.log("haha:"+this.plat);
        }
      },
    }
  };
</script>
