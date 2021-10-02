<script lang="ts">
import { defineComponent, PropType } from 'vue'
import { Alternative } from "../types"
import marker from "../assets/images/marker.png"

export default defineComponent({
  props: {
    alternative: Object as PropType<Alternative>
  },

  setup() {
    return { marker }
  },
})
</script>

<template>
  <ol-source-vector>
    <ol-feature>
      <ol-geom-point :coordinates="alternative.location"></ol-geom-point>
      <ol-style>
        <ol-style-icon :src="marker" :scale="0.1"></ol-style-icon>
      </ol-style>
    </ol-feature>
  </ol-source-vector>
</template>
