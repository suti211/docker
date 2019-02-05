import Vue from 'vue'
import Router from 'vue-router'
import Main from './components/main/MainComponent.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Main
    },
  ]
})
