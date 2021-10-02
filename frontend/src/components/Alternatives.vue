<script lang="ts">
import { defineComponent, PropType } from 'vue'
import lime from "../assets/images/providers/lime.png"
import callABike from "../assets/images/providers/call-a-bike.png"
import taxi from "../assets/images/providers/taxi.png"
import { Alternative } from "../types"

export default defineComponent({
  setup() {
    return {
      providerIcons: { lime, callABike, taxi } as Record<string, string>,
    }
  },

  props: {
    alternatives: Array as PropType<Alternative[]>
  },

  methods: {
    getIcon(alternative: Alternative) {
      return this.providerIcons[alternative.provider]
    }
  }
})
</script>

<template>
  <ul class="alternatives">
    <li v-for="alternative in alternatives" :key="alternative.id" @click="$emit('selected', alternative)">
      <div><img :src="getIcon(alternative)">{{ alternative.description }}</div>
    </li>
  </ul>
</template>

<style lang="scss" scoped>
.alternatives {
  list-style: none;
  padding: 0;

  li {
    width: 100%;
    font-size: .8rem;

    &:hover {
      background-color: #f0f0f0;
    }

    img {
      width: 18px;
      margin: 0 .3rem;
      position: relative;
      top: -2px;
    }
  }

}
</style>