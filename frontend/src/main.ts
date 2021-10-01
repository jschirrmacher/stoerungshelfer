import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHashHistory } from "vue-router"
import MainPage from "./components/MainPage.vue"
import store from './store'
import OpenLayersMap from 'vue3-openlayers'
import 'vue3-openlayers/dist/vue3-openlayers.css'

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
app.use(OpenLayersMap)

app.mount('#app')