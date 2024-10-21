import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/1',
    name: '1模板语法',
    component: () => import('@/views/1模板语法/index.vue')
  },
  {
    path: '/2',
    name: '2响应式基础',
    component: () => import('../views/2响应式基础/index.vue')
  },
  {
    path: '/3',
    name: '3计算属性',
    component: () => import('../views/3计算属性/index.vue')
  },
  {
    path: '/4',
    name: '4Class与Style绑定',
    component: () => import('../views/4Class与Style绑定/index.vue')
  },
  {
    path: '/5',
    name: '5条件渲染',
    component: () => import('@/views/5条件渲染和列表渲染/index.vue')
  },
  {
    path: '/6',
    name: '6事件处理',
    component: () => import('@/views/6事件处理/index.vue')
  },
  {
    path: '/7',
    name: '7双向绑定',
    component: () => import('@/views/7双向绑定/index.vue')
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
