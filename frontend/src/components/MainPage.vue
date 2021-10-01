<script lang="ts">
import { defineComponent, ref } from 'vue'
import { useStore } from 'vuex'

export default defineComponent({
  setup() {
    const store = useStore()
    const center = ref([10.03, 53.55])
    const projection = ref('EPSG:4326')
    const zoom = ref(14)
    const rotation = ref(0)
    return {
      store,
      center,
      projection,
      zoom,
      rotation
    }
  },
})
</script>

<template>
  <ol-map :loadTilesWhileAnimating="true" :loadTilesWhileInteracting="true" style="height:600px">
    <ol-view ref="view" :center="center" :rotation="rotation" :zoom="zoom" :projection="projection" />
    <ol-tile-layer>
      <ol-source-osm />
    </ol-tile-layer>
  </ol-map>
</template>

<style lang="scss" scoped>
h2 {
  text-align: center;
}
</style>
