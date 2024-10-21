<script setup>
import {computed, reactive, ref} from "vue";

const library = reactive({
  name: 'city library',
  books: [
    'Vue 2 - Advanced Guide',
    'Vue 3 - Basic Guide',
    'Vue 4 - The Mystery'
  ]
})

//computed()接收一个 getter 函数，返回值为一个计算属性 ref。和其他一般的 ref 类似，你可以通过 publishedBooksMessage.value 访问计算结果。计算属性 ref 也会在模板中自动解包，
//一个计算属性仅会在其响应式依赖更新时才重新计算，计算属性值会基于其响应式依赖被缓存，而方法不会
const hasBook = computed(() => {
  return library.books.length > 0 ? "yes" : "no";
})

//计算属性默认是只读的，要可写，可以通过同时提供 getter 和 setter 来实现
//注意开发中避免修改计算属性
const name = ref("name")
const fullName = computed({
  get() {
    return name.value + "1"
  },
  set(newValue) {
    name.value = name.value + "2"
  }
})

fullName.value = "2"

</script>

<template>
  <div>
    <div>{{ hasBook }}</div>
    <div>
      {{fullName}}
    </div>
  </div>
</template>
