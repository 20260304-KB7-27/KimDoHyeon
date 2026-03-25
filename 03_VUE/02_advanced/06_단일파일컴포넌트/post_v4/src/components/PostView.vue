<template>
  <div>
    <h2>{{ post.title }}</h2>
    <p>{{ post.content }}</p>

    <div class="action">
      <button @click="emit('start-edit', post)">수정</button>
      <button @click="emit('delete-post', post.no)">삭제</button>
      <button @click="emit('close-post')">닫기</button>
    </div>
  </div>
</template>

<script setup>
const emit = defineEmits(['start-edit', 'delete-post', 'close-post']);
const props = defineProps({
  post: {
    no: [Number, String],
    title: String,
    content: String,
  },
});
</script>

<style lang="scss" scoped></style>
