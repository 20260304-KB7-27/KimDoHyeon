<template>
  <div>
    <div class="editBox">
      <input type="text" v-model="editPost.title" />
      <textarea v-model="editPost.content">{{ editPost.content }}</textarea>
    </div>
    <div class="action">
      <button @click="emit('updatePost', editPost)">저장</button>
      <button @click="emit('closePost')">취소</button>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  editPost: {
    no: [Number, String],
    title: String,
    content: String,
  },
});
const emit = defineEmits(['updatePost', 'closePost']);
</script>

<style lang="scss" scoped></style>
