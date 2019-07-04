<template>
<!-- 评论组件 -->
  <div id="commentMain">
    wqeqweqweqwe
  </div>
  
</template>

<script>
export default {
  name: 'commentMain',
  el: 'commentMain',
  data () {
    return {
    }
  },
  methods: {
    handleComment () {
      let params = {
        commentId: '',
        isReply: '',
        replyId: '',
        commentatorId: '',
        commentContent: '',
      }
    } 
  }
}
</script>

<style lang="scss">
.commentMain {
}
</style>
