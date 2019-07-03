<template>
<!-- 话题页 已关注标签栏 -->
  <div id="topicLabel" @click="selectLabel" :style="list.isSelect?selectStyle:none">
    {{ list.label }}
  </div>
</template>

<script>
export default {
  name: 'topicLabel',
  props: ['list'],
  data () {
    return {
      selectStyle: [
        { 'background': '#259' },
        { 'border-color': '#259' },
        { 'color': '#fff' }
      ]
    }
  },
  methods: {
    selectLabel () {
      this.$emit('selectLabel', this.list.id)
    }
  }
}
</script>

<style lang="scss">
#topicLabel{
    height: 30px;
    width: 70px;
    padding: 0 10px;
    border-radius: 30px;
    border: 1px solid #daecf5;
    background-color: white;
    color: #259;
    float: left;
    margin-bottom: 10px;
    margin-left: 15px;
    text-align:center;
    cursor: pointer;
}

#topicLabel:hover{
    background: #259;
    border-color: #259;
    color: #fff;
}
</style>
