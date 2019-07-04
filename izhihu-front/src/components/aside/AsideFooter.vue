<template>
  <!-- 首页右侧底部、其他信息 -->
  <div class="aside-footer">
    <a href="">刘看山</a>
    <span>·</span>
    <a href="">i知乎指南</a>
    <span>·</span>
    <a href="">i知乎协议</a>
    <span>·</span>
    <a href="">i知乎隐私指引</a>
    <br>
    <a href="">应用</a>
    <span>·</span>
    <a href="">工作</a>
    <span>·</span>
    <a href="">申请开通知乎机构号</a>
    <br>
    <a href="">侵权举报</a>
    <span>·</span>
    <a href="">网上有害信息举报专区</a>
    <br>
    <a href="">违法和不不良信息举报：010-82716601</a>
    <br>
    <a href="">儿童色情信息举报专区</a>
    <br>
    <a href="">证照中心</a>
    <br>
    <a href="">联系我们</a>
    <span>@2019 i知乎</span>
  </div>
</template>

<script>
export default {
  name: 'asideFooter',
  data () {
    return {

    }
  },
  methods: {

  }
}
</script>

<style lang="scss">
.aside-footer {
  margin-top: 20px;
  padding: 8px;
  color: #8590a6;
  span {
    margin: 0 4px;
    width: 1px;
  }
  a {
    line-height: 25px;
  }
  a:hover {
    text-decoration: none;
    color: #0084ff;
  }
}
</style>
