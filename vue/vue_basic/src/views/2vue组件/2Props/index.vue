<script setup>
import Son1 from "@/views/2vue组件/2Props/component/Son1.vue";
import {reactive, ref} from "vue";
import Son2 from "@/views/2vue组件/2Props/component/Son2.vue";
import Son3 from "@/views/2vue组件/2Props/component/Son3.vue";
import Son4 from "@/views/2vue组件/2Props/component/Son4.vue";
import Son5 from "@/views/2vue组件/2Props/component/Son5.vue";

const msg = ref("hello ref props")

const person = reactive({
  age: 18,
  name: "zs"
})

//所有的 props 都遵循着单向绑定原则，props 因父组件的更新而变化，自然地将新的状态向下流往子组件，而不会逆向传递。
//子组件使用props最好再定义一个局部变量来接收！！！

</script>

<template>
  <!--  静态 Props-->
  <Son1 text="hello Props"></Son1>

  <!--  动态 Props-->
  <Son2 :msg="msg"></Son2>

  <!--  对象形式接收-->
  <Son3 title="我是title" :likes="123"></Son3>

<!--  等价于<Son4 :age="person.age" :name="person.name" />-->
  <Son4 v-bind=person></Son4>

  <!--  props校验-->
  <Son5 propG="success"></Son5>


</template>

<style scoped>

</style>