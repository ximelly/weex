<template>
	<div class="container">
		<div class="imageList">
			<div v-for="item in imageList" class="imageIcon" :key="item.index" v-if="item.index<=3">
				<image :src="item.url" class="image" />
				<div class="textOut"><text lines="1" class="text">{{item.imageText}}</text></div>
			</div>
		</div>
		<div class="imageList">
			<div v-for="item in imageList" class="imageIcon" :key="item.index" v-if="item.index>3">
				<image :src="item.url" class="image" />
				<div class="textOut"><text lines="1" class="text">{{item.imageText}}</text></div>
			</div>
		</div>
	</div>
</template>
<style>
  .container{background-color:#ffffff;}
  .imageList{
    flex-direction: row;
    height:160px;
    margin-top:20px;
  }
  .imageIcon {
    flex:1;
    justify-content: center;
    align-items:center;
  }
  .image{width:90px;height:90px}
  .textOut{margin-top:20px;}
  .text{font-size:26px;}
</style>

<script>
module.exports = {
  data: function () {
    const imageHead = 'https://img2.mama100.com/o2oHomePage/201712/2c918082604496630160530c57'
    const textList = ['积分商城', '跨境购', '天天赚', '超级礼遇', '百分妈妈课堂', '孕育工具', '问专家', '在线咨询']
    const imageList = []
    const imageLast= ['440057', '4b0058', '4d0059', '51005a', '61005b', '64005c', '73005d', '76005e']
    for (let i = 0; i < textList.length; i++) {
      imageList.push({ index: i, url: (imageHead + imageLast[i] + '.png'), imageText: textList[i] })
    }
    return {
      imageList: imageList
    };
  }
};
</script>
