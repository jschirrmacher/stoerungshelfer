import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHashHistory } from "vue-router"
import MainPage from "./components/MainPage.vue"
import store from './store'

const routes = [
  { path: "/", component: MainPage },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})
const app = createApp(App)

app.use(store)
app.use(router)

app.mount('#app')