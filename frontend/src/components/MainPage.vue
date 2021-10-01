<script lang="ts">
import { defineComponent } from 'vue'
import { useStore } from 'vuex'

export default defineComponent({
  setup() {
    const store = useStore()

    return { store }
  },
})
</script>

<template>
  <h2>
    Willkommen beim ITS Hack
  </h2>
</template>

<style lang="scss" scoped>
h2 {
  text-align: center;
}
</style>
