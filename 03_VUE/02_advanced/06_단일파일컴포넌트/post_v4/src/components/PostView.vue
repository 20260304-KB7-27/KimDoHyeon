<template>
  <div>
    <h2>{{ post.title }}</h2>
    <p>{{ post.content }}</p>

    <div class="action">
      <button @click="emit('startEdit', post)">수정</button>
      <button @click="emit('deletePost', post.no)">삭제</button>
      <button @click="emit('closePost')">닫기</button>
    </div>
  </div>
</template>

<script setup>
const emit = defineEmits(['startEdit', 'deletePost', 'closePost']);
const props = defineProps({
  post: {
    no: [Number, String],
    title: String,
    content: String,
  },
});
</script>

<style lang="scss" scoped></style>
