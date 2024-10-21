<script setup>


import {onBeforeMount, onBeforeUnmount, onBeforeUpdate, onMounted, onUnmounted, onUpdated} from "vue";

//在组件被挂载之前被调用
onBeforeMount(() => {{
  console.log("onBeforeMount")
}})

//组件挂载完成后执行，所有同步子组件都已经被挂载 (不包含异步组件或 <Suspense> 树内的组件)。
onMounted(()=> {
  console.log("onMounted")
})



//在组件即将因为响应式状态变更而更新其 DOM 树之前调用，在 Vue 更新 DOM 之前访问 DOM 状态。在这个钩子中更改状态也是安全的。
onBeforeUpdate(()=>{
  console.log("onBeforeUpdate")
})

//在组件因为响应式状态变更而更新其 DOM 树之后调用，不要在 updated 钩子中更改组件的状态，这可能会导致无限的更新循环！
onUpdated(() => {
  console.log("onUpdated")
})



//在组件实例被卸载之前调用，当这个钩子被调用时，组件实例依然还保有全部的功能
onBeforeUnmount(() => {
  console.log("onBeforeUnmount")
})

//在组件实例被卸载之后调用，可以在这个钩子中手动清理一些副作用，例如计时器、DOM 事件监听器或者与服务器的连接
onUnmounted(() => {
  console.log("onUnmounted")
})



</script>

<template>

</template>

<style scoped>

</style>