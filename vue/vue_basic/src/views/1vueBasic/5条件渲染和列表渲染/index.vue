<script setup>
import {ref} from "vue";
//条件渲染
const key = ref(3);
const showKey = ref(true);

//列表渲染
const reactiveArr = ref(["a","b","c","d"]);
/**
 * push() 尾插
 * pop() 尾删
 * shift() 头删
 * unshift() 头插
 * splice(index1，num，item1，item2.。。)从index1开始（包括index1）往后的第num个元素替换为item1，item2.。。
 * sort() 排序
 * reverse() 反转数组
 */

</script>

<template>
  <div>
<!--    只会在指令的表达式返回真值时才被渲染。-->
    <div v-if="key == 1">v-if</div>
    <div v-else-if="key == 2">v-else-if</div>
    <div v-else>v-else</div>
    <div v-show="showKey">show</div>

<!--    无索引-->
    <div v-for="item in reactiveArr">
      {{ item }}
    </div>
    <br>

<!--  有索引  -->
    <div v-for="(item,index) in reactiveArr">
      {{ item }}-{{index}}
    </div>

<!--    建议加上key，key 的值应该在同一个列表中是唯一的，并且在每次渲染时都应保持不变-->
    <div v-for="(item,index) in reactiveArr" :key="item">
      {{ item }}-{{index}}
    </div>
  </div>
</template>

<style scoped>

</style>