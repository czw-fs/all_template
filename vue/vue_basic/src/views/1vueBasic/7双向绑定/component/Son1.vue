<script setup>
  //接受父组件的传参，可以直接改变父组件的值
  const myModel = defineModel("myName")
</script>

<template>

  <div>
    Son:<input v-model="myModel">
  </div>

</template>

<style scoped>

</style>