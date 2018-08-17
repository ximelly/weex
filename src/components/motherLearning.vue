<template>
	<div class="questionList">
    <div><text class="modelTitle">妈妈们在讨论什么</text></div>
    <div v-for="item in questionList" :key="item.quesId">
      <text class="questionTitle" lines="1">{{item.title}}</text>
      <text class="questionContent">{{item.content}}</text>
    </div>
	</div>
</template>
<style>
  .questionList{
    padding:0 30px;
  }
  .modelTitle{
      color:#636666;
      text-align:center;
      height:100px;
      line-height: 100px;
      margin-top:20px;
  }
  .questionTitle{
    lines: 1;
    text-overflow: ellipsis;
  }
  .questionContent{
    color:#999999;
    line-height:46px;
    lines: 2;
    text-overflow: ellipsis;
    padding-top:20px;
  }
</style>

<script>
  var stream = weex.requireModule('stream');
  module.exports = {
    data: function () {
      return {
        questionList:[]
      };
    },
    created: function() {
      let _this=this;
      stream.fetch({
        method: 'GET',
        url: "https://m.mama100.com/know/questionEssenceListInIndex.do?accessToken=undefined&devid=80A2C2DB9A4A0ACDF0F62ED0E858D1F5&tagId=-1&tsno=27D9FE7FA10772260436D14DD32FFB42153448577588605925553418006261"
      }, function(ret) {
        if(!ret.ok){
          _this.questionList =  [];
        }else{
          _this.questionList = JSON.parse(ret.data).response.allQuestionList;
        }
      });
    }
  };
</script>


