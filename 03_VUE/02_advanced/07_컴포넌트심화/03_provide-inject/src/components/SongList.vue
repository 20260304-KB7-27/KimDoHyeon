<template>
  <ul>
    <SongListItem v-for="s in songs" :key="s.id" :song="s" :icons="icons" />
  </ul>
  <div>체크된 곡 수 : {{ doneCount }}</div>
</template>

<script setup>
import { inject } from 'vue';
import SongListItem from './SongListItem.vue';
const doneCount = inject('doneCount');
const icons = inject('icons');
defineProps(['songs']);
</script>

<style scoped></style>
