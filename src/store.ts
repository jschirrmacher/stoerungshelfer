import { ActionContext, createStore } from "vuex"

const version = 1

const appInfo = localStorage.getItem("app")
if (!appInfo) {
  localStorage.removeItem("userProfile")
}
localStorage.setItem("app", JSON.stringify({ version }))

const state = {
}

type State = typeof state

const mutations = {
}

export const mutationTypes = {
}

export const actions = {
}

export const actionTypes = {
}

export default createStore({ state, mutations, actions })
