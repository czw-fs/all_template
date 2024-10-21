<script setup>

import {computed, reactive, ref} from "vue";
//1.
// 控制 .red是否生效
const isRedBg = ref(true)
// 控制 .wh是否生效
const hasWh = ref(true)

//2.绑定对象
const classObj = reactive({
  red: true,
  wh: true
})

//3.绑定计算属性
const a = ref(true)
const b = ref(true)
const classComputed = computed(() => ({
  red: a.value && b.value,
  wh: a.value && typeof b.value === "boolean"
}))

//4.绑定数组
const classArr = reactive(["red","wh"])

//5.绑定内联样式
const activeColor = ref('red')
const fontSize = ref(30)
const w = ref(100)
const h = ref(100)

</script>

<template>
<div>
  <div :class="{ red: isRedBg,wh: hasWh }"></div>
  <br>

  <div :class="classObj"></div>
  <br>

  <div :class="classComputed"></div>
  <br>

  <div :class="classArr"></div>
  <br>

  <div :style="{ color: activeColor, fontSize: fontSize + 'px' ,width: w,height:h}">111</div>
</div>
</template>

<style scoped>
.red{
  background-color: red;
}
.wh{
  width: 100px;
  height: 100px;
}

</style>