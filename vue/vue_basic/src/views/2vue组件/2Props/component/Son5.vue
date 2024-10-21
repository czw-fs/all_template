<script setup>

//<!--  props校验-->
const props = defineProps({
  //类型未string，不必传，默认值是lisi
  propC: {
    type: String,
    required: false,
    default: 'lisi'
  },

  // 自定义类型校验函数
  propG: {
    /**
     * value：propG的传递值
     * props：父组件传递的所有 props
     */
    validator(value, props) {
      return ['success', 'warning', 'danger'].includes(value)
    }
  },
})

console.log(props.propC, props.propG)

</script>

<template>
  <div>son5</div>
</template>

<style scoped>

</style>