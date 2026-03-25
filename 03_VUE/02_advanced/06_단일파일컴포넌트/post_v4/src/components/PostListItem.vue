<template>
  <li class="post-item-wrapper">
    <!-- 게시글 제목 표시 -->
    <PostHeader
      :post="post"
      :is-open="isOpen"
      @toggle-post="togglePost"
    ></PostHeader>
    <!-- 게시글 내용 -->
    <PostDetail
      :is-open="isOpen"
      :is-edit="isEdit"
      :post="post"
      :edit-post="editPost"
      @start-edit="startEdit"
      @update-post="updatePost"
      @delete-post="deletePost"
      @close-post="closePost"
    ></PostDetail>
  </li>
</template>

<script setup>
import PostHeader from './PostHeader.vue';
import PostDetail from './PostDetail.vue';

// 부모한테 있는 이벤트 정의
const emit = defineEmits([
  'toggle-post',
  'start-edit',
  'update-post',
  'delete-post',
  'close-post',
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
  emit('toggle-post', no);
};
const startEdit = (post) => {
  emit('start-edit', post);
};
const updatePost = (editPost) => {
  emit('update-post', editPost);
};
const deletePost = (no) => {
  emit('delete-post', no);
};
const closePost = () => {
  emit('close-post');
};
</script>

<style lang="scss" scoped></style>
