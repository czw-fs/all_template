<script setup>

//注意是@后面的字符串
const emits = defineEmits(['customEvent'])

const BaseEvent = ()=> {
  //第一个参数，方法名
  //后面的参数都是给父方法的传参
  emits("customEvent","hello father event","hahaha")
}
</script>

<template>
  <div>
    <button @click="BaseEvent">Click Me to Father event</button>
  </div>
</template>

<style scoped>


</style>