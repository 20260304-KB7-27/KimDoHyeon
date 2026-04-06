<template>
  <div>
    <!-- <h2>좋아요: {{ likeStore.like }}</h2> -->
    <button @click="increment">좋아요 누르기</button>
  </div>
</template>

<script setup>
// import { useLikeStore } from '@/stores/like';
import { useLikePersistStore } from '@/stores/persist/persist_like';

// const likeStore = useLikeStore();
// const { increment } = useLikeStore();

const { increment } = useLikePersistStore();
</script>

<style lang="scss" scoped></style>
