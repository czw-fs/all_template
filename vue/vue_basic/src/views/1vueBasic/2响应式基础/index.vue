<script setup>
//ref() 接收参数，并将其包裹在一个带有 .value 属性的 ref 对象中返回
//在模板中使用 ref 时，我们不需要附加 .value
//4.在模板渲染上下文中，只有顶级的 ref 属性才会被解包。
// ref用于定义基本数据类型的响应式数据
import {reactive, ref} from "vue";

const msg = ref("hello")

// reactive常用于定义对象或数组的响应式数据
const reactiveMsg = reactive({
  name:"zs",
  msg:"hello world"
})


</script>

<template>
  <div>{{ msg}}</div>
  <div>{{reactiveMsg.name}} - {{reactiveMsg.msg}} - {{reactiveMsg}}</div>
</template>


<style>

</style>
