<script lang="ts">
import { defineComponent } from 'vue'
import { mapState } from 'vuex'

export default defineComponent({
  data() {
    return {
      splash: true,
    }
  },

  mounted() {
    setTimeout(() => this.splash = false, 2000)
  },

  computed: {
    ...mapState(["maxMainImg"])
  },

  methods: {
    home() {
      this.$router.push("/")
    },
  },
})
</script>

<template>
  <div v-if="splash" class="splash">
    <!-- <img src="./assets/splash-screen.png" /> -->
  </div>

  <template v-else>
    <header class="container" :class="{ hero: maxMainImg }" @click="home">
      <!-- <img class="logo" alt="ITS Hack Logo" src="./assets/splash-screen.png" /> -->
      <h1>ITS Hack</h1>
    </header>

    <main>
      <router-view />
    </main>

    <!-- <Footer /> -->
  </template>
</template>

<style lang="scss">
html {
  font: 20px Avenir, Helvetica, Arial, sans-serif;
}

body {
  height: 100%;
  overflow: auto;

  main {
    padding-bottom: 4em;
  }
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

  .splash {
    width: 1000px;
    max-width: 100%;
    margin: 0 auto;

    img {
      width: 100%;
      padding: 3rem;
    }
  }

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
}
</style>
