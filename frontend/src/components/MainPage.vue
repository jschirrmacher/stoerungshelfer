<script lang="ts">
import { defineComponent, Ref, ref } from "vue"
import { useStore } from "vuex"
import { Alternative } from "../types"
import Disruption from "./Disruption.vue"
import Alternatives from "./Alternatives.vue"
import Provider from "./Provider.vue"

export default defineComponent({
  setup() {
    const store = useStore()
    const center = ref([9.99, 53.55])
    const projection = ref('EPSG:4326')
    const zoom = ref(15)
    const rotation = ref(0)
    const activeAlternative = ref(null) as Ref<Alternative | null>
    const disruption = { location: [9.9940519, 53.5522684] }
    const alternatives = [
        { id: "1",
          description: "Mit dem StadtRAD ab Ballindamm",
          distance: 1,
          location: [9.995239, 53.552372],
          provider: "callABike",
          route: [disruption.location, [9.994254, 53.55227], [9.99455, 53.552122], [9.995239, 53.552372]]
        },
        {
          id: "2",
          description: "Mit einem Lime eTretroller ab Jungfernsteg",
          distance: 2,
          location: [9.992468, 53.553239],
          provider: "lime",
          route: [disruption.location, [9.992468, 53.553239]]
        },
        { id: "3",
          description: "Mit dem Taxi ab Gänsemarkt",
          distance: 8,
          location: [9.988247, 53.555491],
          provider: "taxi",
          route: [disruption.location, [9.990721, 53.554444], [9.989145, 53.555248], [9.988247, 53.555491]]
        },
      ]

    return {
      store,
      center,
      projection,
      zoom,
      rotation,
      activeAlternative,
      disruption,
      alternatives,
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
      ],
    }
  },

  components: { Disruption, Alternatives, Provider },

  methods: {
    selectAlternative(alternative: Alternative) {
      this.activeAlternative = alternative
    }
  }
})
</script>

<template>
  <div class="wrapper">
    <ol-map :loadTilesWhileAnimating="true" :loadTilesWhileInteracting="true" style="height:100%" :pixelRatio="2">
      <ol-view ref="view" :center="center" :rotation="rotation" :zoom="zoom" :projection="projection" />
      <ol-tile-layer>
        <ol-source-osm url="https://map.geofox.de/tiles/{z}/{x}/{y}.png" />
      </ol-tile-layer>

      <ol-image-layer :zIndex="1001">
        <ol-source-image-wms url="https://map.geofox.de/geoserver/geofox_workspace/wms" serverType="geoserver" :layers="layers" format="image/svg+xml" attributions="geofox.de" :ratio="1" />
      </ol-image-layer>

      <ol-vector-layer :zIndex="1002">
        <Disruption :coordinate="disruption.location" />
      </ol-vector-layer>
      <ol-vector-layer :zIndex="1003" v-if="activeAlternative">
        <Provider v-if="activeAlternative" :alternative="activeAlternative" />
      </ol-vector-layer>
    </ol-map>

    <h4>Alternativen</h4>
    <Alternatives :alternatives="alternatives" :active="activeAlternative" @selected="selectAlternative" />
  </div>
</template>

<style lang="scss" scoped>
.wrapper {
  display: flex;
  flex-direction: column;
  height: 100%
}

h4 {
  font-size: 18px;
  font-weight: bold;
}
</style>
