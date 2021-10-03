<script lang="ts">
import { defineComponent, PropType } from 'vue'
import { Alternative } from "../types"
import marker from "../assets/images/marker.png"

export default defineComponent({
  props: {
    alternative: {
      type: Object as PropType<Alternative>,
      required: true
    }
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
        <ol-style-icon :src="marker" :scale="0.5" :anchor="[0.5, 1]"></ol-style-icon>
      </ol-style>
    </ol-feature>
    <ol-feature>
      <ol-geom-line-string :coordinates="alternative.route"></ol-geom-line-string>
        <ol-style>
          <ol-style-stroke color="blue" :width="7" :lineDash="[2,10]"></ol-style-stroke>
        </ol-style>
      </ol-feature>
  </ol-source-vector>
</template>
