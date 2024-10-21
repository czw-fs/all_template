<script setup>
//子组件触发父组件事件
import Son1 from "@/views/2vue组件/3组件事件/component/Son1.vue";
const fatherEvent = (a,b)=> {
  console.log(a,b);
}

</script>

<template>
  <Son1 @customEvent="fatherEvent"></Son1>
</template>

<style scoped>

</style>