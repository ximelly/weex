<template>
  <div>
    <image class="img" ref="img" style="width: 600px; height: 800px;" src="http://weixin.mama100.cn/wmall/images/mine.jpg
">
    </image>
    
    <text class="button" value="SaveImg" type="primary" @click="save">保存</text>
  </div>
</template>

<style scoped>
  .button {
    font-size: 36px;
    width: 200px;
    height:80px;
    line-height:80px;
    margin:30px auto;
    color: #41B883;
    text-align: center;
    background-color: #f40;
  }
  .img {
    margin: 50px auto 30px;
  }
</style>

<script>
  var modal = weex.requireModule('modal')
  module.exports = {
    data: function () {
      return {}
    },
    methods: {
      save: function () {
        if(weex.config.env.platform!=="Web"){
          this.$refs['img'].save(function(result) {
            modal.toast({ message: "Img sava " + result.success + ", " + result.errorDesc})
          });
        }
      },
    }
  };
</script>
