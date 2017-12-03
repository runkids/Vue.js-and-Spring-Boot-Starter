import Vue from 'vue'
import Router from 'vue-router'
import Vuex from 'vuex'
import axios from 'axios'
import VueAxios from 'vue-axios'
import Home from '@/components/Home'
import ChartRoom from '@/components/ChartRoom'
import ErrorPage from '@/components/ErrorPage'
import SingUp from '@/components/SingUp'
import Count from '@/components/Count'

Vue.use(Router, Vuex, axios)

export default new Router({
  mode: 'history', //URL不顯示#字號
  routes: [{
    path: '/index',
    name: 'index',
    component: Home
  }, {
    path: '/chartroom#:userId',
    name: 'chartroom',
    component: ChartRoom,
  }, {
    path: '/singup',
    name: 'singup',
    component: SingUp,
  }, {
    path: '/count',
    name: 'count',
    component: Count,
  }, {
    path: '*',
    redirect: '/index'
    // name: 'error',
    // component: ErrorPage
  }]
})