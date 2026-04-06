<template>
  <h1>App</h1>
  <Like></Like>
  <h2>좋아요 갯수: {{ like.like }}</h2>
  <h2>5배씩 불려서 좋아요 보기: {{ like.fivetime }}</h2>
  <hr />
  <h2>App에서 보는 Counter: {{ counter.count }}</h2>
  <Counter></Counter>
</template>

<script setup>
// import { useCounterStore } from './stores/counter';
import { useCounterPersistStore } from './stores/persist/persist_counter';

// import { useLikeStore } from './stores/like';
import { useLikePersistStore } from './stores/persist/persist_like';
import Counter from './components/Counter.vue';
import Like from './components/Like.vue';

// const counter = useCounterStore();
const counter = useCounterPersistStore();
// const like = useLikeStore();
const like = useLikePersistStore();
</script>

<style lang="scss" scoped></style>
