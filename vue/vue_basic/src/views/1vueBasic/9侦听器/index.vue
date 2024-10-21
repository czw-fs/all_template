<script setup>
import {ref, watch, watchEffect} from "vue";

/**
 * watch(source, callback, options?)
 * source：监听的数据
 * callback：source变化时调用的函数
 * options：watch的一些配置选项，例如immediate、deep、flush等。
 */
//1.基本使用
const count = ref(0)
const countCallback = (newCountValue, oldCountValue) => {
  console.log(newCountValue, oldCountValue)
}
watch(count, countCallback)

//2.{deep:true}：监听引用数据类型
//3.{ once: true }，一次性侦听器
//4.{ immediate: true }：watch在组件创建时立即执行一次回调函数
//5.{flush: 'post'} 回调函数的执行时机，默认情况：DOM 更新完成在执行 watch 回调，flush: 'sync'：数据变化，立即执行回调，flush: 'pre'：在 DOM 更新前执行

//6.watch(count,countCallback)适用于count是ref，watch(()=> count,countCallback)适用于监听对象某个属性的变化。

//7.监听多个参数
const count1 = ref(0)
const count2 = ref(0)
const countCallback2 = ([oneNewValue, twoNewValue], [oneOldValue, twoOldValue]) => {
  console.log(oneNewValue, oneOldValue)
  console.log(twoNewValue, twoOldValue)
}
watch([count1, count2], countCallback2)

//8.监听参数在回调中使用了则可使用watchEffect()简化
const todoId = ref(1)
const data = ref(null)
watchEffect(async () => {
  const response = await fetch(
      `https://jsonplaceholder.typicode.com/todos/${todoId.value}`
  )
  data.value = await response.json()
})

</script>

<template>
  <div>{{ count }}</div>
  <button @click="count++">add</button>

  <div>{{ count1 }}</div>
  <div>{{ count2 }}</div>
  <button @click="count1++">count1add</button>
  <button @click="count2++">count2add</button>
</template>

<style scoped>

</style>