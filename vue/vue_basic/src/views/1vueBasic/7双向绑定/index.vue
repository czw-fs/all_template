<script setup>
import {ref} from "vue";
import Son1 from "@/views/1vueBasic/7双向绑定/component/Son1.vue";

//v-model="动态响应值"，只能对标签的value属性进行绑定
const msg = ref("hello");

//v-model:参数="动态响应值" 语法用于双向绑定自定义组件的属性，不能对原生html使用
const myRealName = ref("abc");

//
/**
 * 修饰符
 * .trim去首位空白
 * .number 用户输入的值自动转换为数值类型。
 * .lazy 输入框失去焦点或用户按下回车键才更新
 */
</script>

<template>
  <div>{{ msg }}</div>
  <input v-model="msg">
<br>
<br>
  Base:{{myRealName}}
  <Son1 v-model:myName="myRealName"></Son1>
</template>

<style scoped>

</style>