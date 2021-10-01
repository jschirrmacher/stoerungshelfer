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
      rotation,
      layers: [
        "geofox_workspace:dynamic_stations",
        "geofox_workspace:geofoxdb_stations",
        "geofox_workspace:geofoxdb_strecken_nacht",
        "geofox_workspace:geofoxdb_strecken_normal",
        "geofox_workspace:geofoxdb_strecken_sonderfahrplan",
        "geofox_workspace:geofoxdb_strecken_we_nacht",
        "geofox_workspace:geofoxdb_bundr",
        "geofox_workspace:geofoxdb_cambio",
        "geofox_workspace:geofoxdb_europcar",
        "geofox_workspace:geofoxdb_pundr",
        "geofox_workspace:geofoxdb_switchh_points",
        "geofox_workspace:geofoxdb_zahlgrenzen",
        "geofox_workspace:geofoxdb_zahlgrenzen_gedehnt",
        "geofox_workspace:geofoxdb_zahlgrenzen_gedehnt_nacht",
        "geofox_workspace:geofoxdb_zahlgrenzen_gedehnt_normal",
        "geofox_workspace:geofoxdb_zahlgrenzen_gedehnt_sonderfahrplan",
        "geofox_workspace:geofoxdb_zahlgrenzen_gedehnt_we_nacht",
        "geofox_workspace:geofoxdb_zahlgrenzen_nacht",
        "geofox_workspace:geofoxdb_zahlgrenzen_normal",
        "geofox_workspace:geofoxdb_zahlgrenzen_sonderfahrplan",
        "geofox_workspace:geofoxdb_zahlgrenzen_we_nacht"
      ]
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

    <ol-image-layer :zIndex="1001">
      <ol-source-image-wms url="https://map.geofox.de/geoserver/geofox_workspace/wms" serverType="geoserver" :layers="layers" />
    </ol-image-layer>
  </ol-map>
</template>

<style lang="scss" scoped>
h2 {
  text-align: center;
}
</style>
