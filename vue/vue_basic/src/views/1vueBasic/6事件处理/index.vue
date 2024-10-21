<script setup>

import {ref} from "vue";

const count = ref(0);

//不需要传参
const add1 = () => {
  count.value++
}

//需要传参
const add2 = (num) => {
  count.value += num;
}

//按键事件
const keyStr = ref("")

</script>

<template>

  <div>{{ count }}</div>

  <button @click="count++">add1</button>
  <button @click="add1">add2</button>

<!--  //需要传参-->
  <button @click="() => add2(2)">add2</button>

<!-- 键盘事件 -->
  <input @keydown.enter="add1()">
</template>

<style scoped>

</style>