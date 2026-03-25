<template>
  <ul>
    <PostListItem
      v-for="post in posts"
      :key="post.no"
      :post="post"
      :isOpen="selectedPostNo === post.no"
      :isEdit="isEdit"
      :editPost="editPost"
      @togglePost="togglePost"
      @closePost="closePost"
      @startEdit="startEdit"
      @updatePost="updatePost"
      @deletePost="deletePost"
    ></PostListItem>
  </ul>
</template>

<script setup>
import PostListItem from './PostListItem.vue';
import { ref } from 'vue';

// 부모가 전달해준 porps 받아오기
const props = defineProps({
  posts: Array,
});
// 부모에게 빌려온 핸들러
const emit = defineEmits(['updatePost', 'deletePost']);

// 선택된 게시글의 번호를 저장(수정하려면 이 vue로 수정값 옮겨줘야 함)
const selectedPostNo = ref(null);
// 글 열고 닫는 토글
const togglePost = (no) => {
  // 이미 열려있는걸 다시 누르면 닫히고(null), 아니면 해당 번호 열기
  selectedPostNo.value = selectedPostNo.value === no ? null : no;
};
const closePost = () => {
  selectedPostNo.value = null;
  isEdit.value = false;
};

// ===========
//  수정
// ===========
// 수정 상태
const isEdit = ref(false);

// 수정용
const editPost = ref({
  no: '',
  title: '',
  content: '',
});

// 수정할 post
const startEdit = (post) => {
  editPost.value.no = post.no;
  editPost.value.title = post.title;
  editPost.value.content = post.content;
  isEdit.value = true;
};

// emit 정의
const updatePost = (post) => {
  emit('updatePost', post);
  isEdit.value = false;
  editPost.value.no = '';
  editPost.value.title = '';
  editPost.value.content = '';
};
const deletePost = (no) => {
  emit('deletePost', no);
};
</script>

<style lang="scss" scoped></style>
