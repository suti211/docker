import Vue from 'vue'
import Router from 'vue-router'
import Main from './components/Main/MainComponent.vue'
import Login from './components/Login/Login.vue'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'home',
            component: Main
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        }
    ]
})
