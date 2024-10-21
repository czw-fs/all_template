<script setup>
import {ref} from "vue";

const msg = ref("hello");
</script>

<template>
  <div>{{ msg }}</div>
  <input v-model="msg">
</template>

<style scoped>

</style>