<script lang="ts">
import { defineComponent, ref } from "@vue/runtime-core";

export default defineComponent({
  props: {
    coordinate: Array
  },

  setup() {
    const radius = ref(10)
    return { radius }
  },

  mounted() {
    this.update()
  },

  methods: {
    update() {
      this.radius = ((this.radius + .3) % 10) + 10
      requestAnimationFrame(this.update)
    }
  }

})
</script>

<template>
  <ol-source-vector>
    <ol-feature>
      <ol-geom-point :coordinates="coordinate"></ol-geom-point>
      <ol-style>
        <ol-style-circle :radius="radius">
          <ol-style-fill color="red"></ol-style-fill>
          <ol-style-stroke color="black" :width="3" ></ol-style-stroke>
        </ol-style-circle>
      </ol-style>
    </ol-feature>
  </ol-source-vector>
</template>