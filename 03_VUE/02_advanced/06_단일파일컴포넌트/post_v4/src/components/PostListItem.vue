<template>
  <li class="post-item-wrapper">
    <!-- 게시글 제목 표시 -->
    <PostHeader
      :post="post"
      :isOpen="isOpen"
      @togglePost="togglePost"
    ></PostHeader>
    <!-- 게시글 내용 -->
    <PostDetail
      :isOpen="isOpen"
      :isEdit="isEdit"
      :post="post"
      :editPost="editPost"
      @startEdit="startEdit"
      @updatePost="updatePost"
      @deletePost="deletePost"
      @closePost="closePost"
    ></PostDetail>
  </li>
</template>

<script setup>
import PostHeader from './PostHeader.vue';
import PostDetail from './PostDetail.vue';

// 부모한테 있는 이벤트 정의
const emit = defineEmits([
  'togglePost',
  'startEdit',
  'updatePost',
  'deletePost',
  'closePost',
]);

// 부모한테 받은 props 정의
const props = defineProps({
  post: {
    no: [Number, String],
    title: String,
    content: String,
  },
  isOpen: Boolean,
  isEdit: Boolean,
  editPost: {
    no: [Number, String],
    title: String,
    content: String,
  },
});

// emit 함수 정의
const togglePost = (no) => {
  emit('togglePost', no);
};
const startEdit = (post) => {
  emit('startEdit', post);
};
const updatePost = (editPost) => {
  emit('updatePost', editPost);
};
const deletePost = (no) => {
  emit('deletePost', no);
};
const closePost = () => {
  emit('closePost');
};
</script>

<style lang="scss" scoped></style>
