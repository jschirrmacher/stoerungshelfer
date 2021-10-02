<script lang="ts">
import { defineComponent } from 'vue'
import { mapState } from 'vuex'

export default defineComponent({
  methods: {
    home() {
      this.$router.push("/")
    },
  },
})
</script>

<template>
  <div class="container">
    <header @click="home">
      <h1>Störungshelfer</h1>
    </header>

    <router-view />

    <footer>
      Karte, Strecken und Halte von https://geofox.de/
    </footer>
  </div>
</template>

<style lang="scss">
html {
  font: 20px Avenir, Helvetica, Arial, sans-serif;
}

body, html, #app, .container {
  height: 100%;
  width: 100%;
  position: relative;
}

.container {
  display: flex;
  flex-direction: column;
}

a {
  text-decoration: none;
  color: #348a13;
}

.btn-primary, .btn-primary:hover, .btn-primary:focus {
  background-color: #348a13;
  border-color: #348a13;
}

.btn-list {
  margin-top: 1rem;
  display: flex;
  justify-content: space-between;
  max-width: 500px;
}

@media (max-width: 800px) {
  h1 {
    font-size: 24px;
  }
  h2 {
    font-size: 24px;
  }
}

#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  padding: 10px;
  max-width: 1000px;
  margin: 0 auto;

  header {
    display: flex;
    align-items: center;
    margin: .5rem auto 1rem;
    cursor: pointer;

    img {
      transition: all .5s;
      max-height: 2rem;
    }

    h1 {
      white-space: nowrap;
      margin: 0 0 0 .5rem;
    }

    &.hero {
      text-align: center;
      flex-direction: column;

      img {
        display: inline-block;
        margin: 3rem auto 1rem;
        max-height: 10rem;
      }

      #profile-link {
        display: none;
      }
    }
  }

  footer {
    font-size: 10px;
  }
}
</style>
