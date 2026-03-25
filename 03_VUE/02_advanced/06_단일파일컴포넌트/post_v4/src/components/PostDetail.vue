<template>
  <div v-if="isOpen" class="post-content">
    <PostView
      v-show="!isEdit"
      :post="post"
      @startEdit="startEdit"
      @deletePost="deletePost"
      @closePost="closePost"
    ></PostView>
    <EditPost
      v-show="isEdit"
      :editPost="editPost"
      @updatePost="updatePost"
      @closePost="closePost"
    ></EditPost>
  </div>
</template>

<script setup>
import EditPost from './EditPost.vue';
import PostView from './PostView.vue';
const props = defineProps({
  isOpen: Boolean,
  isEdit: Boolean,
  post: {
    no: [Number, String],
    title: String,
    content: String,
  },
  editPost: {
    no: [Number, String],
    title: String,
    content: String,
  },
});
const emit = defineEmits([
  'startEdit',
  'updatePost',
  'deletePost',
  'closePost',
]);

// emit 함수 정의
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
