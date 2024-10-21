<script setup>
// 1.文本插值

const msg = "hello world!"

// 2.原始 HTML
const myHtml = "<h1>hello world!</h1>"

//3.使用 JavaScript 表达式
const ok = true

//4.{{}}中调用函数
function showOk() {
  return "showOk";
}

//6.动态参数
// const url = "https://www.baidu.com"
const url = "https://m.jd.com/"

</script>

<template>
  <div>{{ msg }}</div>
  <div v-html="myHtml"></div>

  <div>{{ ok ? 'YES' : 'NO' }}</div>
  <div>{{ showOk() }}</div>

  <a :href="url">baidu or jingdong</a>
</template>
