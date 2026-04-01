<template>
  <div class="container">
    <h2>About</h2>
    <p>요청 경로 : {{ route.fullPath }}</p>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
const route = useRoute();
console.log(route);
</script>

<style>
.container {
  text-align: center;
  margin-top: 10px;
}
</style>
