import { createRouter, createWebHistory } from "vue-router"
import HomePage from "../components/HomePage.vue"
import VotePage from "../components/VotePage.vue"
import EditPage from "../components/EditPage.vue"

const routes = [
  { path: "/", component: HomePage },
  { path: "/vote", component: VotePage },
  { path: "/edit", component: EditPage },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ "../views/AboutView.vue")
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
