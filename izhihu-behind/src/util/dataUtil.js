import Vue from 'vue'
export default new Vue({
  data: {
  },
  methods: {
    getStrData: function (time) { // Mon Oct 23 2017 00:00:00 GMT+0800 转 2017-10-23
      var d = new Date(time)
      let date = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' + d.getHours() + ':' + d.getMinutes() + ':' + d.getSeconds()
      return date
    },
    parserDate: function (data) { // 2017-10-23 转Mon Oct 23 2017 00:00:00 GMT+0800
      var t = Date.parse(data.toString())
      if (!isNaN(t)) {
        return new Date(Date.parse(data.toString().replace(/-/g, '/')))
      } else {
        return '' // 无则返回null
      }
    }
  }
})
