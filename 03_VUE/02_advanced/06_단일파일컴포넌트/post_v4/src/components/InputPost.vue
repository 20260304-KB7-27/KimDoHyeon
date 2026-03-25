<template>
  <div id="new" @keyup.enter="addPost">
    <input type="text" v-model="newPost.title" placeholder="새 게시글 제목" />
    <input type="text" v-model="newPost.content" placeholder="새 게시글 내용" />
    <button @click="addPost">저장</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const props = defineProps({
  sortedPosts: Array,
});

// 새로운 게시글
const newPost = ref({
  title: '',
  content: '',
});

// 부모에게 전달할 이벤트 설정
const emit = defineEmits(['add-post']);

// 새로운 게시글 추가
const addPost = (e) => {
  // 빈 문자열 예외처리
  if (newPost.value.title === '' || newPost.value.content === '') return;

  // 전할 이벤트, 이벤트에 어떤 정보를 넣어 보낼 것인가?
  emit('add-post', {
    no: props.sortedPosts[0].no + 1,
    title: newPost.value.title,
    content: newPost.value.content,
  });

  // 초기화
  newPost.value.title = '';
  newPost.value.content = '';
};
</script>

<style lang="scss" scoped></style>
